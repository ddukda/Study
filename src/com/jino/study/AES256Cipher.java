package com.jino.study;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;

import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Encoder;

public class AES256Cipher {
	
	public static byte[] ivBytes = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };


	public static String byteArrayToHex(byte[] ba) {
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
	
	 public static byte[] hexToByteArray(String hex) {
	        if (hex == null || hex.length() == 0) {
	            return null;
	        }

	        byte[] ba = new byte[hex.length() / 2];
	        for (int i = 0; i < ba.length; i++) {
	            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
	        }
	        return ba;
	    }
	 
	 
	public static String AES_Encode2(String message, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,	IllegalBlockSizeException, BadPaddingException {
		
		SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(message.getBytes());
        String szEncrypt = byteArrayToHex(encrypted);

        String szEnCode =  new BASE64Encoder().encode(szEncrypt.getBytes());

        return szEnCode;
		
	}


	public static String AES_Encode(String str, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException,	IllegalBlockSizeException, BadPaddingException {
		
		byte[] textBytes = str.getBytes("UTF-8");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
	    SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
	    Cipher cipher = null;
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
//		return Base64.encodeBase64String(byteArrayToHex(cipher.doFinal(textBytes)));
		return new BASE64Encoder().encode(byteArrayToHex(cipher.doFinal(textBytes)).getBytes());
	}

	public static String AES_Decode(String str, String key)	throws java.io.UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		
		byte[] textBytes = Base64.decodeBase64(str);
		//byte[] textBytes = str.getBytes("UTF-8");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
		return new String(cipher.doFinal(textBytes), "UTF-8");
	}
	
	 public static String decrypt(String encrypted, String key) throws Exception {
	        
	    	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();  
	    	encrypted  = new String(decoder.decodeBuffer(encrypted));

	        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, skeySpec);

	        byte[] original = cipher.doFinal(hexToByteArray(encrypted));
	        String originalString = new String(original);

	        return originalString;
	    }
}