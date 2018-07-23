package com.onmo.wgames;

import android.app.Application;

import com.onmo.wgames.sdk.LogApp;


/**
 * Created by Srini on 14/06/2018.
 */
public class MyApplication extends Application {


	private static final String TAG = "MyApplication";

	@Override
	public void onCreate() {
		super.onCreate();

		LogApp.d(TAG, "Init connector application class");

	}
}
