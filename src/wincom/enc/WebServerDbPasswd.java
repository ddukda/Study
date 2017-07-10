package wincom.enc;

import sun.misc.BASE64Encoder;
import wincom.enc.bizring.comEncMake;
import kr.co.xest.security.encrypt.Base64Digest;

public class WebServerDbPasswd {
	public static void main(String[] args) throws Exception {
		// FEEL WEB
		BASE64Encoder en = new BASE64Encoder();
		// System.out.println(en.encode("oniondb00!".getBytes()));
		// System.out.println(en.encode("onionuser00!".getBytes()));
		System.out.println("FEEL WEB ORACLE PASSWD :: " + en.encode("onionuser!123".getBytes())); // 20170313
		System.out.println();

		// MOBILE WEB/3SA
		String key = "wincomCRPassword";
		String str = "";
		wincom.enc.comEncMake cem = new wincom.enc.comEncMake();

		// str = "onionuser00!";
		// str = "oniondb";
		str = "onionuser!123";

		String encryptAES = cem.encrypt(key, str);

//		System.out.println("String ARG :: " + str);
		System.out.println("MOBILE WEB ORACLE PASSWD :: " + encryptAES);
		System.out.println();

		wincom.enc.bizring.comEncMake cr = new wincom.enc.bizring.comEncMake();

		String bizKey = "bizringEnckPasswd";

		String bizStr = "bizringappuser00!";

		String bizEncryptAES = cr.encrypt(bizKey, bizStr);

//		System.out.println("String ARG :: " + str);
		System.out.println("BIZRING ORACLE PASSWD :: " + bizEncryptAES);

	}

}
