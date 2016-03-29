package feelring.common;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.net.*;

import javax.servlet.http.HttpServletRequest;

public class ConvUtil {
	
	public static String dash2Null(String szSrc) {

        if((szSrc == null)||(szSrc.equals(""))) {
        	szSrc = "";
        	return szSrc;
        }
            	
        int nLen = szSrc.length();
        
        StringBuffer szDes = new StringBuffer(nLen);

        for( int i=0; i<nLen; i++) {
            if (szSrc.charAt(i) != '-')
                szDes.append(szSrc.charAt(i));
        }
        return szDes.toString().trim();
    }
    
    public static String Comma2TwoComma(String szSrc) {
        
        if(szSrc == null) {
        	szSrc = "";
        	return szSrc;
        }
        
        int nLen = szSrc.length();
        
        StringBuffer szDes = new StringBuffer(nLen+10);

        for( int i=0; i<nLen; i++) {
            if (szSrc.charAt(i) != '\'')
                szDes.append(szSrc.charAt(i));
            else {
            	szDes.append(szSrc.charAt(i));
            	szDes.append('\'');
            }
        }
        
        return szDes.toString().trim();
    }
    
   public static String convMin(String szSrc) {
        
        if(szSrc == null || szSrc.length() < 5) {
        	szSrc = "";
        	return szSrc;
        }
            	
        int nLen    = szSrc.length();
        
        StringBuffer szDes = new StringBuffer(nLen);

        for( int i=0; i<nLen; i++) {
            if (szSrc.charAt(i) != '-') 
                szDes.append(szSrc.charAt(i));
        }

        if (szDes.charAt(0) == '0')
            szDes.delete(0, 1);

        if (szDes.charAt(2) == '0')
            szDes.delete(2, 3);
                       
        return szDes.toString().trim();
    }    

    public static String convCtnMin(String szCtn){
    	String szLdapCtn    = "";
        String szCtn1       = "";
        String szCtn2       = "";
        String szCtn3       = "";
        
        if(szCtn == null || szCtn.length() < 5) {
        	szCtn = "";
        	return szCtn;
        }
        
        if(szCtn.length() == 12){		//Ex: 010012341234
	      
	        if(szCtn.substring(4,5).equals("0")){						
	        	szCtn2              = szCtn.substring(5, szCtn.length()-4);
	        }else{
	        	szCtn2              = szCtn.substring(4, szCtn.length()-4);
	        }
        }else if(szCtn.length() == 11){		//Ex: 01012341234
        	
        	if(szCtn.substring(3,4).equals("0")){						
	        	szCtn2              = szCtn.substring(4, szCtn.length()-4);
	        }else{
	        	szCtn2              = szCtn.substring(3, szCtn.length()-4);
	        }
        }else if(szCtn.length() == 10){		//Ex: 0101231234
	        szCtn2              = szCtn.substring(3, szCtn.length()-4);
        }else{
        	return szCtn;
        }
        szCtn1              = szCtn.substring(0,3);
        szCtn3              = szCtn.substring(szCtn.length()-4, szCtn.length());
        
        szLdapCtn = szCtn1 + szCtn2 + szCtn3;

    	return szLdapCtn;
    }
    public static String convMinChk070(String szCtn) {
    	/* int nLen    = szCtn.length();
        if(szCtn == null || nLen < 8) {
        	szCtn = "";
        	return szCtn;
        }
        
        StringBuffer szDes = new StringBuffer(nLen);
        szDes.append(szCtn);
        
        // iherb 占쌤몌옙 ctn占쏙옙 070 占실댐옙 0070占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 0070占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙荑∽옙占�占쌌울옙 0 占쏙옙占쌍깍옙
        // 02 占실댐옙 0002占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙 3占쌘몌옙占쏙옙 000占쏙옙 占쏙옙占�'0'2占쏙옙 占쏙옙占쌍깍옙
        if(szDes.substring(0, 3).equals("000")){
        	szDes.delete(0, 2);
        }else if(szDes.substring(0, 2).equals("00")){
        	szDes.delete(0, 1);
        } 

        return szDes.toString();
        */
    	String szLdapCtn    = "";
        String szCtn1       = "";
        String szCtn2       = "";
        String szCtn3       = "";
        String szChgCtn = "";
        int nCtn;
        int nCtn1;
        
        if(szCtn == null || szCtn.length() < 8) {
        	szCtn = "";
        	return szCtn;
        }
        nCtn = Integer.parseInt(szCtn.substring(0,4));
        szChgCtn = Integer.toString(nCtn);
        szCtn1 = szChgCtn.substring(0,1);
        nCtn1 = Integer.parseInt(szCtn1);
        if(nCtn1>7 || nCtn1 <2){
        	return "";
        }else if(szCtn1.equals("2")){
        	szCtn1 = szChgCtn.substring(0,1);
        	 szCtn2 = szCtn.substring(szCtn.indexOf(szCtn1)+1,szCtn.length()-4);
        	
 		}else {
 			szCtn1 = szChgCtn.substring(0,2);
 			szCtn2 = szCtn.substring(szCtn.indexOf(szCtn1)+2,szCtn.length()-4);
 		}
       
        szCtn2 = Integer.toString(Integer.parseInt(szCtn2));
        szCtn3 = szCtn.substring(szCtn.length()-4, szCtn.length());
        
        szLdapCtn = "0"+szCtn1 + szCtn2 + szCtn3;

    	return szLdapCtn;
    }     
 
    /**
     * LDAPMin占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.(2012.02.13 Seop 占쏙옙占쏙옙 - 占쏙옙 占쏙옙 '0' 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙)
     *ldap占쏙옙占쏙옙 占쏙옙占쏙옙 ctn占쏙옙 占쏙옙환占싹울옙  占쏙옙占쏙옙歐占�占쏙옙占쏙옙 占쌉쇽옙
     * @param szCtn 占쌘듸옙占쏙옙 占쏙옙호
     * @return String LDAPMin 占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占싸울옙 占쏙옙占쌘울옙 占쏙옙체
     */
    public static String convLDAPMin(String szCtn){
    	 
    	if(szCtn == null) {
        	szCtn = "";
        	return szCtn;
        }

   	 	int nLen    = szCtn.length();
   	 	
   	 	if(nLen < 5){
	     	szCtn = "";
	    	return szCtn;
	    }
            	        
        StringBuffer szDes = new StringBuffer(nLen);
        szDes.append(szCtn);

        // 占쏙옙체 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占싹댐옙 占쏙옙占쏙옙 占쌓뱄옙째, 占쌕쇽옙占쏙옙째 占쌘몌옙占쏙옙 체크占싹울옙 占쏙옙占쏙옙占싹듸옙占쏙옙 占쏙옙占쏙옙(0200-0333-4444 --> 020-333-4444)
        for (int i = 0; i < 2; i++) {
	        if (szDes.charAt(3)=='0') {
	        	szDes.delete(3, 4);
	        }
        }

        // '0200'占싹띰옙(占쏙옙占쏙옙占쏙옙 2占쌘몌옙 占쏙옙占쏙옙占쏙옙호) 占쏙옙占쏙옙째 占쌘몌옙占쏙옙 '0' 占쏙옙占쏙옙(020-333-4444 --> 02-333-4444)
        if (szDes.charAt(0) == '0' && szDes.charAt(1) == '2' && szDes.charAt(2) == '0') {
        	szDes.delete(2, 3);
        }
        
        return szDes.toString();
    }
 
