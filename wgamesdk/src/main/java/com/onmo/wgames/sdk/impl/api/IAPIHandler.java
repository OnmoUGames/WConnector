package com.onmo.wgames.sdk.impl.api;


import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.core.http.request.IRequestPacket;

public interface IAPIHandler {
	
	String getBaseAPIURL();
	void initAPIRequest(IRequestPacket aPacket, IHTTPResponseParser httpResponseParser);

}
