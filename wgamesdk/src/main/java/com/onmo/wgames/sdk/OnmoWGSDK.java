package com.onmo.wgames.sdk;

import android.content.Context;


/**
 * Created by Srini on 14/07/2018.
 * Comment
 */
public class OnmoWGSDK {
	private static final String TAG = "OnmoWGSDK";
	public static InitializerBuilder newInitializerBuilder(Context context) {
		return new InitializerBuilder(context);
	}
	/**
	 * Configure what services are to be enabled in this instance of Stetho.
	 */
	public static class InitializerBuilder {
		final Context mContext;
		final  SDKConnector sdkConnector;

		private InitializerBuilder(Context context) {
			mContext = context.getApplicationContext();
			ConfigurationParser parser = new ConfigurationParser();
			Configuration config = parser.parse(mContext);
			sdkConnector = new SDKConnector(mContext, config);
		}

		public WGameSession build() {
			return new WGameSession(sdkConnector, null);
		}

		public WGameSession build(String accessToken) {
			return new WGameSession(sdkConnector, new WGameAccess(accessToken) );
		}
	}
}
