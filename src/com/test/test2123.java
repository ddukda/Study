package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class test2123 {
	public static void main(String args[]){
				
		System.out.println(idMask("@01057402464"));
		System.out.println(idMask("222_11@naver.com"));
		System.out.println(idMask("kklee0517@gmail.com"));
		System.out.println(idMask("why0527"));
		System.out.println(idMask("ahngm88"));
		
		
	}
	
	public static String idMask(String szId) {
		String	szTempId	= "";			// 마스킹 처리 됨 ID
		String	szEmail		= "";			// ONE ID의 경우 @ 이후의 문자열(이메일)
		int		nAtPosition	= 0;
		
		// NULL CHECK
//		if (nullToSpace(szId) == null) return "";

		// 한글 체크 (한글은 관리자의 경우이므로 받은 그대로 리턴
		if(szId.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힝]+.*"))	return szId;
		
		nAtPosition = szId.indexOf("@");
		
		if(nAtPosition > 0){			// @가 포함된 ONE ID일 경우
			szEmail = szId.substring(nAtPosition, szId.length());
			
			for(int i = 0; i < nAtPosition; i++){
				if(i > 2)				szTempId  =  szTempId + "*";
				else					szTempId  =  szTempId + szId.charAt(i);
			  }
			
			szTempId = szTempId + szEmail;
		}else{							// @가 포함되지 않은 기존통합웹회원 ID일 경우
			for(int i = 0; i < szId.length(); i++){
				if(i == 2 || i == 3)	szTempId  =  szTempId + "*";
				else					szTempId  =  szTempId + szId.charAt(i);
			  }
			
		}
		
		return szTempId;
	}
}
