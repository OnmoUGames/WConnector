package com.onmo.wgames.sdk;

import android.content.Context;


/**
 * Created by Srini on 14/07/2018.
 * Comment
 */
public class OnmoWGSDK {
	private static final String TAG = "OnmoWGSDK";
	public static Initializer newInitializer(Context context) {
		return new Initializer(context);
	}
	/**
	 * Configure
	 */
	public static class Initializer {
		final Context mContext;
		final  SDKConnector sdkConnector;

		private Initializer(Context context) {
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
