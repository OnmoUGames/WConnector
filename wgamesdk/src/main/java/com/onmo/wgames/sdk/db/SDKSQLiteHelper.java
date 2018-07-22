package com.onmo.wgames.sdk.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.onmo.wgames.sdk.LogApp;

/**
 *
 * @author Srini
 *
 */
public class SDKSQLiteHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "wrappergamesSDK.db" ;
	private static final int DATABASE_VERSION = 1;
	private static SDKSQLiteHelper sInstance = null;
	/**
	 *
	 * @param context
	 */
	private SDKSQLiteHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);

	}

	public static SDKSQLiteHelper getInstance(Context context) {

		if (sInstance == null) {
			sInstance = new SDKSQLiteHelper(context.getApplicationContext());
		}
		return sInstance;
	}

	/**
	 *
	 * @param database
	 */
	@Override
	public void onCreate(SQLiteDatabase database) {

		LogApp.d(DATABASE_NAME, " onCreate........ ");
		//database.execSQL(TagsCache.CREATE_TABLE);

	}

	/**
	 *
	 * @param database
	 */
	@Override
	public void onUpgrade(SQLiteDatabase database, int arg1, int arg2) {
		LogApp.d(DATABASE_NAME, " onUpgrade........ ");
		//database.execSQL("DROP TABLE IF EXISTS " + TagsCache.TABLE_NAME);
		onCreate(database);
	}

	/*@Override
	public void onDowngrade(SQLiteDatabase database, int oldVersion, int newVersion) {
		database.execSQL("DROP TABLE IF EXISTS " + TagsCache.TABLE_NAME);
		onCreate(database);

	}*/

	public static void deleteAllTable(SQLiteDatabase database, Context context){

		//database.execSQL("DROP TABLE IF EXISTS " + TagsCache.TABLE_NAME);
		//database.execSQL(TagsCache.CREATE_TABLE);
	}


}
