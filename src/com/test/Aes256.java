package com.test;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Aes256 {
	
	public static void main(String[] args) throws Exception{

		String szTestParam = "";
		String szEncodeText = "";
		try{
			szTestParam = "01029882223";
			System.out.println(AESEncryptHandler.encrypt1("CLOSEAPI_SPEC", "KT", szTestParam));	
			System.out.println(AESEncryptHandler.encrypt2("CLOSEAPI_SPEC", "KT", szTestParam));
			System.out.println(AESEncryptHandler.encrypt3("CLOSEAPI_SPEC", "KT", szTestParam));

		}catch(Exception e){
			System.out.println("Exception : " + e);
		}
			
		
		
		
		
		
		//input : 01029882223
		//key : EC655C39874F67EB759A1A159FEB5AC5
		//output : aHR0cCBDb25uZWN0aW9uIEVycm9yIDogNDA0
	}

}

