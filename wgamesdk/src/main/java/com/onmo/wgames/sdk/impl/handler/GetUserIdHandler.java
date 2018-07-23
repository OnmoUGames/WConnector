package com.onmo.wgames.sdk.impl.handler;

import android.os.Handler;

import com.onmo.wgames.sdk.IResponseHandler;
import com.onmo.wgames.sdk.LogApp;
import com.onmo.wgames.sdk.SDKConnector;
import com.onmo.wgames.sdk.SDKException;
import com.onmo.wgames.sdk.Utils;
import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.db.SDKParamCache;

import org.json.JSONObject;

import okhttp3.Headers;

/**
 * Created by srini on 6/9/16.
 */
public class GetUserIdHandler implements IHTTPResponseParser {

	private IResponseHandler<String> uiResponseHandler;
	private Handler mHandler;
	private String TAG = "GetUserIdHandler";
	private SDKConnector mConnector;
	public static final String USER_ID = "userId";

	public GetUserIdHandler(SDKConnector connector, IResponseHandler<String> uiHandler) {

		this.uiResponseHandler = uiHandler;
		this.mConnector = connector;
		mHandler = new Handler();

	}


	public void parser(int code, String httpResponseStr, Headers header ) {

		if (!Utils.isStringEmpty(httpResponseStr)) {
			final String response = parse(httpResponseStr);
			if(response!=null && !response.equalsIgnoreCase("null"))
			{
				final String localStorageTMEID = SampleEncryption.getLocalTMEID(response);
				SDKParamCache.setCachedParams(mConnector.getApplicationContext(), SDKParamCache.PREFS_MADE_TMEID, localStorageTMEID);

				mHandler.post(new Runnable() {
					@Override
					public void run() {
						uiResponseHandler.handleResponse(localStorageTMEID);
					}
				});

			}
			else {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", /*ResponseConstant.ErrorCode.INVALID_TMEID*/5000));

					}
				});
			}
		}else {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", /*ResponseConstant.ErrorCode.INVALID_TMEID*/5000));

				}
			});
		}
	}

	@Override
	public void handleException(final int httpResponseCode, final SDKException ex) {

		final SDKException e = ex;

		mHandler.post(new Runnable() {
			@Override
			public void run() {
				if(httpResponseCode ==401) {
					uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", /*ResponseConstant.ErrorCode.INVALID_TMEID*/5000));

				}
				else {
					uiResponseHandler.handleException(e);
				}
			}
		});

	}

	public String parse(String p_Response) {

		String userIdStr =null;
		try {
			JSONObject jsonData = new JSONObject(p_Response);
			if (jsonData.has(USER_ID)) {
				userIdStr = jsonData.getString(USER_ID);
//				LogApp.d(TAG, " inside the parse(). userIdStr:" + userIdStr);
			}

		} catch (Exception ex) {
			LogApp.d(TAG," got error inside the parse()"+ex.getMessage());
			return null;
		}

		return userIdStr;
	}

}

