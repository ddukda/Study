package jino.study.regexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test1 {
	public static void main(String[] args) {

//		String szRegexp = "^\\w+@\\w+\\.\\w+$"; // 내가 만든 email 검증 정규 표현식
		String szRegexp = "^(?:\\w+\\.?)*\\w+@(?:\\w+\\.)+\\w+$";  // 이거 인터넷 꺼
		

		String emailStr = "babolsk@bbb.com";

		Pattern pattern = Pattern.compile(szRegexp);

		Matcher match = pattern.matcher(emailStr);

		// 매칭에 맞을 경우 true
		System.out.println("[" + emailStr + "] : " + match.find());

	}
}