    /**
     * 占쏙옙占쌘울옙占쏙옙 첫占쏙옙째 "0"占쏙옙 占쏙옙占쏙옙 占쏙옙占�"0"占쏙옙 占쏙옙占쏙옙占쌍곤옙 '-'占쏙옙 占쏙옙占쏙옙.(2012-02-13 Seop)
     * parameter占쏙옙 占쏙옙占쏙옙占승곤옙占�Ctn체크占쏙옙 占쏙옙占�
     * @param szCtn
     * @return
     */
    public static String convMinChk(String szCtn) {
    	if(szCtn == null) {
        	szCtn = "";
        	return szCtn;
        }

   	 	int nLen    = szCtn.length();
   	 	
   	 	if(nLen < 5){
	     	szCtn = "";
	    	return szCtn;
	    }
        
        StringBuffer szDes = new StringBuffer(nLen);

        if (szCtn.indexOf("-") >= 0) {
        	for( int i=0; i<nLen; i++) {
                if (szCtn.charAt(i) != '-') 
                    szDes.append(szCtn.charAt(i));
            }        	
        	szCtn = szDes.toString();
        }
        
        if (!szCtn.substring(0, 1).equals("0")) {
        	szCtn = "0" + szCtn;
        }
        return szCtn;
    } 

    /**
     * 占쏙옙占쌘울옙占쏙옙 첫占쏙옙째 0占쏙옙 占쏙옙占쌔댐옙. 占쌈시뤄옙 占쏙옙占쏙옙 占쌓쏙옙트占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙.
     * DB占쏙옙占쏙옙占쏙옙 占쏙옙
     * @param szSrc
     * @return
     */
    public static String convMinFirst0Chk(String szSrc) {
    	 int nLen    = szSrc.length();
        
        if(szSrc == null || nLen < 8) {
        	szSrc = "";
        	return szSrc;
        }
        
        StringBuffer szDes = new StringBuffer(nLen);
        szDes.append(szSrc);

        if (szDes.charAt(0) == '0')
            szDes.delete(0, 1);
        
        return szDes.toString();
    } 

    /**
     * 占쏙옙占쌘울옙占쏙옙 첫占쏙옙째 0占쏙옙 占쏙옙占쌔댐옙.
     * DB占쏙옙占쏙옙占쏙옙 占쏙옙占�
     * @param szSrc
     * @return
     */
    public static String convMinFirst0CMSChk(String szSrc) {
    	 int nLen    = szSrc.length();
        
        if(szSrc == null || nLen < 6) {
        	szSrc = "";
        	return szSrc;
        }
        
        StringBuffer szDes = new StringBuffer(nLen);
        szDes.append(szSrc);

        if (szDes.charAt(0) == '0')
            szDes.delete(0, 1);
        
        return szDes.toString();
    } 
    
    /**
     * 占쏙옙호 체크(2012-02-14 Seop)
     * @param szCtn
     * @return
     */
    public static String convMinNumChk(String szCtn) { 
    	String szResult = "1";
    	
    	if(szCtn == null || szCtn.equals("")) {
    		szResult = "1";
		} else if(szCtn.length() < 9 || szCtn.length() > 11) {
            szResult = "1";
        } else if (!szCtn.substring(0, 1).equals("0")) {		// 2-3-4(02-333-4444) or 2-4-4(02-4444-4444) or 3-3-4 or 3-4-4
    		szResult = "1";
    	} else if(szCtn.substring(1, 2).equals("0") || szCtn.substring(1, 2).equals("8") || szCtn.substring(1, 2).equals("9")) {
        	szResult = "1";
        } else if(szCtn.indexOf("0000000") >= 0){
            szResult = "1";
        } else {
			szResult = "0";
		}
        
        return szResult;
    } 
    
    /**
     * LDAP占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙(2012-02-14 Seop)
     * @param szCtn 占쌘듸옙占쏙옙 占쏙옙호
     * @return String LDAP占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占싸울옙 占쏙옙占쌘울옙 占쏙옙체
     */ 
    public static String convMinLdap(String szCtn) {
    	
        String szLdapCtn    = "";
        String szCtn1       = "";
        String szCtn2       = "";
        String szCtn3       = "";
                
    	if(szCtn == null) {
        	szCtn = "";
        	return szCtn;
        }

   	 	int nLen    = szCtn.length();
   	 	
   	 	if(nLen < 5){
	     	szCtn = "";
	    	return szCtn;
	    }

        if (!szCtn.substring(0, 1).equals("0")) {
        	szCtn = "0" + szCtn;
        }
        
        if (szCtn.substring(0, 2).equals("02")) {
        	szCtn1			= szCtn.substring(0,2) + "0";	// 4-4-4 占쏙옙칙占쏙옙 占쏙옙占쌩깍옙 占쏙옙占쏙옙 "02"占싹띰옙 占쎌선 占쌘울옙 "0"占쏙옙 占쏙옙占쏙옙
            szCtn2          = szCtn.substring(2, szCtn.length()-4);
        } else {
            szCtn1			= szCtn.substring(0,3);
            szCtn2          = szCtn.substring(3, szCtn.length()-4);
        }

        szCtn3              = szCtn.substring(szCtn.length()-4, szCtn.length());
        
        if (szCtn2.length() == 3){
            szCtn2  = "00" + szCtn2;
        }else{
            szCtn2  = "0" + szCtn2;
        }
        szLdapCtn           = szCtn1 + szCtn2 + szCtn3;
        
        return szLdapCtn;
    }

