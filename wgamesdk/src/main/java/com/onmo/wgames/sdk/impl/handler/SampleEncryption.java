package com.onmo.wgames.sdk.impl.handler;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by srini on 2/14/18.
 */

public class SampleEncryption {
    public static final String TMEID = "1103514782463474570";
    public  static final String DELIMITER = "|";
    public  static final String DATE_PATTERN = "dd/MM/yyyy HH:mm:ss";

    private static String getDeviceTime() {

        TimeZone timeZone = TimeZone.getTimeZone("GMT");

        SimpleDateFormat dateFormat = new SimpleDateFormat(
                DATE_PATTERN, Locale.US);
        dateFormat.setTimeZone(timeZone);
        Calendar currentCalendar = Calendar.getInstance(timeZone);
        String dateInRequiredFormat = dateFormat.format(currentCalendar.getTime());
        Log.d("TestEncryption", "dateInRequiredFormat --->"+dateInRequiredFormat);

        return dateInRequiredFormat;
    }


    public static void initTest()
    {
        HeaderIdentification encryption = new HeaderIdentification();
        String encryptedText =null;
        String planText =  getDeviceTime().concat(DELIMITER).concat(TMEID);//format    dd/MM/yyyy HH:mm:ss|TMEID

        long currentTime = System.currentTimeMillis();

             try
             {
                 encryptedText = encryption.encrypt(planText, true);
                 currentTime = (System.currentTimeMillis()-currentTime);
                 Log.d("TestEncryption", currentTime+" time took, :encryptedText  --->"+encryptedText);

             }
             catch (Exception ex)
             {
                 Log.d("TestEncryption", "error at init.encrypt :"+ex.getMessage());
             }


        currentTime = System.currentTimeMillis();
        try
        {
            encryptedText = encryption.decrypt(encryptedText, true);
            currentTime = (System.currentTimeMillis()-currentTime);
            Log.d("TestEncryption", currentTime+" time took to decrypt  --->"+encryptedText);

        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }

    }



    public static String getUserLocalTMEID(String plainTMEID)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String deviceStorageTMEID =null;

        try
        {
            if(plainTMEID!=null) {
                deviceStorageTMEID = headerIdentification.encrypt(plainTMEID, false);
            }
            Log.d("TestEncryption", " getUserLocalTMEID plainTMEID  --->"+deviceStorageTMEID);
        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "getUserLocalTMEID error at init.decrypt :"+ex.getMessage());
        }

        return deviceStorageTMEID;

    }

    public static String getLocalTMEID(String serverData)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String decryptedText =null, plainText=null;
        String deviceStorageTMEID =null;

        try
        {
            decryptedText = headerIdentification.decrypt(serverData, true);


            if(decryptedText!=null && decryptedText.contains(DELIMITER))
                plainText = decryptedText.substring(decryptedText.indexOf(DELIMITER)+1, decryptedText.length());
            Log.d("TestEncryption", decryptedText +": decryptedText got from server to plain--->"+plainText);

        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }

        try
        {
            if(plainText!=null)
                deviceStorageTMEID = headerIdentification.encrypt(plainText, false);
                Log.d("TestEncryption", " deviceStorageTMEID  --->"+deviceStorageTMEID);
        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }

        return deviceStorageTMEID;

    }


    public static String getUserTokenId(String userDeviceToken)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String encryptedText =null;
        try
        {
            if(userDeviceToken!=null)
                encryptedText = headerIdentification.encrypt(userDeviceToken, true);
            Log.d("TestEncryption", " getUserTokenId  --->"+encryptedText+" plainText-->"+userDeviceToken);

        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.encrypt :"+ex.getMessage());
            encryptedText = userDeviceToken;
        }

        return encryptedText;

    }

    public static String getServerTMEID(String deviceStorageTMEID)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String encryptedText =null, plainText=null;


        try
        {
            if(deviceStorageTMEID!=null)
                plainText = headerIdentification.decrypt(deviceStorageTMEID, false);
            Log.d("TestEncryption", " localData  --->"+deviceStorageTMEID+" plainText-->"+plainText);

        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }


        try
        {

            plainText =  getDeviceTime().concat(DELIMITER).concat(plainText);//format    dd/MM/yyyy HH:mm:ss|TMEID
            encryptedText = headerIdentification.encrypt(plainText, true);
            Log.d("TestEncryption", encryptedText +": encryptedText for server  --->");
        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }

        return encryptedText;

    }



    public static String getFakeEncryptTMEID(String hardcodedTMEID)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String encryptedText =null, plainText=null;

        try
        {

            plainText =  getDeviceTime().concat(DELIMITER).concat(hardcodedTMEID);//format    dd/MM/yyyy HH:mm:ss|TMEID
            encryptedText = headerIdentification.encrypt(plainText, true);
            Log.d("TestEncryption", encryptedText +": encryptedText for server  --->");
        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }

        return encryptedText;

    }

    public static String getPlainServerTMEID(String deviceStorageTMEID)
    {
        HeaderIdentification headerIdentification = new HeaderIdentification();
        String plainText=null;
        try
        {
            if(deviceStorageTMEID!=null)
                plainText = headerIdentification.decrypt(deviceStorageTMEID, false);
            Log.d("TestEncryption", " localData  --->"+deviceStorageTMEID+" plainText-->"+plainText);

        }
        catch (Exception ex)
        {
            Log.d("TestEncryption", "error at init.decrypt :"+ex.getMessage());
        }


        return plainText;

    }
}
