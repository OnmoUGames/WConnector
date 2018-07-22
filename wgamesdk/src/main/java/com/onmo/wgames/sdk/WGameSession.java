package com.onmo.wgames.sdk;

import android.util.Log;

import com.onmo.wgames.sdk.impl.api.GetUserId;

/**
 * Created by Srini on 14/02/2018.
 */

public class WGameSession implements IWGameSession {

	private WGameAccess credentials;
	private SDKConnector mConnector;

	public WGameSession(SDKConnector connector, WGameAccess credentials) {
		this.mConnector = connector;
		this.credentials = credentials;
	}

	@Override
	public WGameAccess getAccess() {
		return credentials;
	}

	public SDKConnector getConnector() {
		return mConnector;
	}

	@Override
	public void getConfig(IResponseHandler<String> responseHandler) {

		Log.d("WGameSession","getConfig-->");

	}

	@Override
	public void getRegisterUser(IResponseHandler<String> responseHandler) {
		Log.d("WGameSession","getRegisterUser-->");
		GetUserId api = new GetUserId(mConnector, responseHandler);
		api.getUser();
	}

}
