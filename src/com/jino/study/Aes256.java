package com.jino.study;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/*
http://www.imcore.net | hosihito@gmail.com
Developer. Kyoungbin Lee
2012.09.07

AES256 EnCrypt / DeCrypt
*/
public class Aes256 {
	
	public static void main(String[] args) throws Exception{
		String key = "EC655C39874BDAFCB8108A159FEB5AC5";
		key = "01234567890123456789012345678901";
		String plainText;
		String encodeText;
		String decodeText;
 

//		plainText  = "01057402464";
//		encodeText = AES256Cipher.AES_Encode2(plainText, key);		
//		System.out.println("AES256_Encode : "+encodeText);


		
		encodeText = "MWYwNzAzNjA3MmIyZDg2MjJmZjU0ZGY5YTM1OWNlZmJlMDA1YWM3Yjg5NmNmYmRiMjI5NjVhNmFiZDc0YTQ4ZjQwODNkMjI4ZDkwMDhlNTQwYTgyMWZjZjM2NmRlNTgxNzRlOWJjM2EyM2U0MjUyYzA1ODEwMWUwZTZmOTFhODBiZGNlYTU4OGNkMjRhNzNhYmE2MDJjODc3NGIwZDM0ODRmM2RjNGJjNTgwOTA0NTAxNzM4NjIxYjg3ZGM2YTQyMGVhNmNlMzRkNzFiYzBlNjUzMzQ4MGY5Yzc5ZWIwNzhiZjNiZmJiOGJmMjAzMmI1NzY4ZTI3MjEyMTVjMDkzODYzMTk3MzVmYzQzYTYwZjJiYzhmMDEyN2Q4N2U4NmUz";
		decodeText = AES256Cipher.decrypt(encodeText, key);
		System.out.println("AES256_Decode : "+decodeText);
		
		
		

	}

}
