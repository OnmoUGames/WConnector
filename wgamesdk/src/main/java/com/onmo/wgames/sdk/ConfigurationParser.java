package com.onmo.wgames.sdk;


import android.content.Context;

import com.onmo.sdk.R;

import java.util.HashMap;
import java.util.Map;


public class ConfigurationParser {


	public final static String CONFIG_URL = "CONFIG_URL";
	public final static String TERMS_URL = "TERMS_URL";
	public final static String PRIVACY_URL = "PRIVACY_URL";
	public final static String FAQ_URL = "FAQ_URL";
	public final static String BASE_URL = "BASE_URL";
	public final static String BASE_STORE_ID = "BASE_STORE_ID";
	public final static String STORE_LOCALE = "STORE_LOCALE";
	public final static String PROVIDER_NAME = "PROVIDER_NAME"; //provider_name
	public final static String ENABLE_TMEID = "ENABLE_TMEID";


	public Configuration parse(Context context) {
		Map<String, String> configParams = new HashMap<>();
		Configuration config = new Configuration();

		//Add only config url for the moment
		configParams.put(CONFIG_URL, context.getResources().getString(R.string.config_url));

		//Add only base url for the moment
		configParams.put(BASE_URL, context.getResources().getString(R.string.base_url));
		configParams.put(STORE_LOCALE, context.getResources().getString(R.string.store_locale));
		configParams.put(BASE_STORE_ID, context.getResources().getString(R.string.base_store_root));
		configParams.put(ENABLE_TMEID, context.getResources().getString(R.string.base_store_root));
		configParams.put(PROVIDER_NAME, context.getResources().getString(R.string.provider_name));
		config.getConnectorParams().putAll(configParams);

		return config;
	}
}
