package jino.study.enumeration;

import java.util.HashMap;

public class GenericTest01 {

	public static void main(String args[]){
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("ONE", "1");
		hm.put("TWO", "2");
		
		String szOne = hm.get("ONE");
		
		System.out.println(szOne);
		
		
	}
	
}
