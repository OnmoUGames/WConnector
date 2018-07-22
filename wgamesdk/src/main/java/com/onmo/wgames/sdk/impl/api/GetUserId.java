package com.onmo.wgames.sdk.impl.api;

import android.database.Cursor;

import com.onmo.wgames.sdk.CacheCriteriaType;
import com.onmo.wgames.sdk.IResponseHandler;
import com.onmo.wgames.sdk.LogApp;
import com.onmo.wgames.sdk.SDKConnector;
import com.onmo.wgames.sdk.core.http.request.IRequestPacket;
import com.onmo.wgames.sdk.core.http.request.RequestPacket;
import com.onmo.wgames.sdk.core.http.request.RequestPacketConstant;
import com.onmo.wgames.sdk.impl.handler.GetUserIdHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Srini on 06/03/2018.
 */

public class GetUserId extends APIBaseHandler {

	private static final String TAG = "GetUserId";
	private SDKConnector mConnector;
	private IResponseHandler<String> responseHandler;



	public GetUserId(SDKConnector connector, IResponseHandler<String> response){
		super(connector, RequestPacketConstant.ServiceKeys.SERVICE_GET_USER_ID);
		this.mConnector = connector;
		this.responseHandler = response;
	}

	public void getUser() {

		LogApp.d(TAG, "getUser() calling initAPIRequest");


		//Cursor cursor = mConnector.getApplicationContext().getContentResolver().query(CONTENT_URI, null, null, null, null);
		Cursor cursor = null;

		if(cursor!=null)
		{
			LogApp.d(TAG, "getUser() calling cursor -->"+cursor.getCount());
			if(cursor!=null) {
				String data =  null;
				cursor.moveToFirst();
				StringBuilder res = new StringBuilder();
				while (!cursor.isAfterLast()) {
					res.append("\n" + cursor.getString(cursor.getColumnIndex("id")) + "-" + cursor.getString(cursor.getColumnIndex("name")));

					data = cursor.getString(cursor.getColumnIndex("name"));
					cursor.moveToNext();

				}

				LogApp.d(TAG, "getUser()  -->"+res);
				//resultView.setText(res);


				if(data!=null) {
					responseHandler.handleResponse(data, CacheCriteriaType.FROM_LIVE);
				}
			}
		}
		else {
			//Uri uri = (UGamesDataProvider.CONTENT_URI);

			initAPIRequest(getRequestPacket(), new GetUserIdHandler(mConnector, responseHandler));
		}



	}


	public IRequestPacket getRequestPacket() {
		/**
		 * Encapsulate all mobile App server specific request at one place
		 */
		IRequestPacket mobileaAppsRequest = new RequestPacket();

		/** 1. set URL */
		mobileaAppsRequest.setUrl(getBaseAPIURL());

		//Send empty parameters for the moment
		Map<String, String> reqParam = new HashMap<String, String>();
		/** set request params */

		mobileaAppsRequest.setRequestParam(reqParam);

		return mobileaAppsRequest;
	}
}
