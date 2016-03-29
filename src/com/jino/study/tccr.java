package com.jino.study;

import com.kr.wincom.enc.*;

public class tccr {

	public static void main(String args[]){
		String key = "wincomCRPassword";
//	    String str = "";
	    try
	    {
//	      if (args.length == 0) {
//	        System.err.println("ERROR ---> args.length=0");
//	        System.exit(1);
//	      }
//	      else
//	      {
//	        str = args[0];
//	      }

	    	String str = "onion";
	      String encryptAES = comEncMake.encrypt(key, str);

	      System.out.println("String ARG :: " + str);
	      System.out.println("encryp AES :: " + encryptAES);
	      System.out.println("decryp AES :: " + comEncMake.decrypt(key, encryptAES));
	    }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	}
	
}
