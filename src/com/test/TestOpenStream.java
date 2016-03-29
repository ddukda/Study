package com.test;
import java.io.*;
import java.net.*;

public class TestOpenStream {
	
	public static String test1() {
//		String szUrl = "http://192.168.223.112/simul/feel2NmRingDwnTM.jsp";
		String szUrl = "http://naver.com";
		String szTmp = "";
		String szValue = "";
		String szRst = "";
		
		// String szParam = "?seq=" + szSeq + "&ctn=" + szCtn + "&svc_type=" +
		// szSvc_type + "&newctn=" + szNewctn + "&req_date=" + szReq_date;
		// String szFullUrl = szUrl + szParam;
		// Log.write_log(6, "NameCircuit^" + szFullUrl );
		try {
			URL source = new URL(szUrl);
			BufferedReader br = new BufferedReader(new InputStreamReader(source.openStream(), "utf-8"));
			while ((szTmp = br.readLine()) != null) {
				szValue += szTmp;
			}
//			szRst = szValue.substring(szValue.indexOf("result"), szValue.length());
			szRst = szValue;
		} catch (Exception e) {
			return e.toString();
		}
		
		return szRst;
	}
	
	public static String test2() {
		return "test";
	}
	
}
