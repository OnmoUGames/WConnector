package com.onmo.wgames.sdk.core.http;

import okhttp3.OkHttpClient;

/**
 * Created by Srini on 07/07/2017.
 */

public class OkHttpClientSingleton {

	private static final OkHttpClient ourInstance = new OkHttpClient();

	public static OkHttpClient getInstance() {

		return ourInstance;
	}

	private OkHttpClientSingleton() {
	}
}
