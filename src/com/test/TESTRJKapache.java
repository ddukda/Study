
package com.test;



public class TESTRJKapache {
	
	public static void main(String[] args) throws Exception {
        
	}
}
//public class TESTRJKapache {
//
//// private static String url = "http://211.115.75.243:8080/rest/ringjk/CertifyTelecom";
// private static String url = "http://211.115.75.243:8080/cms/cp_http/telecom/server/test.jsp";
// 
//
// public static void main(String[] args) {
//	    // Create an instance of HttpClient.
//	    HttpClient client = new HttpClient();
//	    HttpHost localhost = new HttpHost("locahost", 80);
//	   
//	    // Create a method instance.
//	    PostMethod method = new PostMethod(url);
//	    
//	    // Provide custom retry handler is necessary
//	    method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
//	    		new DefaultHttpMethodRetryHandler(3, false));
//	    
////	    HttpProtocolParams.setUserAgent(client.getParams(), "Mozilla/5.0 Firefox/26.0");
//
//	    try {
//	      // Execute the method.
//	      int statusCode = client.executeMethod(method);
//
//	      if (statusCode != HttpStatus.SC_OK) {
//	        System.err.println("Method failed: " + method.getStatusLine());
//	      }
//	      
//	      
//	      
//	      // Read the response body.
//	      byte[] responseBody = method.getResponseBody();
//
//	      // Deal with the response.
//	      // Use caution: ensure correct character encoding and is not binary data
//	      System.out.println(new String(responseBody));
//
//	    } catch (HttpException e) {
//	      System.err.println("Fatal protocol violation: " + e.getMessage());
//	      e.printStackTrace();
//	    } catch (IOException e) {
//	      System.err.println("Fatal transport error: " + e.getMessage());
//	      e.printStackTrace();
//	    } finally {
//	      // Release the connection.
//	      method.releaseConnection();
//	    }  
//	  }
//	}

//}
//public class TESTRJKapache {
//	public static void main(String args[]){
//		
//	
//		String szCharset			= "euc-kr";
//		StringBuffer szRequestXML	= new StringBuffer();
//		StringBuffer resXmlData 	= new StringBuffer();
//		String szRequestUrl			= "";
//		
//		szRequestUrl			= "http://211.115.75.243:8080/rest/ringjk/CertifyTelecom";
//
//		szRequestXML.append("<?xml version=\"1.0\" encoding=\"euc-kr\"?>");
//		szRequestXML.append("\n<restFeelring>");
//		
//		szRequestXML.append("\n    <API_ID>CertifyTelecom</API_ID>");
//		szRequestXML.append("\n    <TELECOM_CODE>SKT</TELECOM_CODE>");
//		szRequestXML.append("\n    <SERVICE_CODE>LGU001</SERVICE_CODE>");
//		szRequestXML.append("\n    <CTN>111111</CTN>");
//		
//		szRequestXML.append("\n</restFeelring>");
//		
//		
//		HttpURLConnection conn = null;
//		try {
//			URL url = new URL(szRequestUrl);
//			conn = (HttpURLConnection)url.openConnection();
//			
//			conn.setConnectTimeout(20000);
//			conn.setReadTimeout(20000);
//			
//			conn.setDoInput(true);   
//			conn.setDoOutput(true);
//			conn.setRequestMethod("POST");
//
//			int len = szRequestXML.toString().length();
//			
//			//	 Header 영역에 쓰기
//			conn.setRequestProperty("Content-Type", "application/xml");
////			conn.setRequestProperty("Content-Type", "text/xml");
//			conn.setRequestProperty("Content-Length", Integer.toString(len));
//			conn.setRequestProperty("User-Agent", "Jakarta Commons-HttpClient/2.0.2");
//			
//			conn.setInstanceFollowRedirects(false);
//			
//			conn.connect();
//			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "euc-kr");
//			wr.write(szRequestXML.toString());
//			wr.flush();
//			wr.close();
//			
//			//	 리턴된 결과 읽기
//			String inputLine = null;
//			
//			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(),szCharset));
//			while ((inputLine = in.readLine()) != null) {
//				resXmlData.append(inputLine + "\n");
//			}
//			in.close();
//			
//			// 결과
//			if( conn != null && conn.getResponseMessage().equals("OK")){
//				System.out.println(resXmlData.toString());
//			}else{
//				
//			}
//			
//			
//		} catch (SocketTimeoutException se) {
//			
//		} catch (Exception e) {
//			
//		} finally {
//			conn.disconnect();
//			conn = null;
//		} 
//		
//		
//	}
//	
//}
