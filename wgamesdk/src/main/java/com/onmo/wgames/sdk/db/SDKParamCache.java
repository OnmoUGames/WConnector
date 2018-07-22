package com.onmo.wgames.sdk.db;

import android.content.Context;
import android.content.SharedPreferences;

public class SDKParamCache {


	private static final String TAG = "SDKParamCache";
	private static final String PREFS_NAME = "param_cache";
	public static final String PREFS_MADE_TMEID = "prefs_made_tmeid";
	public static final String PREFS_BASE_URL = "prefs_base_url";

	public static String getCachedParams( Context aContext,String a_ParamName ) {

		SharedPreferences sharedPreferences = aContext
				.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

		return sharedPreferences.getString(a_ParamName, null);
	}

	public static void setCachedParams(Context aContext,String a_ParamName,String a_ParamValue) {
		SharedPreferences sharedPreferences = aContext
				.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.putString(a_ParamName, a_ParamValue);
		editor.apply();
	}

	//Call when logout
	public static void deleteCachedParams(Context aContext){
		SharedPreferences sharedPreferences = aContext
				.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = sharedPreferences.edit();
		editor.clear();
		editor.apply();
	}
}
