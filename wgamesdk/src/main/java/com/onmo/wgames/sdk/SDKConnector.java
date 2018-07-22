package com.onmo.wgames.sdk;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by Srini on 14/02/2018.
 * Comment
 */

public class SDKConnector {

	private static String TAG = "SDKConnector";
	private Context context;
	private Configuration connectorConfig;
	private static String PROVIDER_NAME = "com.onmo.ugames.wrapper.impl.UGamesDataProvider"; // TODO this need to update from config
	private static final String URL = "content://" + PROVIDER_NAME + "/cte";
	static final Uri CONTENT_URI = Uri.parse(URL);


	public SDKConnector(Context context, Configuration connectorConfig) {

		this.context = context;
		this.connectorConfig = connectorConfig;
		//PROVIDER_NAME = getConfig(ConfigurationParser.PROVIDER_NAME);
		LogApp.d(TAG, "inside the SDKConnector");
		try {
			Cursor cursor = context.getContentResolver().query(CONTENT_URI, null, null, null, null);

			if (cursor != null) {
				LogApp.d(TAG, "getUser() calling cursor -->" + cursor.getCount());
				if (cursor != null) {
					String data = null;
					cursor.moveToFirst();
					StringBuilder res = new StringBuilder();
					while (!cursor.isAfterLast()) {
						res.append("\n" + cursor.getString(cursor.getColumnIndex("id")) + "-" + cursor.getString(cursor.getColumnIndex("name")));

						data = cursor.getString(cursor.getColumnIndex("name"));
						cursor.moveToNext();

					}

					LogApp.d(TAG, "getUser()  -->" + res);
					//resultView.setText(res);


				}
			}
		}catch (Exception ex)
		{
			LogApp.d(TAG, "Exception ()  -->" + ex.getMessage());
		}




	}

	public String getConfig(String key) {
		if(connectorConfig != null && connectorConfig.getConnectorParams() != null){
			return connectorConfig.getConnectorParams().get(key);
		}
		return null;
	}

	public Context getApplicationContext() {
		return context;
	}
}