    /**
     * 占쏙옙占쏙옙 占쏙옙짜占쏙옙 YYYYMMDD 占쏙옙占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
     * @return String YYYYMMDD 占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체
     */
	public static String getYYYYMMDD() {
	    Calendar cal = new GregorianCalendar();		
	
		String szDate = Integer.toString(cal.get(Calendar.YEAR));
  		if(cal.get(Calendar.MONTH) < 9)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.MONTH)+1);
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.MONTH)+1);

		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		return szDate.trim();	
	}    

	/**
	 * 占쏙옙占쏙옙 占쏙옙짜占쏙옙 YYYYMMDDHHMMSS 占쏙옙占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙
	 * @return String YYYYMMDDHHMMSS 占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체
	 */
	public static String getYMDHMS() {
	    Calendar cal = new GregorianCalendar();		
	
		String szDate = Integer.toString(cal.get(Calendar.YEAR));

  		if(cal.get(Calendar.MONTH) < 9)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.MONTH)+1);
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.MONTH)+1);
        		
		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		
		if(cal.get(Calendar.HOUR_OF_DAY) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
			
		if(cal.get(Calendar.MINUTE) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.MINUTE));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.MINUTE));

		if(cal.get(Calendar.SECOND) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.SECOND));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.SECOND));

		return szDate.trim();	
	}

	
	
	 /**
    * 占싹뤄옙占쏙옙  占쏙옙짜占쏙옙 YYYYMMDD 占쏙옙占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
    * @return String YYYYMMDD 占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체
    */
	public static String getYesterday() {
	    Calendar cal = new GregorianCalendar(Locale.KOREA);
	    java.util.Date trialTime = new java.util.Date();
	    cal.setTime(trialTime);
	    
	    cal.add(Calendar.DATE, -1);
	
		String szDate = Integer.toString(cal.get(Calendar.YEAR));
 		if(cal.get(Calendar.MONTH) < 9)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.MONTH)+1);
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.MONTH)+1);

		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		return szDate.trim();	
	}    
	
	
    /**
     * 占쏙옙占쏙옙觀占쏙옙占�占쏙옙占싹댐옙 占쏙옙占쏙옙占쏙옙占신�占쏙옙占싹거놂옙 占쏙옙 占쏙옙짜占쏙옙 YYYYMMDD 占쏙옙占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
     * @return String YYYYMMDD 占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체
     */
	public static String getCalMonth(int nMonth) {
	    Calendar cal = new GregorianCalendar();		
	
		String szDate = Integer.toString(cal.get(Calendar.YEAR));
  		if(cal.get(Calendar.MONTH) < 9)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.MONTH) + 1 + nMonth);
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.MONTH) + 1 + nMonth);

		if(cal.get(Calendar.DAY_OF_MONTH) < 10)
			szDate = szDate + "0" + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		else 
			szDate = szDate + Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
		return szDate.trim();	
	}    

	/**
	 * 8859-1占쏙옙 占쏙옙占쏙옙占�KSC5601 占쏙옙占쏙옙占쏙옙占�占쏙옙占쌘듸옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
	 * @param str 占쏙옙환占쏙옙 占쏙옙占쌘울옙 
	 * @return String KSC5601占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체 
	 * @throws UnsupportedEncodingException
	 */
    public static String getHangul(String str) throws UnsupportedEncodingException 
    {
        return new String(str.getBytes("8859_1"), "KSC5601");      
    }
	
    /**
     * ISO-8859-1占쏙옙 占쏙옙占쏙옙占�EUC-KR 占쏙옙占쏙옙占쏙옙占�占쏙옙占쌘듸옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙
     * @param str 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     * @return String EUC-KR占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체  
     * @throws UnsupportedEncodingException
     */
    public static String getUnicode(String str) throws UnsupportedEncodingException 
    {
        return encode(new String(str.getBytes("ISO-8859-1"), "EUC-KR"));
    }

    /**
     * EUC-KR占쏙옙 占쏙옙占쏙옙占�ISO-8859-1 占쏙옙占쏙옙占쏙옙占�占쏙옙占쌘듸옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
     * @param str 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     * @return String ISO-8859-1占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체 
     * @throws UnsupportedEncodingException
     */
    public static String getAscii(String str) throws UnsupportedEncodingException 
    {
        return new String(str.getBytes("EUC-KR"), "ISO-8859-1");
    }

    /**
     * Unicode占쏙옙 占쏙옙占쏙옙占�ISO-8859-1 占쏙옙占쏙옙占쏙옙占�占쏙옙占쌘듸옙占쏙옙 占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙占싼댐옙.
     * @param str 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     * @return String ISO-8859-1占쏙옙占쏙옙占쏙옙占�占쏙옙환占쏙옙 占쏙옙占쌘울옙 占쏙옙체 
     * @throws UnsupportedEncodingException
     */
    public static String getUniAscii(String str) throws UnsupportedEncodingException 
    {
        return new String(str.getBytes("Unicode"), "ISO-8859-1");
    }
    
    /**
     * 占쏙옙占쌘울옙占쏙옙 占쏙옙占쌘듸옙占싼댐옙.
     * @param str 占쏙옙占쌘듸옙占�占쏙옙占쌘울옙 
     * @return String 占쏙옙占쌘듸옙 占쏙옙 占쏙옙占쌘울옙
     */
    public static String encode(String str)
    {
        String strTemp = "";

        for(int i = 0 ; i < str.length() ; i++) 
        {
            switch (str.charAt(i)) 
            {
                case '\u00B7': strTemp += '\u30FB';    // 占쏙옙
                    break;  
                case '\u2299': strTemp += '\u25C9';    // 占쏙옙
                    break;  
                default      : strTemp += str.charAt(i);
            }
        } 
        return strTemp;
    }

    /**
     * 占쏙옙占쌘울옙占쏙옙 占쏙옙占쌘듸옙占싼댐옙.
     * @param str 占쏙옙占쌘듸옙占�占쏙옙占쌘울옙 
     * @return String 占쏙옙占쌘듸옙 占쏙옙 占쏙옙占쌘울옙 
     */
    public static String decode(String str) 
    {
        StringBuffer strTemp = new StringBuffer(str.length());
        for(int j = 0 ; j < str.length() ; j++) 
        {
            switch (str.charAt(j)) 
            {
                case '\u30FB': strTemp.append('\u00B7'); break;  // 占쏙옙
                case '\u25C9': strTemp.append('\u2299'); break;  // 占쏙옙
                default      : strTemp.append(str.charAt(j));
            }
        }	
        str = strTemp.toString();
        return str;
    }    	
	
    /**
     * 占쌍민뱄옙호占쏙옙 占쏙옙占쌌쇽옙占쏙옙 占싯삼옙占싼댐옙.
     * @param szJumin 占쌍민뱄옙호
     * @return boolean 占싯삼옙占쏙옙, 占쏙옙占쏙옙 : true 占쏙옙占쏙옙 : false
     */
	public static boolean chkJumin(String szJumin) {         
        byte[] bJumin   = szJumin.getBytes();
        int nJuminLen   = bJumin.length;
        int nTemp       = 0;
        int nKey        = 0;
        int nCob        = 2;
        
        if (nJuminLen < 13) {
            return false;    
        }         
        
        for (int i=0; i<(bJumin.length - 1); i++) {
		    if ((bJumin[i] == 0x2D)||(bJumin[i] == 0x2F)) continue;          
            nTemp = nTemp + ((int)(bJumin[i]-0x30))*nCob;
            if (nCob == 9) {
                nCob = 2;
            }
            else {
                nCob ++;    
            }    
        }        
        
        nTemp   = nTemp % 11;       
        nKey    = 11 - nTemp;
		        
        if (nKey > 9) nKey = nKey % 10;
        
        if (nKey == (int)(bJumin[nJuminLen-1]-0x30)) {
            return true;    
        }
        else {
            return false;
        }         
    }
       
	/**
	 * 占쏙옙화占쏙옙호 占쏙옙占쌌쇽옙占쏙옙 占싯삼옙占싼댐옙.
	 * @param szCtn 占쌘듸옙占쏙옙 占쏙옙호
	 * @return boolean 占싯삼옙占쏙옙, 占쏙옙占쏙옙 : true 占쏙옙占쏙옙 : false
	 */
	public static boolean chkMinno(String szCtn) {
	    /*
            YES占쏙옙占쏙옙占쏙옙 Check 
            349, 677, 801~850, 780~789	        
	    */
        String szTmp    = null;
        int nLen        = szCtn.length();
                                        
        if (szCtn.startsWith("19")) {
            if (nLen == 9) {
                szTmp = szCtn.substring(2, 5);
            }
            else {
                szTmp = szCtn.substring(2, 6); 
            }
            
            int nTmp = Integer.parseInt(szTmp);
             
            if ((nTmp == 349)||(nTmp == 677)) {
                return false;    
            }
               
            if ((nTmp > 800)&&(nTmp < 851)) {
                return false;
            }
    
            if ((nTmp > 779)&&(nTmp < 790)) {
                return false;
            }
        }            
        return true;
    }
    
	/**
	 * 占쏙옙占쏙옙占�占쏙옙占쏙옙 占쏙옙占쏙옙 占시곤옙 占쏙옙占쌌쇽옙占쏙옙 占싯삼옙占싼댐옙
	 * @return boolean 占싯삼옙占쏙옙, 占쏙옙占쏙옙 : true 占쏙옙占쏙옙 : false
	 */
	public static boolean chkTime() {
        String szMinute = null;
        
        Calendar cal    = Calendar.getInstance();
        
        int nHour       = cal.get(Calendar.HOUR_OF_DAY);        
       
        int nMinute     = cal.get(Calendar.MINUTE);
        if (nMinute < 10) szMinute = "0" + Integer.toString(nMinute);
        else szMinute = Integer.toString(nMinute);
        
        String szHHMM = Integer.toString(nHour) + szMinute;
        
        int nHHMM = Integer.parseInt(szHHMM);
                
        if ((nHHMM < 900) || (nHHMM > 2100)) {
            return false;        
        }
                
        return true;
	}

	/**
	 * 占쏙옙占쌘울옙 치환
	 * @param mainString 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
	 * @param oldString 占쏙옙占쏙옙臼占쏙옙占�占쏙옙占쌘울옙
	 * @param newString 占쏙옙占쏙옙 占쏙옙占쏙옙占�占쏙옙占쌘울옙
	 * @return String 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
	 */
	public static String strReplaceNew(
		  String mainString,
		  String oldString,
		  String newString) {
		 
		if (mainString == null) {
			return null;
		}
		
		if (oldString == null || oldString.length() == 0) {
			return mainString;
		}
		
		if (newString == null) {
			newString = "";
		}

		int i = mainString.lastIndexOf(oldString);
		if (i < 0)
			return mainString;

		StringBuffer mainSb = new StringBuffer(mainString);

		while (i >= 0) {
			mainSb.replace(i, (i + oldString.length()), newString);
			i = mainString.lastIndexOf(oldString, i - 1);
		}
		return mainSb.toString();
	}
	
	/**
	 * 占쏙옙占쌘울옙 치환
	 * @param szOrg 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
	 * @param szSrc 치환占쏙옙 占쏙옙占쌘울옙
	 * @param szDes 치환占쏙옙 占쏙옙占쌘울옙
	 * @return String 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
	 */
    public static String strReplace(String szOrg, String szSrc, String szDes)   {
		int i           = szOrg.indexOf(szSrc);
		String szRst    = "";

		while(i > -1) {
			szRst   = szRst + szOrg.substring(0,i) + szDes;
			szOrg   = szOrg.substring(i+1);
			i = szOrg.indexOf(szSrc);
		}
		
		szRst = szRst + szOrg;

		return szRst;
	}
	
    /**
     * 특占쏙옙 占쏙옙占쏙옙 占쏙옙환 처占쏙옙 
     * @param szSrc 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
     * @return String 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     */
    public static String convStr(String szSrc) {
    	szSrc = nullToSpace(szSrc);
    	
	    szSrc = strReplace(szSrc, "&", "&amp;");
	    szSrc = strReplace(szSrc, ">", "&gt;");
	    szSrc = strReplace(szSrc, "<", "&lt;");
	    szSrc = strReplace(szSrc, "'", "&apos;"); 
	    szSrc = strReplace(szSrc, "\"", "&quot;");
	    szSrc = strReplace(szSrc, "$", "$$");
	    
        return szSrc.trim();
    }
    
    
    /**
     *  <> 특占쏙옙 占쏙옙占쏙옙 占쏙옙환 처占쏙옙 
     * @param szSrc 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
     * @return String 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     */
    public static String convStr2(String szSrc) {
	   // szSrc = strReplace(szSrc, ">", "&lt;&gt;");
	    szSrc = strReplace(szSrc, "<", "&nbsp;<");
	    
        return szSrc;
    }
    
	
    /**
     * 占쏙옙占쌘울옙 치환
     * @param szSrc 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
     * @return String
     */
    public static String XSSconvStr(String szSrc) {
    	if(szSrc != null) {
		    szSrc = strReplace(szSrc, "&", "&amp;");
		    szSrc = strReplace(szSrc, ">", "&gt;");
		    szSrc = strReplace(szSrc, "<", "&lt;");
		    szSrc = strReplace(szSrc, "'", "&apos;"); 
		    szSrc = strReplace(szSrc, "\"", "&quot;");
		    szSrc = strReplace(szSrc, "$", "$$");
		    szSrc = szSrc.replaceAll("script", "xxaaa");
		    szSrc = szSrc.replaceAll("alert", "xxbbb");
		    szSrc = szSrc.replaceAll("http", "xxccc");
		    szSrc = szSrc.replaceAll("img src", "xxddd");
		    szSrc = szSrc.replaceAll("window.open", "xxeee");
		    szSrc = szSrc.replaceAll("foobar", "xxfff");
    	}
        return szSrc;
    }

    /**
     * 占쏙옙占쌘울옙 치환
     * @param szSrc 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
     * @return String
     */
    public static String XSSconvStr2(String szSrc) {
    	if(szSrc != null) {
		    szSrc = strReplace(szSrc, "<", "&lt;");
		    szSrc = strReplace(szSrc, ">", "&gt;");
		    szSrc = strReplace(szSrc, "(", "&#40");
		    szSrc = strReplace(szSrc, ")", "&#41");
		    szSrc = strReplace(szSrc, "#", "&#35");
		    szSrc = strReplace(szSrc, ".", "&#39"); 
		    szSrc = strReplace(szSrc, "\"", "&#34");
		    szSrc = strReplace(szSrc, "/", "&#47");
		    szSrc = strReplace(szSrc, "\\", "&#92");
		    szSrc = strReplace(szSrc, ":", "&#59");
		    szSrc = strReplace(szSrc, "\n", "&#10");
		    szSrc = strReplace(szSrc, "\r", "&#13");
    	}
        return szSrc;
    }
    
    /**
     * 占쏙옙占쌘울옙 치환 - 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙載�占쏙옙占쌘울옙占쏙옙 and, or 占쏙옙占쏙옙 占쌍댐옙 占쏙옙占�占쏙옙환처占쏙옙
     * @param szSrc 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
     * @return String
     */
    public static String XSSconvStrSql(String szSrc) {
    	if(szSrc != null) {
		    szSrc = strReplace(szSrc, "&", "&amp;");
		    szSrc = strReplace(szSrc, ">", "&gt;");
		    szSrc = strReplace(szSrc, "<", "&lt;");
		    szSrc = strReplace(szSrc, "'", "&apos;"); 
		    szSrc = strReplace(szSrc, "\"", "&quot;");
		    szSrc = strReplace(szSrc, "$", "$$");
		    szSrc = szSrc.replaceAll("script", "xxaaa");
		    szSrc = szSrc.replaceAll("alert", "xxbbb");
		    szSrc = szSrc.replaceAll("http", "xxccc");
		    szSrc = szSrc.replaceAll("img src", "xxddd");
		    szSrc = szSrc.replaceAll("window.open", "xxeee");
		    szSrc = szSrc.replaceAll("foobar", "xxfff");
		    szSrc = szSrc.replaceAll("and", "xxggg");
		    szSrc = szSrc.replaceAll("or", "xxhhh");
    	}
        return szSrc;
    }

    /**
     * 占싱븝옙트/占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙 占쏙옙占쌘울옙 치환
     * @param szSrc 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
     * @return String
     */
    public static String XSSconvStrBoard(String szSrc) {
    	szSrc = nullToSpace(szSrc);
    	szSrc = XSSconvStr(szSrc);    	
	    szSrc = szSrc.replaceAll("!pre", "<pre>");
	    szSrc = szSrc.replaceAll("!/pre", "</pre>");
	    szSrc = szSrc.replaceAll("!br", "<br /> ");
	    szSrc = szSrc.replaceAll("!b", "<b>");
	    szSrc = szSrc.replaceAll("!/b", "</b>");
	    szSrc = szSrc.replaceAll("!font", "<font ");
	    szSrc = szSrc.replaceAll("!@", ">");
	    szSrc = szSrc.replaceAll("!/font", "</font> ");
        return szSrc;
    }

    /**
     * 占쏙옙占쌘울옙 치환
     * @param str 占쏙옙환占쏙옙 占쏙옙체 占쏙옙占쌘울옙
     * @return String
     */
	public static String strToSpace(String str)
	{
		for(int i = 0 ; i < str.length(); i++) {
			if( str.charAt(i) < '0' || str.charAt(i) > '9' ) {
					return "";
			}
		}
		
		return ConvUtil.getSqlData(str.trim());
	}
	
    /**
     * 특占쏙옙 占쏙옙占쏙옙 占쏙옙환 처占쏙옙 
     * @param szSrc 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
     * @return String 占쏙옙환占쏙옙 占쏙옙占쌘울옙
     */
    public static String convStatusStr(String szSrc) {
	    szSrc = strReplace(szSrc, "'", "\\'");
	    szSrc = strReplace(szSrc, "\"", "\\\"");
        return szSrc.trim();
    }
        
    /**
     * 특占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙占�占쏙옙환
     * @param szStr
     * @return
     */
    public static String strToNbsp(String szStr) { 
    	if(szStr != null && szStr.equals("") && szStr.equals("null")) {
    		szStr = szStr.replaceAll("&", "&nbsp;");
    		szStr = strReplace(szStr, "~", "&nbsp;");
    		szStr = strReplace(szStr, "{", "&nbsp;");
    		szStr = strReplace(szStr, "}", "&nbsp;");
    		szStr = strReplace(szStr, "|", "&nbsp;");
    		szStr = strReplace(szStr, "%", "&nbsp;");
    		szStr = strReplace(szStr, "#", "&nbsp;");
    		szStr = strReplace(szStr, "\"", "&nbsp;");
    	}
        return szStr;
    }
    
    /**
     * mid占쏙옙 캐占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙환.
     * @param mid 占쌨댐옙ID
     * @return byte[]
     */
    public static byte[] mid2Char(String mid){
    	String str = "";
    	if("null".equals(mid) || mid.length() == 00 || mid == null) {
    		str = "000000000000";
    	} else {
	    	DecimalFormat df = new DecimalFormat("000000000000");
	        str  = df.format(Integer.parseInt(mid));
    	}
    	
    	return str.getBytes();
    }
    
    /**
     * null占쏙옙 占쏙옙占쏙옙占쏙옙占�占쌕꾸깍옙
     * @param str 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
     * @return String
     */
	public static String nullToSpace(String str)
	{
		// Offering 占쏙옙占쏙옙 (占쏙옙抉占� 2008/11/03)
		if (str == null || str.trim().equals("") || str.equals("null"))
		{
			return "";
		}
		return ConvUtil.getSqlData(str.trim());
	}
	
	public static String nullToSpaceObj(Object obj){

		String str = "";
		if (obj == null){
			str = "";
		} else {
			str = obj.toString();
		}
		return str.trim();
	}	
	
	/**
	 * '占쏙옙 " 占쏙옙占쏙옙占싹깍옙
	 * @param temp 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
	 * @return String
	 */
	public static String getSqlData(String temp)
	{
		StringBuffer result= new StringBuffer();

		for(int i=0; i< temp.length(); i++)
		{
			String kk = temp.substring(i,i+1);
			char[] ca = temp.toCharArray();
			if(ca[i] != '\"' && ca[i] != '\'')
				result.append(kk);
		}
		return result.toString();
	}
	
	/**
	 * 占쏙옙占쏙옙占쏙옙 占쏙옙짜 占쏙옙占싹깍옙
	 * @param year 占썩도
	 * @param month 占쏙옙
	 * @return int
	 */
	public static int getLastDay(int year, int month){
		int lastDay = 0;
		
		Calendar cal = new GregorianCalendar(year,month, 1);
		cal.add(Calendar.DAY_OF_MONTH  , -1);
		lastDay = cal.get(Calendar.DAY_OF_MONTH);
		
		return lastDay;
	}
	
	/**
	 * 占시곤옙 占쏙옙占싹깍옙
	 * @param time 占시곤옙
	 * @return String
	 */
	public static String getTimeString(long time) {
	    int i = 0x36ee80;
	    int j = 60000;
	    long l1 = time;
	    int k = (int) (l1 / (long) i);
	    
	    l1 -= (k * i);

	    int l = (int) (l1 / (long) j);
	    l1 -= (l * j);

	    int i1 = (int) (l1 / 1000L);
	    l1 -= (i1 * 1000);

	    int j1 = (int) l1;

        DecimalFormat df = new DecimalFormat("000");

	    return ((k * 3600) + (l * 60) + i1) + "." + df.format(j1);
	} 
	
	public static String getSubString(String p_str, int p_len) {
        if (p_str!=null && !"".equals(p_str)) {
            boolean chkFlag = false;
            String szSubString = p_str.trim();
            byte[] arName = szSubString.getBytes();
            String p_tailstr = "...";
            if (arName.length > p_len) {
                for (int idx = 0; idx < p_len; idx++) {
                    if (arName[idx] < 0) {
                        chkFlag = !chkFlag;
                    } else {
                        chkFlag = false;
                    }
                }
                if (chkFlag) {
                	szSubString = new String(arName, 0, p_len + 1) + p_tailstr;
                } else {
                	szSubString = new String(arName, 0, p_len) + p_tailstr;
                }
            } else {
            	szSubString = new String(arName, 0, arName.length);
            }
            return szSubString;
        }
        return p_str;
    }

    public static String toBr(String szSrc) {
    	szSrc = nullToSpace(szSrc);
    	
	    szSrc = strReplace(szSrc, "\n", "<br/>");
	    
        return szSrc.trim();
    }
    
    
    public static String getUrlFileName(String sUri){
		String curPath        = ConvUtil.nullToSpace(sUri);
		
		
		StringTokenizer stUrl = new StringTokenizer(curPath, "/");
		
		int iPos = 0;
		
		
		String[] arrTokens;
		arrTokens = new String[stUrl.countTokens()]; 
		
		
		while ( stUrl.hasMoreTokens() ){
			arrTokens[iPos] = stUrl.nextToken();
			iPos++;
		}
				
		String sFullFileName = "";
		
		if( iPos > 0){
			sFullFileName = arrTokens[iPos-1]; //占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙.... 占쏙옙占쏙옙占쏙옙..
		}
		
		String sFileName = "";
		sFileName = sFullFileName.substring(0, sFullFileName.lastIndexOf(".")); //확占쏙옙占쌘몌옙 占쏙옙占쏙옙占쏙옙, 占쏙옙占쏙옙占�占쏙옙占싹몌옙.
		
		if (sFileName.length() >= 2) {//=1.x占쏙옙2.x占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙歐占�占쏙옙占쌔쇽옙
			String sTemp = sFileName.substring(sFileName.length() - 2, sFileName.length());
			
			if (sTemp.equals("20")) {
				sFileName = sFileName.substring(0, sFileName.length() - 2);
			}
		}
		
    	return sFileName;
    }
    

	public static String getRequestUrl(HttpServletRequest request) {

		int nIndex				= 0;

    	String sRtnUrl       = request.getRequestURI();
    	
		Enumeration header = request.getParameterNames();
		String szKind		= "?";
		
		while (header.hasMoreElements())
		{
			
			String szKey		= (String)header.nextElement();
			
			if(nIndex != 0)
				szKind = "&";
			

				sRtnUrl += szKind + szKey + "=" + request.getParameter(szKey);


			nIndex++;
		}

		

		
		return sRtnUrl;
	}
	
	
	
	
	/**
	 * nowrap 占쏙옙占쏙옙 占쏙옙占쏙옙 
	 * @param request
	 * @return String szNowrap_type
	 * @author 
	 * @see 
	 */
	
	public static String getNowrapType(HttpServletRequest request) {
		/*
		Config      configinfo  = new Config();
		String[] szArr  = configinfo.getConfig("FEEL_WAP", "WML_MODE_PHONE").split(",");
		String[] szHardInfoArr = request.getHeader("WAP-HardInfo").split(";");    //占싹듸옙占쏙옙占�占쏙옙占쏙옙 占쏙옙占쏙옙占�
		String szDeviceType    = ""; 
		
		String szNowrap_type = "<p style=\"white-space:nowrap;\">";
		for(int k=0; k < szHardInfoArr.length; k++){
			if(szHardInfoArr[k].indexOf("DeviceType")>-1){ 
					szDeviceType = szHardInfoArr[k].substring(szHardInfoArr[k].indexOf("=")+1);
		        	break;
			}
		}
		for(int k=0; k < szArr.length; k++){
			if(szArr[k].equals(szDeviceType)){ 
					szNowrap_type = "<p wml:mode=\"nowrap\">";
		         	break;
			}
		}
		return szNowrap_type;
		*/
		return "<p style=\"white-space:nowrap;\">";
	}
	
	/**
	 * 占쏙옙占쏙옙치 占쏙옙커占쏙옙 占싫되댐옙 占쏙옙 占쏙옙占쏙옙 - 캔占쏙옙占쏙옙占�
	 * @param request
	 * @return String szFocusType
	 * @author 
	 * @see 2010.05.12 jin MUSIC UI 2占쏙옙
	 */
	public static String getFocusType(HttpServletRequest request){
		/*
		Config configinfo = new Config();
		
		String[] szArr  = configinfo.getConfig("FEEL_WAP", "WML_TOTAL_FOCUS_PHONE").split(",");
		String[] szHardInfoArr = request.getHeader("WAP-HardInfo").split(";");    //占싹듸옙占쏙옙占�占쏙옙占쏙옙 占쏙옙占쏙옙占�
		String szDeviceType    = ""; 
		
		String szFocusType = "1";  // 占쏙옙커占쏙옙占쏙옙 占실는곤옙占�..
		for(int k=0; k < szHardInfoArr.length; k++){
			if(szHardInfoArr[k].indexOf("DeviceType")>-1){ 
				szDeviceType = szHardInfoArr[k].substring(szHardInfoArr[k].indexOf("=")+1);
		        	break;
			}
		}
		for(int k=0; k < szArr.length; k++){
			if(szArr[k].equals(szDeviceType)){ 
					szFocusType = "0"; // 占쏙옙커占쏙옙占쏙옙 占싫되댐옙 占쏙옙占�..
		         	break;
			}
		}
		
		return szFocusType;
		*/
		return "1";
	}
	
	/**
	 * 占쏙옙占쏙옙치 占쏙옙커占쏙옙 占싫되댐옙 占쏙옙 占쏙옙占쏙옙 2 - 캔占쏙옙 占쏙옙 占쏙옙占�占쌤몌옙
	 * @param request
	 * @return String szFocusType
	 * @author 
	 * @see 2010.05.12 jin MUSIC UI 2占쏙옙
	 */
	public static String getFocusType_nonTotal(HttpServletRequest request){
		/*
		Config configinfo = new Config();
		
		String[] szArr  = configinfo.getConfig("FEEL_WAP", "WML_NON_TOTAL_FOCUS_PHONE").split(",");
		String[] szHardInfoArr = request.getHeader("WAP-HardInfo").split(";");    //占싹듸옙占쏙옙占�占쏙옙占쏙옙 占쏙옙占쏙옙占�
		String szDeviceType    = ""; 
		
		String szFocusType = "1";  // 占쏙옙커占쏙옙占쏙옙 占실는곤옙占�..
		for(int k=0; k < szHardInfoArr.length; k++){
			if(szHardInfoArr[k].indexOf("DeviceType")>-1){ 
				szDeviceType = szHardInfoArr[k].substring(szHardInfoArr[k].indexOf("=")+1);
		        	break;
			}
		}
		for(int k=0; k < szArr.length; k++){
			if(szArr[k].equals(szDeviceType)){ 
					szFocusType = "0"; // 占쏙옙커占쏙옙占쏙옙 占싫되댐옙 占쏙옙占�..
		         	break;
			}
		}
		return szFocusType;
		*/
		return "1";
	}
	
	/**
	 * 占쏙옙占쏙옙창占쏙옙 占쌕울옙琯占쏙옙占�占쏙옙占쏙옙 占쏙옙占쏙옙 0,1 
	 * @param num
	 * @return String szNum
	 * @author 
	 * @see 2010.04.23 jin MUSIC UI 2占쏙옙
	 */
	public static String getOneOrZero(String num){
		
		String szNum = "";
		if(num.equals("0")){
			szNum = "0";
		} else {
			szNum = "1";
		}
		
		return szNum;
	}
	
	/**
	 * 占싼뱄옙占쏙옙 
	 * @param num
	 * @return String str
	 * @author 
	 * @see 2010.04.23 jin MUSIC UI 2占쏙옙
	 */
	
	public static String getNumRing(int num){
		
		StringBuffer str = new StringBuffer();
		
		str.append("<td width='16' height='20' valign='middle' align='center'>");
		str.append("\n <span style='font-size:10px;background-color:#7f91df;color:#FFFFFF;width:13px;height:12px;font-weight:bold;margin-left:2px;'>").append(num).append("</span>");
		str.append("\n </td>");
		
		return str.toString();
		
	}
	
	/**
	 * 占쏙옙占쏙옙창 占쏙옙占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쏙옙치 - 占쏙옙占쏙옙트占쏙옙 占쏙옙占쏙옙占쏙옙
	 * @param imgName,imgpath,cmid
	 * @return String str
	 * @author 
	 * @see 2010.04.23 jin MUSIC UI 2占쏙옙
	 */

	public static boolean chkParseInt(String strNum){
		if(strNum == null || strNum.length() == 0) return false;
		if(strNum.matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 占싱븝옙트 占싱뱄옙占쏙옙占쏙옙 占쏙옙占쏙옙 URL 占쏙옙 占쌔쏙옙트占쏙옙 占쌉뤄옙
	 * @param path
	 * @param url
	 * @param index
	 * @return
	 */
	
	public static boolean EventCreateFile(String path,String[] url,int index ) {
		
		FileWriter log_writer	= null;
		PrintWriter pLogWriter  = null;
		boolean bl				= false;
    	String szData			= "";

		try {

		    log_writer = new FileWriter(path);
            pLogWriter = new PrintWriter(log_writer);
		    
            for(int i=0; i<index; i++){
            	if(i == index-1 ){
            		szData += "event"+i+".gif^"+url[i];
            	}else{
            		szData += "event"+i+".gif^"+url[i]+"\n";
            	}
            		
            }

            pLogWriter.println(szData);
            pLogWriter.flush();
            szData = "";

		    bl = true;

		} catch(Exception e) {
			System.out.println ("CreateExlFile Exception ======= ["+e.toString()+"]");
		    bl = false;
		} finally {
			if( log_writer != null) try { log_writer.close(); }catch(Exception e){ }
			if( pLogWriter != null) try { pLogWriter.close(); }catch(Exception e){ }
		}
		
		return bl;
	}
	
    /**
     * null占쏙옙 0占쏙옙占쏙옙 占쌕꾸깍옙
     * @param str 처占쏙옙 占쏙옙 占쏙옙占쌘울옙 
     * @return String
     */
	public static String nullToZero(String str){

		if (str == null || str.trim().equals("") || str.equals("null")){
			return "0";
		}
		return ConvUtil.getSqlData(str.trim());
	}

	/**
	 * 占쏙옙占시듸옙 占쌓몌옙 占쏙옙占쏙옙트 占쌍깍옙 (2011.09.08 reme)
	 * @param str 占쏙옙占쏙옙 占쏙옙占쏙옙
	 * @param compareStr 占쏟교뱄옙占쏙옙
	 * @param onStr 占쏙옙占쏙옙트 string 
	 * @param noOnstr  占썩본 string
	 * @return str == compareStr 占싱몌옙 onStr 占싣니몌옙 noOnstr
	 */
	public static String getOnStr(String str, String compareStr, String onStr, String noOnstr){
		
		if(str!=null && compareStr!=null && str.equals(compareStr)){
			return nullToSpace2(onStr);
		}else{
			return nullToSpace2(noOnstr);
		}
	}
	/**
	 * 占쏙옙占시듸옙 占쌓몌옙 占쏙옙占쏙옙트 占쌍깍옙 (2011.09.08 reme)
	 * @param No 占쏙옙占쏙옙 占쏙옙占쏙옙
	 * @param compareNo 占쏙옙 占쏙옙占쏙옙
	 * @param onStr 占쏙옙占쏙옙트 string 
	 * @param noOnstr 占썩본 string
	 * @return No == compareNo 占싱몌옙 onStr 占싣니몌옙 noOnstr
	 */
	public static String getOnStr(int No, int compareNo, String onStr, String noOnstr){
		
		if(No==compareNo){
			return nullToSpace2(onStr);
		}else{
			return nullToSpace2(noOnstr);
		}		
	}
	/**
	 * null -> "" 처占쏙옙 (2011.09.08 reme)
	 * @param str
	 * @return
	 */
	public static String nullToSpace2(String str){
		if(str == null || str.trim().equals("") || str.equals("null")){
			return "";
		}else{
			return str;
		}
	}
	
	/**
	 * 占쏙옙占쏙옙트 tr class return (2011.10.12 reme)
	 * @param size      占쏙옙占쏙옙트 占쏙옙占쏙옙占쏙옙
	 * @param lastNo    占쏙옙占쏙옙占쏙옙 占쏙옙호
	 * @param firstNo   첫占쏙옙째 占쏙옙호
	 * @param currentNo 占쏙옙占쏙옙 占쏙옙호
	 * @return class='firstline lastline' or class='firstline' or class='lastline'
	 */
	public static String getListOnstr(int size,int lastNo,int firstNo, int currentNo ){
		
		String onStr = "";
		if(size<=1){
			onStr = "class='firstline lastline'";
		}else{
			if(firstNo == currentNo){
				onStr = "class='firstline'";
			}else if(lastNo == currentNo){
				onStr = "class='lastline'";	
			}
		}		
		return onStr;		
	}
	/**
	 * CP_CONTENT 占쏙옙占싱븝옙占쏙옙 占쌩몌옙占쏙옙 占쏙옙占쏙옙 占십듸옙(ALBUM_MAKE_DT)占쏙옙 占쏙옙효占쏙옙 체크(2011-08-31 Seop)
	 * @param szMakeDate
	 * @return
	 */
	public static String chkMakeDate(String szMakeDate){
		String	szTemp		= nullToSpace(szMakeDate);
		
		String 	szTmpYear	= "";
		String	szTmpMonth	= "";
		String	szTmpDay	= "";
		int 	nTmpNow		= 0;
		int 	nTmpYear	= 0;
		int 	nTmpMonth	= 0;
		int 	nTmpDay		= 0;
				
		if (szTemp.equals("-") || szTemp.equals("")) return "-";
	
		szTmpYear	= szTemp.substring(0, 4);
		szTmpMonth	= szTemp.substring(4, 6);
		szTmpDay	= szTemp.substring(6);
		
		nTmpYear	= Integer.parseInt(szTmpYear);
		nTmpMonth	= Integer.parseInt(szTmpMonth);
		nTmpDay		= Integer.parseInt(szTmpDay);

		nTmpNow	= getNowDate("year");

		if (nTmpYear < nTmpNow) {
			szTemp = szTmpYear + "-" + szTmpMonth + "-" + szTmpDay;
		} else {
			nTmpNow = getNowDate("month");
			
			if (nTmpMonth > nTmpNow) {					// 占쌩매년도占쏙옙 占쏙옙占쏙옙占�占쏙옙占쏙옙 占쌩몌옙 占쏙옙占쏙옙 占쏙옙占썹보占쏙옙 크占쏙옙 占쏙옙占쏙옙 
				return "-";
			} else if (nTmpMonth < nTmpNow) {
				szTemp = szTmpYear + "-" + szTmpMonth + "-" + szTmpDay;
			} else {
				nTmpNow = getNowDate("day");
				
				if (nTmpDay > nTmpNow) {				//占쌩매년도占쏙옙 占쌩몌옙 占쏙옙占쏙옙 占쏙옙占쏙옙占�占쏙옙占쏙옙 占쏙옙占쌘곤옙 占쏙옙占썹보占쏙옙 크占쏙옙 占쏙옙占쏙옙
					return "-";
				} else {
					szTemp = szTmpYear + "-" + szTmpMonth + "-" + szTmpDay;
				} 
			}
		}

		return szTemp;
	}

    /**
     * 占쏙옙占쏙옙 占쏙옙/占쏙옙/占싹곤옙 占쌔댐옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙
     * @return String
     */
    public static int getNowDate(String szType) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Seoul"));
        String	szDate	= "";
        
        if (szType.equals("year")) {
            szDate = Integer.toString(cal.get(Calendar.YEAR));
        } else if (szType.equals("month")) {
	        szDate = Integer.toString(cal.get(Calendar.MONTH) + 1);
        } else if (szType.equals("day")) {
	        szDate = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));        	
        } else {
        	szDate = "-1";
        }
        return Integer.parseInt(szDate.trim());
    }
     
	/**
	 * 클占쏙옙占싱억옙트占쏙옙 IP 占쌍소몌옙 占쏙옙占쏙옙
	 * @param request
	 * @return
	 */
	public static String getClientIpAddr(HttpServletRequest request)
	{
		String clientIp = request.getHeader("Proxy-Client-IP");
		
		if(clientIp == null)
		{
			clientIp = request.getHeader("WL-Proxy-Client-IP");			
			if(clientIp == null)
			{
				clientIp = request.getHeader("X-Forwarded-For");
				if(clientIp == null)
					clientIp = request.getRemoteAddr();
			}
		}
		
		return clientIp;
	}
    
    
    
    /**
     * YYYYMMDD 占쏙옙占쏙옙占�占쏙옙짜占쏙옙 占쏙옙효占쏙옙 占쏙옙짜占쏙옙占쏙옙 체크
     * @return boolean
     */
    public static boolean isValidYYYYMMDD(String date) {
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 
		  if (date == null) return false;
		  String format = null;
		  try {
		   format = sdf.format(sdf.parse(date));
		  } catch (ParseException e) {}
		  return date.equals(format);		  
	 }
}
	