package com.onmo.wgames;

import android.content.Context;
import android.util.Log;

import com.onmo.wgames.sdk.IResponseHandler;
import com.onmo.wgames.sdk.IWGameSession;
import com.onmo.wgames.sdk.OnmoWGSDK;
import com.onmo.wgames.sdk.SDKConnector;
import com.onmo.wgames.sdk.SDKException;
import com.onmo.wgames.sdk.core.http.response.ErrorConstant;

/**
 * Created by Srini on 14/07/2018.
 * Comment
 */

public class Connector {

	private static Connector ourInstance =null;

	private static final String TAG = "Connector";

	private Context mContext;
	private SDKConnector sdkConnector;
	private IWGameSession session;

	public static Connector getInstance() {

		if(ourInstance==null) {
			 ourInstance = new Connector();
		}
		return ourInstance;
	}

	private Connector() {
	}

	public void initConnector(Context context){
		this.mContext = context;
		session = OnmoWGSDK.newInitializerBuilder(mContext).build();

	}

	public void getUser(IResponseHandler<String> listener){

		if (session != null){
			session.getRegisterUser(listener);
		}else{
			listener.handleException(new SDKException(ErrorConstant.getString(ErrorConstant.ErrorCode.SDK_NOT_INITIALIZED), ErrorConstant.ErrorCode.SDK_NOT_INITIALIZED));
		}
	}


	public void getConfig(IResponseHandler<String> listener){

		Log.d(TAG,"getConfig-->");
		if (session != null){
			Log.d(TAG,"getConfig-11->");
			session.getConfig(listener);
		}else{
			Log.d(TAG,"getConfig-22->");
			listener.handleException(new SDKException(ErrorConstant.getString(ErrorConstant.ErrorCode.SDK_NOT_INITIALIZED), ErrorConstant.ErrorCode.SDK_NOT_INITIALIZED));
		}
	}


}
