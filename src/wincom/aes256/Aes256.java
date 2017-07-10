package wincom.aes256;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Aes256 {
	
	public static void main(String[] args) throws InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException{
		String key = "EC655C39874F67EB759A1A159FEB5AC5";

		String szTestParam = "01028283669";
		String szEncodeText = AES256Cipher.AES_Encode(szTestParam, key);		
		System.out.println("AES256Encode : "+szEncodeText);

	}

}

