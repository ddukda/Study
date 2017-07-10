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


public class TESTRJK {
	public static void main(String args[]){
		
	
		String szCharset			= "euc-kr";
		StringBuffer szRequestXML	= new StringBuffer();
		StringBuffer resXmlData 	= new StringBuffer();
		String szRequestUrl			= "";
		
		szRequestUrl			= "http://211.115.75.243:8080/rest/ringjk/CertifyTelecom";

		szRequestXML.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>");
		szRequestXML.append("\n<restFeelring>");
		
		szRequestXML.append("\n    <API_ID>CertifyTelecom</API_ID>");
		szRequestXML.append("\n    <TELECOM_CODE>SKT</TELECOM_CODE>");
		szRequestXML.append("\n    <SERVICE_CODE>LGU001</SERVICE_CODE>");
		szRequestXML.append("\n    <CTN>111111</CTN>");
		
		szRequestXML.append("\n</restFeelring>");
		
		
		HttpURLConnection conn = null;
		try {
			URL url = new URL(szRequestUrl);
			conn = (HttpURLConnection)url.openConnection();
			
			conn.setConnectTimeout(20000);
			conn.setReadTimeout(20000);
			
			conn.setDoInput(true);   
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");

			int len = szRequestXML.toString().length();
			
			//	 Header 영역에 쓰기
			conn.setRequestProperty("Host", "211.115.75.243");
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Content-Length", Integer.toString(len));
			conn.setRequestProperty("User-Agent", "Jakarta Commons-HttpClient/2.0.2");
			
			conn.setInstanceFollowRedirects(false);
			
			conn.connect();
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "euc-kr");
			wr.write(szRequestXML.toString());
			wr.flush();
			wr.close();
			
			//	 리턴된 결과 읽기
			String inputLine = null;
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),szCharset));
			while ((inputLine = in.readLine()) != null) {
				resXmlData.append(inputLine + "\n");
			}
			in.close();
			
			// 결과
			if( conn != null && conn.getResponseMessage().equals("OK")){
				System.out.println(resXmlData.toString());
			}else{
				
			}
			
			
		} catch (SocketTimeoutException se) {
			
		} catch (Exception e) {
			
		} finally {
			conn.disconnect();
			conn = null;
		} 
		
		
	}
	
}
