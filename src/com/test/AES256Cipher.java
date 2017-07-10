package com.test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import sun.misc.BASE64Encoder;

public class AES256Cipher {
	 
//	public static String byteArrayToHex(byte[] ba) {
//        if (ba == null || ba.length == 0) {
//            return null;
//        }
//
//        StringBuffer sb = new StringBuffer(ba.length * 2);
//        String hexNumber;
//        for (int x = 0; x < ba.length; x++) {
//            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
//
//            sb.append(hexNumber.substring(hexNumber.length() - 2));
//        }
//        return sb.toString();
//    }
//
//	public static String AES_Encode(String message, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,	IllegalBlockSizeException, BadPaddingException {
//		
//		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//
//        byte[] encrypted = cipher.doFinal(message.getBytes());
//        String szEncrypt = byteArrayToHex(encrypted);
//
//        String szEnCode =  new BASE64Encoder().encode(szEncrypt.getBytes());
//
//        return szEnCode;
//		
//	}

//	 public static byte[] hexToByteArray(String hex) {
//	        if (hex == null || hex.length() == 0) {
//	            return null;
//	        }
//
//	        byte[] ba = new byte[hex.length() / 2];
//	        for (int i = 0; i < ba.length; i++) {
//	            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
//	        }
//	        return ba;
//	    }
	 
//	 public static String decrypt(String encrypted, String key) throws Exception {
//	        
//	    	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
//	    	encrypted  = new String(decoder.decodeBuffer(encrypted));
//
//	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
//
//	        Cipher cipher = Cipher.getInstance("AES");
//	        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//
//	        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
//	        String originalString = new String(original);
//
//	        return originalString;
//	    }
	 
	 
//	 /**
//	     * byte[] to hex : unsigned byte(바이트) 배열을 16진수 문자열로 바꾼다.
//	     * 
//	     * @param ba        byte[]
//	     * @return
//	     */
//	    public String byteArrayToHex(byte[] ba) {
//	        if (ba == null || ba.length == 0) {
//	            return null;
//	        }
//
//	        StringBuffer sb = new StringBuffer(ba.length * 2);
//	        String hexNumber;
//	        for (int x = 0; x < ba.length; x++) {
//	            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
//
//	            sb.append(hexNumber.substring(hexNumber.length() - 2));
//	        }
//	        return sb.toString();
//	    }
//	    
	    
	 
//	 /**
//	     * AES 방식의 암호화
//	     * 
//	     * @param message
//	     * @return
//	     * @throws Exception
//	     */
//	    public String encrypt(String message, String key) throws Exception {
//
//	    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
//	        Cipher cipher = Cipher.getInstance("AES");
//	        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//
//	        byte[] encrypted = cipher.doFinal(message.getBytes());
//	        String szEncrypt = byteArrayToHex(encrypted);
//
//	        String szEnCode =  new BASE64Encoder().encode(szEncrypt.getBytes());
//
//	        return szEnCode;
//	    }
//	    
//	    /**
//	     * byte[] to hex : unsigned byte(바이트) 배열을 16진수 문자열로 바꾼다.
//	     * 
//	     * @param ba        byte[]
//	     * @return
//	     */
//	    public String byteArrayToHex(byte[] ba) {
//	        if (ba == null || ba.length == 0) {
//	            return null;
//	        }
//
//	        StringBuffer sb = new StringBuffer(ba.length * 2);
//	        String hexNumber;
//	        for (int x = 0; x < ba.length; x++) {
//	            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);
//
//	            sb.append(hexNumber.substring(hexNumber.length() - 2));
//	        }
//	        return sb.toString();
//	    }
//	
	
	
	  /**
     * byte[] to hex : unsigned byte(바이트) 배열을 16진수 문자열로 바꾼다.
     * 
     * @param ba        byte[]
     * @return
     */
    public String byteArrayToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;
        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }

    /**
     * AES 방식의 암호화
     * 
     * @param message
     * @return
     * @throws Exception
     */
    public String encrypt(String message, String key) throws Exception {

    	SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        String szEncrypt = byteArrayToHex(encrypted);

        String szEnCode =  new BASE64Encoder().encode(szEncrypt.getBytes());

        return szEnCode;
    }
}