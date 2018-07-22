package com.onmo.wgames.sdk.core.http.parser;

import com.onmo.wgames.sdk.SDKException;

import okhttp3.Headers;

public interface IHTTPResponseParser {
   void parser(int httpResponseCode, String httpResponseStr, Headers headers);
   void handleException(int httpResponseCode, SDKException ex);
}
