package com.onmo.wgames.sdk.core.http;

import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.core.http.request.IRequestPacket;

public interface IApiInvoker {
	boolean invoke(IHTTPResponseParser handler, IRequestPacket reqPck) ;

}
