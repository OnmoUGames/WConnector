package com.onmo.wgames;

import android.app.Application;

import com.onmo.wgames.sdk.LogApp;


/**
 * Created by Srini on 14/06/2018.
 */
public class MyApplication extends Application {


	private static final String TAG = "MyApplication";
	private static final String ADS_APP_ID = "ca-app-pub-2134802588315619~3754653270";

	@Override
	public void onCreate() {
		super.onCreate();

		LogApp.d(TAG, "Init connector application class");
		Connector.getInstance().initConnector(this);

	}
}
