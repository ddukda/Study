package com.jino.study;

//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//
//import org.jdom.Document;
//import org.jdom.Element;
//import org.jdom.JDOMException;
//import org.jdom.input.SAXBuilder;
//import org.xml.sax.InputSource;

import java.io.*;
import java.net.*;
import java.util.*;

import javax.net.ssl.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.catalina.util.URLEncoder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class XmlParser {

	public HashMap<String, Object> getMusicOnListenUrl(String szCmId, String szPid) {
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		URL url;
		HttpsURLConnection conn  = null;
		StringBuffer szReqXML	= new StringBuffer();

		try{
			
			szReqXML.append("<?xml version='1.0' encoding='euc-kr'?>");
			szReqXML.append("<musicon>");
			szReqXML.append("    	<app-id>" + "BELLRING" + "</app-id>");
			szReqXML.append("    	<app-ver>" + "06.00.01" + "</app-ver>");
			szReqXML.append("    	<uid>" + "" + "</uid>");
			szReqXML.append("    	<key>" + "" + "</key>");
			szReqXML.append("    	<command>" + "HTTP_STR_URL_INFO" + "</command>");
			szReqXML.append("		<param>");
			szReqXML.append("    		<prod-type>" + "RING" + "</prod-type>");
			szReqXML.append("    		<prod-subtype>" + "LNRG" + "</prod-subtype>");
			szReqXML.append("    		<prod-type>" + "BELL" + "</prod-type>");
			szReqXML.append("    		<prod-subtype>" + "MPBL" + "</prod-subtype>");
			szReqXML.append("    		<streamming-type>" + "P" + "</streamming-type>");
			szReqXML.append("    		<cmid>" + "01000000743775" + "</cmid>");
			szReqXML.append("    		<pid>" + "801000924378" + "</pid>");
			szReqXML.append("		</param>");
			szReqXML.append("</musicon>");

//			url = new URL(conf.getConfig("FEEL_COM", "MUSICON_MP3_LISTEN_URL"));			
			url = new URL("https://devmusic.uplus.co.kr:443/if/musicon.da?cryptver=1&r=16");
			HttpsURLConnection.setDefaultHostnameVerifier(new FakeHostnameVerifier());
			conn = (HttpsURLConnection)url.openConnection();
			
			conn.setConnectTimeout(20000);
			conn.setReadTimeout(20000);
			
			conn.setDoInput(true);   
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");

			int len = szReqXML.toString().length();
			
			//	 Header 영역에 쓰기
			conn.setRequestProperty("Content-Type", "application/xml");
			conn.setRequestProperty("Content-Length", Integer.toString(len));		  
			
			// BELLING
			// 060001
			// AN23
			// 000000LG-LU5400
			// 3G
			// N
			// 04800800
			// CIQDLcZydkMK7d2PMNX61A%3D%3D%0A
			conn.setRequestProperty("MSICON", "BELLRING060001AN23000000LG-LU54003GN04800800CIQDLcZydkMK7d2PMNX61A%3D%3D%0A");
			conn.setRequestProperty("DMI", "020000|-;");
			conn.setRequestProperty("AP", "zrK+BaCdVFcJENUT39nv5WICxg==");
			conn.setRequestProperty("MUS_CFK", "wou/DI6VKiBmEtUR29rtlmNtvRM=");
			conn.setInstanceFollowRedirects(false);
			
			conn.connect();
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "euc-kr");
			wr.write(szReqXML.toString());
			wr.flush();
			wr.close();

			wr.close();
			
			//	 리턴된 결과 읽기
			String inputLine = null;
			StringBuffer resXmlData = new StringBuffer();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "euc-kr"));
			while ((inputLine = in.readLine()) != null) {
				resXmlData.append(inputLine + "\n");
			}
			in.close();
			
			System.out.println("[ListenService] getMusicOnListenUrl^" + resXmlData);
//			szRst = resXmlData.toString();
			
