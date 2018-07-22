package com.onmo.wgames.sdk.impl.handler;

import android.util.Base64;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by srini on 2/14/18.
 */

public class HeaderIdentification {


        // setup AES cipher in GCM mode with PKCS #5 padding
        private static final String ALGORITHM = "AES";
        private static final String TRANSFORMATION_TYPE = "AES/CBC/PKCS5Padding"; //"AES/GCM/NOPADDING"
        private static final String _SERVER_KEY = "/KZ6wq4oi0/GiP8Lbcny6S1ySA+YgyWwYLhwTPt3gt0=";
        private static final String _STORAGE_KEY = "app_ugames_";
        private static final String CHAR_SET = "UTF-8";
        //private static final int IV_LENGTH = 32;

        /**
         * @param value data to encrypt
         * @return String result of encryption
         * @throws UnsupportedEncodingException
         * @throws InvalidKeyException
         * @throws NoSuchAlgorithmException
         * @throws NoSuchPaddingException
         * @throws InvalidAlgorithmParameterException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         */
        public String encrypt(String value, boolean useServerkey )
                throws UnsupportedEncodingException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
        {
            byte[] value_bytes = value.getBytes("UTF-8");
            byte[] key_bytes = getKeyBytes(useServerkey?_SERVER_KEY:_STORAGE_KEY);
            return Base64.encodeToString(encrypt(value_bytes, key_bytes, key_bytes), Base64.NO_WRAP);
        }

        /**
         *
         * @param value data to decrypt
         * @return String result after decryption
         * @throws GeneralSecurityException
         * @throws GeneralSecurityException
         * @throws InvalidAlgorithmParameterException
         * @throws IllegalBlockSizeException
         * @throws BadPaddingException
         * @throws IOException
         */

        public String decrypt(String value, boolean useServerkey)
                throws GeneralSecurityException, IOException
        {
            byte[] value_bytes = Base64.decode(value, Base64.NO_WRAP);
            byte[] key_bytes = getKeyBytes(useServerkey?_SERVER_KEY:_STORAGE_KEY);
            return new String(decrypt(value_bytes, key_bytes, key_bytes), CHAR_SET);
        }


        private byte[] decrypt(byte[] ArrayOfByte1, byte[] ArrayOfByte2, byte[] ArrayOfByte3)
                throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
        {
          Cipher localCipher = Cipher.getInstance(TRANSFORMATION_TYPE);

            // decrypt
                localCipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(ArrayOfByte2, ALGORITHM ), new IvParameterSpec(ArrayOfByte3));
            return localCipher.doFinal(ArrayOfByte1);
        }

        private byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
                throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException
        {

            Cipher localCipher = Cipher.getInstance(TRANSFORMATION_TYPE);
            // encrypt
            localCipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(paramArrayOfByte2, ALGORITHM), new IvParameterSpec(paramArrayOfByte3));
            return localCipher.doFinal(paramArrayOfByte1);
        }

        private byte[] getKeyBytes(String paramString)
                throws UnsupportedEncodingException
        {
            byte[] arrayOfByte1 = new byte[16];
            byte[] arrayOfByte2 = paramString.getBytes(CHAR_SET);
            System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 0, Math.min(arrayOfByte2.length, arrayOfByte1.length));
            return arrayOfByte1;
        }


}
