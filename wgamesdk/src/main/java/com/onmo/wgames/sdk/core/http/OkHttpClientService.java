package com.onmo.wgames.sdk.core.http;

import android.util.Log;


import com.onmo.wgames.sdk.LogApp;
import com.onmo.wgames.sdk.SDKException;
import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.core.http.response.ErrorConstant;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static com.onmo.wgames.sdk.core.http.response.ErrorConstant.ErrorCode.HTTP_RESPONSE_EXCEPTION;


/**
 * @author Srini
 * @version 1.1
 */
public class OkHttpClientService implements Runnable {
	public static final String TAG = "OkHttpClientService";

	/**
     * Main Http client that execute/submit the request
     */

    private OkHttpClient mHttpClient ;
    /**
     * The factory used to generate Http requests for this service
     */
    private final OkHttpMessageFactory mHttpMessageFactory;
    /**
     * Http message object
     */
    private Request mHttpMessage;
    /**
     * A callback to listen for response from server
     */
    private IHTTPResponseParser mIHttpResponseListener;


    private String mUrl;


    public OkHttpClientService(String url, Map<String, String> p_Params, Map<String, String> p_ReqParams,
							   String data, String method, IHTTPResponseParser responseRunnable) {



		this.mHttpClient = OkHttpClientSingleton.getInstance().newBuilder()

				//Set bigger timer than default
				.connectTimeout(20, TimeUnit.SECONDS)
				.writeTimeout(20, TimeUnit.SECONDS)
				.readTimeout(20, TimeUnit.SECONDS)
				.build();


        //Handles generating HttpRequests.

        this.mHttpMessageFactory = new OkHttpMessageFactory();
        submitRequest(  url, p_Params,  p_ReqParams,
                data, method,  responseRunnable);
    }


    @Override
    public void finalize() {
      
        /** SDKExecutorService.getInstance().shutdownNow(); */
    }

    public void submitRequest(String url, Map<String, String> p_Params, Map<String, String> p_ReqParams,
                              String data, String method, IHTTPResponseParser responseRunnable) /*throws URISyntaxException, MethodNotSupportedException*/ {
        try {
            this.mUrl = url.replaceAll(" ", "%20");
			this.mIHttpResponseListener = responseRunnable;
            this.mHttpMessage = this.mHttpMessageFactory.createUsingMethod(this.mUrl, p_Params, p_ReqParams, data, method);

        } catch (Exception e) {
			Log.e(TAG, "submitRequest exception "+e.getMessage());
        }
    }

    /**
     * get called from OS HTTP layer as callback
     *
     *
     */
    @Override
    public void run() {
        Response response = null;

        try {
			String requestUrl = mHttpMessage.url().toString();

            //Submit request to OS HTTP Layer

            response =  mHttpClient.newCall(mHttpMessage).execute();

            if(response!=null) {

                String responseStr;
                boolean isSuccessful = response.isSuccessful();
                int responseCode = response.code();
                if (!isSuccessful) {
                    //Log.d(TAG,"headers -->"+ response.headers().toString());
                    responseStr = response.body().string();

					LogApp.d(TAG,"  Url -->" + requestUrl+"\ncode :" + responseCode+"\n"+responseStr);

                    mIHttpResponseListener.handleException(responseCode, new SDKException(responseStr, responseCode));
                } else {
                    responseStr = response.body().string();

                    LogApp.d(TAG,"  Url -->" + requestUrl+"\ncode :" + responseCode+"\n"+responseStr);

                    Headers responseHeaders = response.headers();


                    if (mIHttpResponseListener != null) {
                        mIHttpResponseListener.parser(responseCode, responseStr, responseHeaders);
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            LogApp.d(TAG," called IOException---->"+ e.getMessage());
                 mIHttpResponseListener.handleException(HTTP_RESPONSE_EXCEPTION,new SDKException(ErrorConstant.getString(HTTP_RESPONSE_EXCEPTION), HTTP_RESPONSE_EXCEPTION));
        } catch (final Exception e) {
			LogApp.d(TAG, " called Exception---->"+e.getMessage());
                 mIHttpResponseListener.handleException(HTTP_RESPONSE_EXCEPTION,new SDKException(ErrorConstant.getString(HTTP_RESPONSE_EXCEPTION), HTTP_RESPONSE_EXCEPTION));
        }
        finally {
            if(response!=null)
            response.close();

        }
    }
}