//			resultMap.put("XML", szRst);
			
			
			resultMap = domParseTest(conn.getInputStream());
			
		}catch (SocketTimeoutException ste) {	
			System.out.println("[ListenService] getMusicOnListenUrl SocketTimeoutException " + ste.toString());			
		}catch (MalformedURLException mue) {			
			System.out.println("[ListenService] getMusicOnListenUrl MalformedURLException " + mue.toString());			
		}catch (IOException ioe) {			
			System.out.println("[ListenService] getMusicOnListenUrl IOException " + ioe.toString());
		}catch ( Exception e ) {			
			System.out.println("[ListenService] getMusicOnListenUrl Exception " + e.toString());
	    } finally{
	    	conn.disconnect();
	    	conn = null;
	    }

		return resultMap;
	}
	
	private static class FakeHostnameVerifier implements HostnameVerifier {
		public boolean verify(String hostname, SSLSession session) {
			return true;
		}
	}
	
//	public void aaa(){
//	public static void main(String args[]){
//		Document jdomdoc;
//		try {
//			jdomdoc = new SAXBuilder().build(new InputSource(new FileReader("D:/test.xml")));
//		
//		
//
//			Element root = jdomdoc.getRootElement();
//	
//			Element desc_E = root.getChild("description");
//	
//			String description = desc_E.getValue();
//	
//			System.out.println("description......" + description);
//	
//			Element peresons_E1 = root.getChild("persons");
//	
//			List<Element> list = peresons_E1.getChildren("person");
//	
//			for (int i = 0; i < list.size(); i++) {
//				Element person_E = list.get(i);
//				System.out.println("ssn................" + person_E.getAttributeValue("ssn"));
//				System.out.println("firstName................" + person_E.getChild("firstName").getValue());
//				System.out.println("lastName................" + person_E.getChild("lastName").getValue());
//			}
//		} catch (JDOMException | IOException e) {
//			// TODO 자동 생성된 catch 블록
//			System.out.println(e.toString());
//		}
//	}
	
	public HashMap<String, Object> domParseTest(InputStream in) throws Exception {
		 HashMap<String, Object> resultMap = new HashMap<String, Object>();
		 DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		 DocumentBuilder db = dbf.newDocumentBuilder();
		 Document doc = db.parse(in);
		 
		 try{
			 doc.getDocumentElement().normalize();
			  
			 NodeList error = doc.getElementsByTagName("error");
			 Element errorElmnt = (Element) error.item(0);
			 Node errorNode = errorElmnt.getFirstChild();
			 
			 resultMap.put("error", errorNode.getNodeValue());
			 
			 NodeList streamming_url = doc.getElementsByTagName("streamming-url");
			 Element streamming_urlElmnt = (Element) streamming_url.item(0);
			 Node streamming_urlNode = streamming_urlElmnt.getFirstChild();
			 
			 resultMap.put("streamming-url", streamming_urlNode.getNodeValue());
			 
			 NodeList auth_key = doc.getElementsByTagName("auth-key");
			 Element auth_keyElmnt = (Element) auth_key.item(0);
			 Node auth_keyNode = auth_keyElmnt.getFirstChild();
			 URLEncoder encode = new URLEncoder();
			 
			 resultMap.put("auth-key", auth_keyNode.getNodeValue());
			 resultMap.put("auth-key-encode", encode.encode(auth_keyNode.getNodeValue()));

			 //http://211.115.75.161:11400/StreamServer/musicon.strm?command=STREAM&uid=BELLRING&authKey=lH4yCPUM%2Flb2apD0HJa8kiFGA2RZ%2FpRn
			 
			 resultMap.put("listen_url", streamming_urlNode.getNodeValue()+"?command=STREAM&uid=BELLRING&authKey="+encode.encode(auth_keyNode.getNodeValue()));
			 
		 }catch(Exception e){
			 System.out.println(e.toString());
		 }
		
		 return resultMap;
	}
	 
}
