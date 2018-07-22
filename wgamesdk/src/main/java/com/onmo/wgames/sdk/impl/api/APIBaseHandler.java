package com.onmo.wgames.sdk.impl.api;


import com.onmo.wgames.sdk.ConfigurationParser;
import com.onmo.wgames.sdk.LogApp;
import com.onmo.wgames.sdk.SDKConnector;
import com.onmo.wgames.sdk.db.SDKParamCache;
import com.onmo.wgames.sdk.core.http.ApiInvoker;
import com.onmo.wgames.sdk.core.http.IApiInvoker;
import com.onmo.wgames.sdk.core.http.parser.IHTTPResponseParser;
import com.onmo.wgames.sdk.core.http.request.IRequestPacket;

public class APIBaseHandler implements IAPIHandler {
	public IHTTPResponseParser mHttpResponseParser;
	private String methodName = null;
	SDKConnector mConnector = null;

	public APIBaseHandler(SDKConnector connector){
		 this.mConnector = connector;
	}
	public APIBaseHandler(SDKConnector connector, String a_MethodName){
		this.mConnector = connector;
		this.methodName = a_MethodName;
	}

	@Override
	public void initAPIRequest(IRequestPacket aPacket, IHTTPResponseParser httpResponseParser) {
		this.mHttpResponseParser = httpResponseParser;
		IApiInvoker invoker = new ApiInvoker();
		//invoker.setRequestType(getRequestType());
		invoker.invoke(mHttpResponseParser, aPacket);
	}

	@Override
	public String getBaseAPIURL() {
		try{
			if(methodName!=null)
			{
				return mConnector.getConfig(ConfigurationParser.BASE_URL).trim().concat(methodName);
			}
		}catch (Exception ex){
			LogApp.d("APIBaseHandler", "Get exception "+ex.getMessage());

		}

		return mConnector.getConfig(ConfigurationParser.BASE_URL).trim();
	}

	public String getConfigUrl(){
		return mConnector.getConfig(ConfigurationParser.CONFIG_URL).trim();
	}

	public String getBaseUrl(){
		return SDKParamCache.getCachedParams(mConnector.getApplicationContext(), SDKParamCache.PREFS_BASE_URL).concat("/");
	}

}