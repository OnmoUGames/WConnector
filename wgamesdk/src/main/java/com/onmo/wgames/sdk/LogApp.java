package com.onmo.wgames.sdk;

import android.os.Environment;
import android.util.Log;

import com.onmo.sdk.BuildConfig;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Srini on 24/11/2015.
 *
 * Class used to print all the log within the Express app
 *
 */
public class LogApp {

	/**
	 * Method used to print the log. If the app is in debug, log will be printed.
	 * In release mode, the log are not printed
	 * @param tag Tag to used for printing log
	 * @param message Message log
	 */
	public static void d(String tag, String message){
		if (tag != null && message != null){
			/*if (BuildConfig.DEBUG){

				//saveLogs(tag, message);

			}*/
			Log.d(tag, message);
		}
	}

	public static void e(String tag, String message){
		if (tag != null && message != null){
			if (BuildConfig.DEBUG){
				Log.e(tag, message);
				//saveLogs(tag, message);

			}
		}
	}

	private static void saveLogs(String tag, String message){
		try {
			// to write logcat in text file
			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + "/" + "Express");
			dir.mkdirs();
			File myFile = new File(dir,createFileName(System.currentTimeMillis())+".log");
			FileOutputStream fOut = new FileOutputStream(myFile, true);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);
			osw.write(convertDate(System.currentTimeMillis())+tag+" : "+message+"\n");
			osw.flush();
			osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String convertDate(long date){


			//Log.d("Language", "language is en");
			//set the date format to Sep 17, 2:45 am
			//SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, h:mm a", Locale.US);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-HH:mm:ss:", Locale.US);
			//Log.d("DATE", "Convert long : "+ date + " to timestamp : " + new Date(Long.valueOf(date)));
			//Replace AM and PM by am pm
			//return dateString.replace("AM", "am").replace("PM","pm");
			return formatter.format(new Date(date));


	}

	public static String createFileName(long date){

		//Log.d("Language", "language is en");
		//set the date format to Sep 17, 2:45 am
		//SimpleDateFormat formatter = new SimpleDateFormat("MMM dd, h:mm a", Locale.US);
		SimpleDateFormat formatter = new SimpleDateFormat("ddMM", Locale.US);
		//Log.d("DATE", "Convert long : "+ date + " to timestamp : " + new Date(Long.valueOf(date)));
		//Replace AM and PM by am pm
		//return dateString.replace("AM", "am").replace("PM","pm");
		return formatter.format(new Date(date));


	}
}
