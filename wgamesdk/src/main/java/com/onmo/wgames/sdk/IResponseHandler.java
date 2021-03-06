package com.onmo.wgames.sdk;

/**
 * Created by Srini on 14/02/2018.
 * Comment
 */

public interface IResponseHandler<R> {

	void handleResponse(R result);
	void handleException(SDKException exception);
}
