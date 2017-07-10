package lguplus.security.vulner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.codec.binary.Base64;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SecurityModule implements ServletContextListener {
	private static Document document;
	private static String serPath;
	public static MessageDigest md;
	public static byte[] ivBytes = new byte[16];
	URL u;

	private void ServerInfo(String ip, String port) throws UnknownHostException {
		String serverIP = InetAddress.getLocalHost().getHostAddress();
		String HostName = InetAddress.getLocalHost().getHostName();
		String Os_Info = System.getProperty("os.name");
		String language_version = "jdk :" + System.getProperty("java.version");
		try {
			String line;
			String data = URLEncoder.encode("serverIP", "UTF-8") + "="
					+ URLEncoder.encode(serverIP, "UTF-8");
			data = data + "&" + URLEncoder.encode("HostName", "UTF-8") + "="
					+ URLEncoder.encode(HostName, "UTF-8");
			data = data + "&" + URLEncoder.encode("Os_Info", "UTF-8") + "="
					+ URLEncoder.encode(Os_Info, "UTF-8");
			data = data + "&" + URLEncoder.encode("language_version", "UTF-8")
					+ "=" + URLEncoder.encode(language_version, "UTF-8");

			URL url = new URL("http://" + ip + ":" + port
					+ "/getServerInfo.php");

			URLConnection conn = url.openConnection();

			conn.setDoOutput(true);
			OutputStreamWriter wr = new OutputStreamWriter(
					conn.getOutputStream());
			wr.write(data);
			wr.flush();

			BufferedReader rd = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "UTF-8"));

			while ((line = rd.readLine()) != null) {
				System.out.println(line);
			}
			wr.close();
			rd.close();
		} catch (Exception localException) {
		}
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		String fdir = sce.getServletContext().getRealPath(
				"/WEB-INF/VulnerCheckList.xml");
		String encfdir = sce.getServletContext().getRealPath(
				"/WEB-INF/SecurityKey.ser");
		serPath = encfdir;
		File file = new File(fdir);
		try {
			document = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder().parse(file);
			context.setAttribute("secu_xml_data", document);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void contextDestroyed(ServletContextEvent arg0) {
	}

	public static String VulnerabilityChek(String strInputText, int CheckType, String ServiceName, String VulnerabilityName) {
		System.out.println("1111111111111111111111111");
		String data = strInputText;
		try {
			data = data.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			data = data.replaceAll("[+]", "%2B");
			data = URLDecoder.decode(data, "ISO-8859-1");
		} catch (Exception e) {
			System.out.println("1 VulnerabilityChek Exception : " + e.toString());
		}

		strInputText = data;

		strInputText = strInputText.replaceAll("", "");
		strInputText = strInputText.replaceAll("%00", "");

		String[] ServiceNames = ServiceName.split("\\|");
		String[] VulnerabilityNames = VulnerabilityName.split("\\|");

		for (int sidx = 0; sidx < ServiceNames.length; ++sidx) {
			String ServiceNameValue = ServiceNames[sidx];
			for (int vidx = 0; vidx < VulnerabilityNames.length; ++vidx) {
				String VulnerabilityNameValue = VulnerabilityNames[vidx];

				NodeList ServiceNodeList = document.getElementsByTagName("Service");
				NodeList VulNodeList = (NodeList) getElByName2(ServiceNodeList, "Service", ServiceNameValue);
				NodeList checkNodeList = (NodeList) getElByName2(VulNodeList, "Vulnerability", VulnerabilityNameValue);
				
				System.out.println("checkNodeList.getLength() : " + checkNodeList.getLength());
				

				for (int idx = 0; idx < checkNodeList.getLength(); ++idx) {
					Node node = checkNodeList.item(idx);
					if (!(node.getNodeName().equals("Check"))) {
						node.getParentNode().removeChild(node);
					}

				}

				for (int idx = 0; idx < checkNodeList.getLength(); ++idx) {
					NodeList checkChilds = checkNodeList.item(idx).getChildNodes();
					NodeList itemArray = (NodeList) getElByName(checkChilds, "ItemArray");

					for (int i = 0; i < itemArray.getLength(); ++i) {
						Node item = itemArray.item(i);

						String TagName = "";
						String OrgTagName = "";
						String[] regxArr = { ".", "$", "(", ")", "^", "+", "?", "{", "}", "|", "-", "[", "]", "*" };
						if (item.getNodeName() == "item") {
							String str = getValue(item);
							OrgTagName = str;

							for (int chrIdx = 0; chrIdx < str.length(); ++chrIdx) {
								if (Arrays.asList(regxArr).indexOf(String.valueOf(str.charAt(chrIdx))) < 0)
									TagName = TagName + str.charAt(chrIdx) + "\\s*";
								else {
									TagName = TagName + "\\" + str.charAt(chrIdx) + "\\s*";
								}

							}

							if (TagName != "") {
								TagName = TagName.substring(0, TagName.length() - 3);
							}

						}

						Node StartNode = (Node) getElByName(checkChilds, "StartRegex");

						String StartRegex = getValue(StartNode).replaceAll("\\r\\n|\\r|\\n|\\s", "");

						Node EndNode = (Node) getElByName(checkChilds, "EndRegex");
						String EndRegex = getValue(EndNode).replaceAll("\\r\\n|\\r|\\n|\\s", "");
						Node ReplaceNode = (Node) getElByName(checkChilds, "ReplaceValue");
						String ReplaceValue = getValue(ReplaceNode).replaceAll("\\r\\n|\\r|\\n|\\s", "");

						if (TagName == "") {
							continue;
						}
						if (CheckType == 1) {
							if (((Element) checkNodeList.item(idx))
									.getAttribute("type").equals(
											new String("1"))) {
								strInputText = LoopReplaceVulnerability(
										strInputText, StartRegex + TagName
												+ EndRegex,
										ReplaceValue.replaceAll("ITEM",
												OrgTagName.toLowerCase()));
								
							} else {
								strInputText = ReplaceVulnerability(
										strInputText, StartRegex + TagName
												+ EndRegex,
										ReplaceValue.replaceAll("ITEM",
												OrgTagName.toLowerCase()));
							}
						} else if (HasVulnerability(strInputText, StartRegex
								+ TagName + EndRegex)) {
							return "true";
						}
					}
				}

			}

		}

		if (CheckType == 1) {
			strInputText.replaceAll("%25", "%");
			strInputText.replaceAll("%2B", "+");

			return strInputText;
		}

		return "false";
	}

	private static String LoopReplaceVulnerability(String strValue,
			String strTagName, String strReplaceValue) {
		Pattern p = Pattern.compile(strTagName, 42);
		Matcher m = p.matcher(strValue);

		int safeKey = 0;
		boolean flag = m.find();
		while (flag) {
			strValue = strValue.replaceAll("(?ism)" + strTagName,
					strReplaceValue);
			m = p.matcher(strValue);
			flag = m.find();

			++safeKey;
			if (safeKey > 10000)
				break;
		}
		return strValue;
	}

	private static String ReplaceVulnerability(String strValue, String strTagName, String ReplaceValue) {
		strValue = strValue.replaceAll("(?ism)" + strTagName, ReplaceValue);
		return strValue;
	}

	private static boolean HasVulnerability(String strInputText,
			String strTagName) {
		Pattern p = Pattern.compile(strTagName, 42);
		Matcher m = p.matcher(strInputText);
		boolean result = m.find();

		return result;
	}

	public static Object getElByName(NodeList checkChilds, String Elname) {
		Object tnode = null;
		for (int j = 0; j < checkChilds.getLength(); ++j) {
			Node childNode = checkChilds.item(j);
			if ((childNode.getNodeType() != 1)
					|| (!(childNode.getNodeName().equals(Elname))))
				continue;
			tnode = childNode;
		}

		return tnode;
	}

	public static Object getElByName2(NodeList checkChilds, String Elname, String AttName) {
		Object tnode = null;
		try {
			System.out.println("checkChilds.getLength() : " + checkChilds.getLength());
			for (int j = 0; j < checkChilds.getLength(); ++j) {
				Node childNode = checkChilds.item(j);
				if ((childNode.getNodeType() != 1)
						|| (!(childNode.getNodeName().equals(Elname)))
						|| (!(((Element) childNode).getAttribute("name")
								.equals(AttName))))
					continue;
				tnode = childNode;
				
			}
		} catch (Exception e) {
			System.out.println("getElByName2 Exception : " + e.toString());
		}

		return tnode;
	}

	private static void getContent(Node node, StringBuffer sb) {
		Node child = node.getFirstChild();
		while (child != null) {
			if (child.getNodeType() == 3) {
				sb.append(child.getNodeValue());
			} else {
				getContent(child, sb);
			}
			child = child.getNextSibling();
		}
	}

	public static String getValue(Node node) {
		String textValue = "";
		Node child = node.getFirstChild();
		try {
			textValue = child.getNodeValue();
		} catch (NullPointerException localNullPointerException) {
		}

		return textValue;
	}

	public static String GET_Key() throws IOException {
		String key = "";

		File f = new File(serPath);
		try {
			FileReader fileReader = new FileReader(f);
			BufferedReader reader = new BufferedReader(fileReader);

			String line = null;
			while ((line = reader.readLine()) != null) {
				key = line;
				reader.close();
			}
		} catch (Exception localException) {
		}

		return key;
	}

	public static String AES256_Encrypt(String str)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException, IOException {
		String key = GET_Key();
		byte[] textBytes = str.getBytes("UTF-8");
		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		Cipher cipher = null;
		cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(1, newKey, ivSpec);
		return Base64.encodeBase64String(cipher.doFinal(textBytes));
	}

	public static String AES256_Decrypt(String str)
			throws UnsupportedEncodingException, NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException, IOException {
		String key = GET_Key();
		byte[] textBytes = Base64.decodeBase64(str);

		AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
		SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(2, newKey, ivSpec);
		return new String(cipher.doFinal(textBytes), "UTF-8");
	}

	public static String SHA512_Encrypt(String str) {
		String tempPassword = "";
		try {
			if (md == null)
				md = MessageDigest.getInstance("SHA-512");

			md.update(str.getBytes());
			byte[] mb = md.digest();
			for (int i = 0; i < mb.length; ++i) {
				byte temp = mb[i];
				String s = Integer.toHexString(temp);
				while (s.length() < 2) {
					s = "0" + s;
				}
				s = s.substring(s.length() - 2);
				tempPassword = tempPassword + s;
			}
			return tempPassword;
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
}