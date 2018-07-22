package com.onmo.wgames.sdk.core.http;

import com.onmo.wgames.sdk.LogApp;

import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;


/**
 * @author Srini
 * @version 1.1
 */
class OkHttpMessageFactory {
	private static final String TAG = "OkHttpMessageFactory";
	private static final MediaType CONTENT_TYPE = MediaType.parse("application/json; charset=UTF-8");
	private final String userAgentParam = "User-Agent";

	//	User-Agent: LiveWireAndroidStore/4.0 (Android 8.0.0; en_us; SM-G960U/OPR1.170623.026.G960USQU0AQK1)
//	X-Storefront: 109
//	X-Control-ID:
	private final String userAgentParmValue = "Onmo_Ringtone";
	private final String contentTypeValue = "application/json; charset=utf-8";

	private Request createHttpPostRequest(String url, Map<String, String> headers, Map<String, String> a_ReqParam, String a_Postdata) {
		if (a_Postdata == null) {
			a_Postdata = "";
		}

		HttpUrl.Builder httpBuilder = getHttpBuilder(url, a_ReqParam);

		return new Request.Builder()
				.url(httpBuilder.build())
				.addHeader(userAgentParam, userAgentParmValue)
				.addHeader("content-type", contentTypeValue)
				.post(RequestBody.create(CONTENT_TYPE, a_Postdata))
				.build();

	}

	private Request createHttpDeleteRequest(String url, Map<String, String> headers, Map<String, String> a_ReqParam, String a_Postdata) {

		HttpUrl.Builder httpBuilder = getHttpBuilder(url, a_ReqParam);

		return new Request.Builder()
				.url(httpBuilder.build())
				.addHeader(userAgentParam, userAgentParmValue)
				.addHeader("content-type", contentTypeValue)
				.delete(RequestBody.create(CONTENT_TYPE, a_Postdata))
				.build();
	}

	private Request createHttpUpdateRequest(String url, Map<String, String> headers, Map<String, String> a_ReqParam, String a_Postdata) {
		HttpUrl.Builder httpBuilder = getHttpBuilder(url, a_ReqParam);

		return new Request.Builder()
				.url(httpBuilder.build())
				.addHeader(userAgentParam, userAgentParmValue)
				.addHeader("content-type", contentTypeValue)
				.put(RequestBody.create(CONTENT_TYPE, a_Postdata))
				.build();
	}


	private Request createHttpGetRequest(String url, Map<String, String> headers, Map<String, String> a_ReqParam) {
		HttpUrl.Builder httpBuilder = getHttpBuilder(url, a_ReqParam);

		return new Request.Builder()
				.url(httpBuilder.build())
				.addHeader(userAgentParam, userAgentParmValue)
				.addHeader("Accept", "*/*")
				.build();

	}

	private HttpUrl.Builder getHttpBuilder(String a_UrlString, Map<String, String> a_ReqParam) {
		HttpUrl.Builder httpBuilder = HttpUrl.parse(a_UrlString).newBuilder();
		if (a_ReqParam != null) {

			try {

				for (String key : a_ReqParam.keySet()) {

					String tempValue = a_ReqParam.get(key);
					if (key.endsWith("EXPRESS_FILTER_2")) {
						key = key.replaceAll("EXPRESS_FILTER_2", "");
					}

					httpBuilder.addQueryParameter(key, tempValue);

				}

			} catch (Exception ex) {
				LogApp.d(TAG, "createHttpGetRequest ex-- >" + ex.getMessage());
			}
		}
		return httpBuilder;
	}


	public Request createUsingMethod(String url, Map<String, String> headers, Map<String, String> reqheaders,
									 String postParams, String method) {

		if (method.equalsIgnoreCase("post")) {
			return createHttpPostRequest(url, headers, reqheaders, postParams);
		} else if (method.equalsIgnoreCase("get")) {
			return createHttpGetRequest(url, headers, reqheaders);
		} else if (method.equalsIgnoreCase("put")) {
			return createHttpUpdateRequest(url, headers, reqheaders, postParams);
		} else if (method.equalsIgnoreCase("delete")) {
			return createHttpDeleteRequest(url, headers, reqheaders, postParams);
		} else {
			return null;
		}

	}

}
