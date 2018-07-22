package com.onmo.wgames.sdk.core.http.request;

import java.util.Map;

/**
 * common for MobileApps server 
 */
public interface IRequestPacket {
	String getUrl();
	String getData();
	Map<String, String> getHeader();
	Map<String, String> getRequestParam();
	String getMethod();
	
	void setUrl(String url);
	void setData(String data);
	void setHeader(Map<String, String> header);
	void setRequestParam(Map<String, String> header);
	void setMethod(String method);
	void release() ;
}