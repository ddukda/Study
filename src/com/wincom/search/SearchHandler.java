package com.wincom.search;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;


public class SearchHandler {

	
	public ArrayList<HashMap<String, String>> keywordSearch(String szKeyword){
		ArrayList<HashMap<String, String>> searchResultList = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> mapResult = new HashMap<String, String>();
		
		StringBuffer sbRequestUrl = new StringBuffer();
		HttpURLConnection http = null;
		BufferedReader br = null;
		
		String szSearchUrl = "";
		String szAuthKey = "";
		String szResult = "";
		
		try{
			szSearchUrl = "http://211.115.75.86:8578/search/feelring/total";
			szAuthKey 	= "D0pWbSiNpVM8O0uKwjVtXLdIrSF23dilLON3xtWi8BI=";
			
//			"w"			: "FEELRING",
//    		"q"			: $('#keyword').val(),			// 키워드
//    		"section"	: "",							// 검색 세부영역
//    		"pg"		: idx,							// 페이지 번호
//    		"outmax"	: $('#pageSize').val(),			// 출력 개수
//    		"sort"		: $('#gubun').val(),
//    		"p"			: "",	
//    		"d"			: "",	
//    		"csq"		: ""
    			
			sbRequestUrl.append(szSearchUrl)
			.append("?w=FEELRING")
    		.append("&q=")
    		.append(URLEncoder.encode(szKeyword.toString(), "utf-8").replace("%C2%A0","%20").replace("%", "%25"))	// 키워드
    		.append("&pg=")
    		.append(Integer.parseInt("1".toString()))			// 페이지 번호
    		.append("&outmax=")
    		.append(Integer.parseInt("10".toString()))		// 출력개수
    		.append("&sort=21");
    		
    		
    		
    		URL url = new URL(sbRequestUrl.toString());
    		
    		http = (HttpURLConnection)url.openConnection();
    		http.setConnectTimeout(10000);
    		http.setReadTimeout(10000);
    		
    		http.setDoInput(true);
    		http.setDoOutput(true);
    		http.setUseCaches(false);
    		
    		http.setRequestProperty("return-type", "text/xml");
    		http.setRequestProperty("auth-key"	 , szAuthKey);
    		http.setRequestProperty("encrypt-yn" , "Y");
    		
    		int resCode = http.getResponseCode();
    		    		    		
    		// 성공
    		if(resCode == HttpURLConnection.HTTP_OK) {
    			br = new BufferedReader( new InputStreamReader(http.getInputStream(), "UTF-8"));
    			
    			String line;
    			StringBuffer sbContent = new StringBuffer();
    			while((line = br.readLine()) != null) {
    				sbContent.append(line);
    			}
   			
    			szResult = sbContent.toString();
    			System.out.println("keywordSearch : " + szResult);
    			// 에러가 아니면
    			if(!szResult.contains("<error><code>")){
    				InputStream is = new ByteArrayInputStream(szResult.toString().getBytes("UTF-8"));
    				SAXPaser saxparser = new SAXPaser(is);
    				saxparser.parser();
    				int nRowSize = 0;
    				nRowSize = saxparser.getRowsize();
    				
    				if(nRowSize > 0 ){
    									
    					mapResult.put("totcnt", new String(String.valueOf(saxparser.getTotCnt())));
    					mapResult.put("maxcnt", new String(String.valueOf(saxparser.getMaxCnt())));
    					mapResult.put("pagenum", new String(String.valueOf(saxparser.getPageNum())));
    					searchResultList.add(mapResult);
    					
    					for (int i=0; i<nRowSize; i++ ){
    						mapResult 	= new HashMap<String,String>();
    						
    						mapResult.put("CMID", saxparser.get(i,"CNTID"));
    						mapResult.put("IMGPATH", saxparser.get(i,"ALBUM_IMG_URL"));
    						mapResult.put("SINGER", saxparser.get(i,"SINGER"));
    						mapResult.put("TITLE", saxparser.get(i,"TITLE"));
    						mapResult.put("ALBUM", saxparser.get(i,"ALBUM"));
    						searchResultList.add(mapResult);				
    						
    					}
    				}
    				
    				//---------------------------------------------------------------
    				
//    				SearchXmlList searchXmlList = null;
//            		JAXBContext jaxbContext = null;
//            		StringReader reader = new StringReader(szResult);
//            		ArrayList<DocXmlVo>     docList  = new ArrayList<DocXmlVo>();
//        			jaxbContext = JAXBContext.newInstance(SearchXmlList.class);
//        			searchXmlList = (SearchXmlList)jaxbContext.createUnmarshaller().unmarshal(reader) ;
//            		
//        			docList = (ArrayList<DocXmlVo>)searchXmlList.getSectionList().getSection().get(0).getDocList().getDoc();
//        						
//        			section.put("totcnt" , searchXmlList.getSectionList().getSection().get(0).getTotcnt());		// 총건수
//        			section.put("maxcnt" , searchXmlList.getSectionList().getSection().get(0).getMaxcnt());		// 페이지사이즈
//        			section.put("pagenum", searchXmlList.getSectionList().getSection().get(0).getPagenum());	// 페이지
//        						
//        			for(int i=0; i <docList.size(); i++ ){
//        				HashMap<String, Object> resultMap = new HashMap<String, Object>(); 
//        				// CMID 
//        				resultMap.put("CMID"	,docList.get(i).getAttList().getCNTID());
//        				resultMap.put("IMGPATH", docList.get(i).getAttList().getALBUM_IMG_URL());
//        				resultMap.put("TITLE"  , docList.get(i).getAttList().getTITLE());
//        				resultMap.put("SINGER" , docList.get(i).getAttList().getSINGER());
//        				
//        				
//        				searchResultList.add(mapResult);
//        			}
    				
    			}else{
    				mapResult.put("result", szResult);
    				searchResultList.add(mapResult);
    			}
    		}	
			
		} catch (SocketTimeoutException ste) {	
			System.out.println("SocketTimeoutException : " + ste.toString());
		} catch (MalformedURLException mue) {
			System.out.println("MalformedURLException : " + mue.toString());
		} catch (IOException ioe) {	
			System.out.println("IOException : " + ioe.toString());
		} catch ( Exception e ) {
			System.out.println("Exception : " + e.toString());
	    } 
		
		return searchResultList;
	}
	
	
	public String realTimeSearch(String szKeyword){
		
		HashMap<String, String> mapResult = new HashMap<String, String>();
		
		StringBuffer sbRequestUrl = new StringBuffer();
		HttpURLConnection http = null;
		BufferedReader br = null;
		
		String szSearchUrl = "";
		String szAuthKey = "";
		String szResult = "";
		
		try{
			szSearchUrl = "http://211.115.75.86:8578/auto/feelring/total";
			szAuthKey 	= "0CECMwnbz4tEXtgYQokAlQD3PeTmMTg1LwjtkEb83tw==";
			
//			"w"			: "FEELRING",
//    		"q"			: $('#keyword').val(),			// 키워드
//    		"section"	: "",							// 검색 세부영역
//    		"pg"		: idx,							// 페이지 번호
//    		"outmax"	: $('#pageSize').val(),			// 출력 개수
//    		"sort"		: $('#gubun').val(),
//    		"p"			: "",	
//    		"d"			: "",	
//    		"csq"		: ""
    			
			sbRequestUrl.append(szSearchUrl)
    		.append("/AUTO_FEELRING")
    		.append("/")
    		.append(URLEncoder.encode(szKeyword,"utf-8").replace("+", "%20"))
    		.append("/outmax=");
    		
    		URL url = new URL(sbRequestUrl.toString());
    		
    		http = (HttpURLConnection)url.openConnection();
    		http.setConnectTimeout(10000);
    		http.setReadTimeout(10000);
    		
    		http.setDoInput(true);
    		http.setDoOutput(true);
    		http.setUseCaches(false);
    		
    		http.setRequestProperty("return-type"	, "application/json");
    		http.setRequestProperty("Content-Type"	, "application/x-www-form-urlencoded");
    		http.setRequestProperty("auth-key"	 	, szAuthKey);
    		http.setRequestProperty("encrypt-yn" 	, "Y");
    		
    		int resCode = http.getResponseCode();
    		    		    		
    		// 성공
    		if(resCode == HttpURLConnection.HTTP_OK) {
    			br = new BufferedReader( new InputStreamReader(http.getInputStream(), "UTF-8"));
    			
    			String line;
    			StringBuffer sbContent = new StringBuffer();
    			while((line = br.readLine()) != null) {
    				sbContent.append(line);
    			}
   			
    			szResult = sbContent.toString();
    			
    			if(szResult.length() == 0){
    				szResult = "[]";
    			}
    			
    			// 성공
    			if(szResult.startsWith("[") ){
    				System.out.println("realTimeSearch Success... keyword 	: " + szKeyword);
    				System.out.println("realTimeSearch Success... result 	: " + szResult);
    				
    				szResult = szResult.substring(1, szResult.length()-1);
//    				String[] arrResult = szResult.split(",");
//    				for(int i=0; i<arrResult.length; i++){
//    					searchResultList.add(arrResult[i]);	
//    				}
    				
    			// 실패
    			}else{
    				
//    				resultMap = mapper.readValue(resultList ,new TypeReference<HashMap<String,Object>>() {});
//    				    			
//    				resultMap = (HashMap<String,Object>)resultMap.get("error");
//    				
//    				errLog.warn("[SearchController] searchKeyword HTTP Error Code^"+resultMap.get("code").toString()+"^Message^"+resultMap.get("message").toString()+"^Request url^"+szUrl);
    				System.out.println("realTimeSearch Fail...");
    			}
    		}	
			
		} catch (SocketTimeoutException ste) {	
			System.out.println("SocketTimeoutException : " + ste.toString());
		} catch (MalformedURLException mue) {
			System.out.println("MalformedURLException : " + mue.toString());
		} catch (IOException ioe) {	
			System.out.println("IOException : " + ioe.toString());
		} catch ( Exception e ) {
			System.out.println("Exception : " + e.toString());
	    } 
		
		return szResult;
	}
}
