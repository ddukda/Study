package com.test;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Encoder;

public class AESEncryptHandler {
	private static int KEY_SIZE			= 32;
	private static int CLOSEAPI_SIZE	= 10;
	private static int BIZRING_SIZE		= 10;
	private static int INTERNAL_SIZE	= 20;
	private static int EXTERNAL_SIZE	= 20;
	
	private static char[][] cArr =	{
										{'0', 'A'}, {'1', 'B'}, {'2', 'C'}, {'3', 'D'}, {'4', 'E'}, {'5', 'F'}
									  , {'6', '0'}, {'7', '1'}, {'8', '2'}, {'9', '3'}, {'A', '9'}, {'B', '8'}
									  , {'C', '7'}, {'D', '6'}, {'E', '5'}, {'F', '4'}, {'G', '3'}, {'H', '2'}
									  , {'I', '1'}, {'J', '0'}, {'K', 'F'}, {'L', 'E'}, {'M', 'D'}, {'N', 'C'}
									  , {'O', 'B'}, {'P', 'A'}, {'Q', '9'}, {'R', '8'}, {'S', '7'}, {'T', '6'}
									  , {'U', '5'}, {'V', '4'}, {'W', '3'}, {'X', '2'}, {'Y', '1'}, {'Z', '0'}
									};
	
    /**
     * AES 占쏙옙占쏙옙占�占쏙옙호화
     * 
     * @param message
     * @return
     * @throws Exception
     */
    public static String encrypt1(String szSpec, String szCode, String szData) throws Exception {
    	String szKey    = "EC655C39874F67EB759A1A159FEB5AC5";

    	// use key coss2
        SecretKeySpec skeySpec = new SecretKeySpec(szKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("aes");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(szData.getBytes());
        String szEncrypt = byteArrayToHex(encrypted);
        
        String szEnCode =  new BASE64Encoder().encode(szEncrypt.getBytes());

       return szEnCode;
    }

    public static String encrypt2(String szSpec, String szCode, String szData) throws Exception {

    	String szKey    = "EC655C39874F67EB759A1A159FEB5AC5";
    	// use key coss2
        SecretKeySpec skeySpec = new SecretKeySpec(szKey.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("aes");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] encrypted = cipher.doFinal(szData.getBytes());
//        String szEncrypt = byteArrayToHex(encrypted);
        
        String szEnCode =  new BASE64Encoder().encode(encrypted);

       return szEnCode;
    }
    
    public static String encrypt3(String szSpec, String szCode, String szData) throws Exception {
    	String szKey    = "EC655C39874F67EB759A1A159FEB5AC5";

//    	// use key coss2
//        SecretKeySpec skeySpec = new SecretKeySpec(szKey.getBytes(), "AES");
//        Cipher cipher = Cipher.getInstance("AES");
//        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//
//        byte[] encrypted = cipher.doFinal(szData.getBytes());
//        String szEncrypt = byteArrayToHex(szData.getBytes());
        String szEnCode =  new BASE64Encoder().encode(szData.getBytes());

       return szEnCode;
    }
    /**
     * AES 占쏙옙占쏙옙占�占쏙옙호화
     * 
     * @param encrypted
     * @return
     * @throws Exception
     */
    public static String decrypt(String szSpec, String szCode, String szEncryptData) throws Exception {    	
//    	String szKey	= getEncryptKey(szSpec, szCode);
    	String szKey    = "EC655C39874F67EB759A1A159FEB5AC5";     
    	sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
    	szEncryptData  = new String(decoder.decodeBuffer(szEncryptData));
    	
    	// use key coss2
        SecretKeySpec skeySpec = new SecretKeySpec(szKey.getBytes(), "AES");
        
        Cipher cipher = Cipher.getInstance("aes");        
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);  
        
        byte[] original = cipher.doFinal(hexToByteArray(szEncryptData));        
        String originalString = new String(original);
        
        return originalString;
    }
    
    public static String getEncryptKey(String szSpec, String szCode) {
    	String szHexCode = convertStringHex(szCode.toUpperCase());
    	String szHexSpec = convertStringHex(szSpec.toUpperCase());
    	
    	String szKey		= "";
    	String szDefaultKey	= "EC655C398745616C55E43A159FEB5AC5";
    	
    	int nCutSize		= 0;
    	
    	if(szSpec == null || szSpec.equals("")) {
    		nCutSize = 0;
    	} else if(szSpec.equals("CLOSEAPI_SPEC")) {
    		nCutSize = CLOSEAPI_SIZE;
    	} else if(szSpec.equals("BIZRING_SPEC")) {
    		nCutSize = BIZRING_SIZE;
    	} else if(szSpec.equals("INTERNAL_SPEC")) {
    		nCutSize = INTERNAL_SIZE;
    	} else if(szSpec.equals("EXTERNAL_SPEC")) {
    		nCutSize = EXTERNAL_SIZE;
    	} else {
    		nCutSize = 0;
    	}
    	
    	if(nCutSize == 0) {
    		szKey = szDefaultKey;
    	} else {
    		szHexCode = szHexCode + szHexSpec;
    		
    		if(szHexCode.length() > nCutSize) {
    			szHexCode = szHexCode.substring(0, nCutSize);
    		}
    		
    		szKey = szDefaultKey.substring(0, (((KEY_SIZE - nCutSize) / 2)	+ (nCutSize - szHexCode.length())));
    		szKey = szKey + szHexCode;
    		szKey = szKey + szDefaultKey.substring(szKey.length(), szDefaultKey.length());
    	}
    	
    	return szKey;
    }
    
    private static String convertStringHex(String szData) {
    	String	szHexData		= "";
    	
    	int nLoof		= 0;
    	
    	while(nLoof < szData.length()) {
        	char	cConvertChar	= '0';
        	
    		for(int i=0;i<cArr.length;i++) {
    			if(cArr[i][0] == szData.charAt(nLoof)) {
    				cConvertChar = cArr[i][1];
    				break;
    			}
    		}
    		
    		szHexData += cConvertChar;
    		
    		nLoof++;
    	}
    	
    	return szHexData;
    }
    
	/**
     * hex to byte[] : 16占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쏙옙占쏙옙트 占썼열占쏙옙 占쏙옙환占싼댐옙.
     * 
     * @param hex    hex string
     * @return
     */
	private static byte[] hexToByteArray(String hex) {
        if (hex == null || hex.length() == 0) {
            return null;
        }

        byte[] ba = new byte[hex.length() / 2];
        for (int i = 0; i < ba.length; i++) {
            ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return ba;
    }
    
    /**
     * byte[] to hex : unsigned byte(占쏙옙占쏙옙트) 占썼열占쏙옙 16占쏙옙占�占쏙옙占쌘울옙占쏙옙 占쌕꾼댐옙.
     * 
     * @param ba        byte[]
     * @return
     */
    private static String byteArrayToHex(byte[] ba) {
        if (ba == null || ba.length == 0) {
            return null;
        }

        StringBuffer sb = new StringBuffer(ba.length * 2);
        String hexNumber;
        for (int x = 0; x < ba.length; x++) {
            hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

            sb.append(hexNumber.substring(hexNumber.length() - 2));
        }
        return sb.toString();
    }
    
    
}
