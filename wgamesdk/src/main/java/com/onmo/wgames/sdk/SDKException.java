package com.onmo.wgames.sdk;

public class SDKException extends Exception{
    //private static final long serialVersionUID = -8927816130174537625L;
    private int code;

    public SDKException() {
        super();
    }

    public SDKException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public SDKException(String detailMessage) {
        super(detailMessage);
    }

    public SDKException(String detailMessage, int code) {
        super(detailMessage);
        this.code = code;
    }
    public SDKException(Throwable throwable) {
        super(throwable);
    }
    
    public int getCode() {
    	return code;
    }
}
