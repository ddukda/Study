package com.test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import feelring.common.ConvUtil;
import sun.misc.BASE64Encoder;

public class TEST2 {
	
    public static void main(String[] args){
    	TEST2 test = new TEST2();
    	
    	
    	System.out.println(test.getTelDash("01057402464"));
    	System.out.println(test.getTelDash("010057402464"));
    	System.out.println(test.getTelDash("1057402464"));
    	System.out.println(test.getTelDash("01957402464"));
    	System.out.println(test.getTelDash("0195742464"));
    	System.out.println(test.getTelDash("0257402464"));
    	System.out.println(test.getTelDash("0319786782"));
    	System.out.println(test.getTelDash("019007402464"));
    	System.out.println(test.getTelDash("019114"));
    	
    	
    	
    }
    
    
    public String getTelDash(String szNum)
    {
        String szTemp = "";
        szNum = ConvUtil.convMinChk(szNum);
        
        try {            
            if ((szNum.length() >= 8)&&(szNum != null))
            {
                if (szNum.substring(0,2).equals("02")) {
                    szTemp = "02-" + Integer.parseInt(szNum.substring(2, szNum.length()-4)) 
                           + "-" + szNum.substring(szNum.length()-4, szNum.length());
                } else if(szNum.substring(0, 4).equals("0130")) {
                	szTemp = szNum.substring(0, 4) + "-" + Integer.parseInt(szNum.substring(4, szNum.length()-4))
                			+ "-" + szNum.substring(szNum.length()-4, szNum.length());
                } else {
                    szTemp = szNum.substring(0,3) + "-" + Integer.parseInt(szNum.substring(3, szNum.length()-4))
                           + "-" + szNum.substring(szNum.length()-4, szNum.length());
                }
            } else {
                szTemp = szNum;
            }
   	    } catch(NumberFormatException ne) { 
   	    	System.out.println(ne.toString());
   	    } catch(Exception e) { 
   	    	System.out.println(e.toString());
   	    }

        return szTemp;
    } 
    
}
