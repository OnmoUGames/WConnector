package com.onmo.wgames.sdk.impl.handler;

import android.os.Handler;

import com.onmo.wgames.sdk.CacheCriteriaType;
import com.onmo.wgames.sdk.ConfigurationParser;
import com.onmo.wgames.sdk.IResponseHandler;
import com.onmo.wgames.sdk.LogApp;
import com.onmo.wgames.sdk.SDKConnector;
import com.onmo.wgames.sdk.SDKException;
import com.onmo.wgames.sdk.Utils;
import com.onmo.wgames.sdk.db.SDKParamCache;
import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;

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

				LogApp.d(TAG," sending back to UI:");
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						uiResponseHandler.handleResponse(localStorageTMEID,CacheCriteriaType.FROM_LIVE);
					}
				});

			}
			else {
				mHandler.post(new Runnable() {
					@Override
					public void run() {
						LogApp.d(TAG," response is null or empty:");
						uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", /*ResponseConstant.ErrorCode.INVALID_TMEID*/5000));

					}
				});
			}
		}else {
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					LogApp.d(TAG," response is null or empty:");
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
					if( mConnector.getConfig(ConfigurationParser.ENABLE_TMEID)!=null &&
							mConnector.getConfig(ConfigurationParser.ENABLE_TMEID).equalsIgnoreCase("true"))
					{
						//HeaderIdentification headerIdentification = new HeaderIdentification();

						try {
							String encryptedText = SampleEncryption.getFakeEncryptTMEID("8343915267288420000");
							LogApp.d(TAG," response encryptedText:"+encryptedText);
							final String localStorageTMEID = SampleEncryption.getLocalTMEID(encryptedText);
							SDKParamCache.setCachedParams(mConnector.getApplicationContext(), SDKParamCache.PREFS_MADE_TMEID, localStorageTMEID);
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									uiResponseHandler.handleResponse(localStorageTMEID, CacheCriteriaType.FROM_LIVE);
								}
							});
						}
						catch (Exception exp)
						{
							LogApp.d(TAG," response is null or empty:");
							uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", 5000/*ResponseConstant.ErrorCode.INVALID_TMEID*/));

						}

					}
					else
					{
						LogApp.d(TAG," response is null or empty:");
						uiResponseHandler.handleException(new SDKException("ErrorCode.INVALID_TMEID", /*ResponseConstant.ErrorCode.INVALID_TMEID*/5000));
					}

				}
				else {
					LogApp.d(TAG, " sending back to UI:");
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
				LogApp.d(TAG, " inside the parse(). userIdStr:" + userIdStr);
			}

		} catch (Exception ex) {
			LogApp.d(TAG," got error inside the parse()"+ex.getMessage());
			return null;
		}

		return userIdStr;
	}

}

