package com.onmo.wgames.sdk.core.http.request;

import java.util.Map;

public class RequestPacket implements IRequestPacket {

	private String mUrl;
    private String mData = "";
    private Map<String, String> mHeader;

    private Map<String, String> mRequestParam;
    @Override
    public Map<String, String> getRequestParam() {
		return mRequestParam;
	}
    @Override
	public void setRequestParam(Map<String, String> mRequestParam) {
		this.mRequestParam = mRequestParam;
	}

	private String mMethod = "get";
    
 	@Override
	public String getUrl() {
		return this.mUrl;
	}

	@Override
	public String getData() {
		return this.mData;
	}

	@Override
	public Map<String, String> getHeader() {
		return this.mHeader;
	}

	@Override
	public String getMethod() {
		return mMethod;
	}

	@Override
	public void setUrl(String url) {
		this.mUrl=url ;
	}

	@Override
	public void setData(String data) {
		this.mData=data ;
		
	}

	@Override
	public void setHeader(Map<String, String> header) {
		this.mHeader=header ;
		
	}

	@Override
	public void setMethod(String method) {
		this.mMethod=method ;
	}

	@Override
	public void release() {
		if (mHeader != null)
			mHeader.clear();
		if (mRequestParam != null)
			mRequestParam.clear();

	}
}
