package com.onmo.wgames.sdk;

/**
 * Created by Srini on 14/07/2018.
 * Comment
 */

public interface IWGameSession {

	WGameAccess getAccess();
	void getConfig(IResponseHandler<String> responseHandler);
	void getStoreUser(IResponseHandler<String> responseHandler);
}
