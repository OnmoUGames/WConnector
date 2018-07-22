package com.onmo.wgames.sdk.core.http;


import com.onmo.wgames.sdk.executor.Scheduler;
import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.core.http.request.IRequestPacket;

public class ApiInvoker implements IApiInvoker {


	@Override
	public boolean invoke(IHTTPResponseParser handler, IRequestPacket reqPck) {

		Scheduler scheduler = Scheduler.getInstance();
		Runnable mHttpClientService = new OkHttpClientService(reqPck.getUrl(),
				reqPck.getHeader(), reqPck.getRequestParam(),
				reqPck.getData(), reqPck.getMethod(), handler);

		scheduler.schedule(mHttpClientService);

		return true;
	}

}