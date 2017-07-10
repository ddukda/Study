package wincom.enc;

import java.io.PrintStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class comEncMake
{
  public static byte[] hexToByteArray(String hex)
  {
    if ((hex == null) || (hex.length() == 0)) {
      return null;
    }

    byte[] ba = new byte[hex.length() / 2];
    for (int i = 0; i < ba.length; ++i) {
      ba[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    }
    return ba;
  }

  public static String byteArrayToHexOrg(byte[] ba) {
    if ((ba == null) || (ba.length == 0)) {
      return null;
    }

    StringBuffer sb = new StringBuffer(ba.length * 2);

    for (int x = 0; x < ba.length; ++x) {
      String hexNumber = "0" + Integer.toHexString(0xFF & ba[x]);

      sb.append(hexNumber.substring(hexNumber.length() - 2));
    }
    return sb.toString();
  }

  public static String encrypt(String key, String message)
    throws Exception
  {
    SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(1, skeySpec);

    byte[] encrypted = cipher.doFinal(message.getBytes());
    return byteArrayToHexOrg(encrypted);
  }

  public static String decrypt(String key, String encrypted)
    throws Exception
  {
    SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(), "AES");

    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(2, skeySpec);
    byte[] original = cipher.doFinal(hexToByteArray(encrypted));
    String originalString = new String(original);
    return originalString;
  }

  public static void main(String[] args)
  {
    String key = "wincomCRPassword";
    String str = "";
    try
    {
      
//        str = "onionuser00!";
//        str = "oniondb";
    	str = "onionuser!123";
      

      String encryptAES = encrypt(key, str);

      System.out.println("String ARG :: " + str);
      System.out.println("encryp AES :: " + encryptAES);
      System.out.println("decryp AES :: " + decrypt(key, encryptAES));
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}