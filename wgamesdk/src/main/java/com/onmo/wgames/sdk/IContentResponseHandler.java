package com.onmo.wgames.sdk;

/**
 * Created by Srini on 14/02/2018.
 * Comment
 */

public interface IContentResponseHandler<R> {

	void handleResponse(R result, CacheCriteriaType cacheType, String offsetKey);
	void handleException(SDKException exception);
}
