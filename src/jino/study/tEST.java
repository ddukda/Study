package jino.study;

import com.sun.java.util.collections.HashMap;

public class tEST {
	
	
	public static void main(String[] args) {
		
//		String a = "N";
//		String b = "N"; 
//		
//		String c = a;
//				
//				if(a == b) System.out.println("true");
//				else System.out.println("false");
//				
//				
//				HashMap hm = new HashMap();
//				hm.put("1", "2");
		
		String str1 = "AA";
		String str2 = "AA";
		String str3 = new String("AA");
		String str4 = new String("AA1");
		
		System.out.println(str1.hashCode() + "^" + str2.hashCode() + "^" + str3.hashCode() + "^" + str4.hashCode());
		
		
		if(str1 == str2){System.out.println("str1 == str2");}
		if(str1 == str3){System.out.println("str1 == str3");}
		if(str2 == str3){System.out.println("str2 == str3");}
		if(str1 == str4){System.out.println("str1 == str4");}
		if(str3 == str4){System.out.println("str3 == str4");}
		
			
		
		
		
		Integer n4 = 123;
		Integer n5 = new Integer(123);
		Integer n6 = 123;
		
		
		
		System.out.println(n4.hashCode() + "^" + n5.hashCode() + "^" + n6.hashCode());
		
		if(n4 == n5){System.out.println("n4 == n5");}
		if(n4 == n6){System.out.println("n4 == n6");}
		

	}
	
//	public static void main(String[] args) {
//		
////		int nErr = 0;
////		String szJumin = "790421";
////		
////		
////		for(int i = 0; i < szJumin.length(); i++ ) {
////			if( szJumin.charAt(i) < '0' || szJumin.charAt(i) > '9' ) {
////				System.out.println("szJumin.charAt(i) : " + szJumin.charAt(i));
////				nErr = -1;
////				break;
////			}
////		}
////		
////		System.out.println("nErr : " + nErr);
//		
////		String a = null;
////		
////		a = a.trim();
////		
////		System.out.println(a);
//		
//		String _strFilter = null;
//		
//		System.out.println("3");
//		
//		if(_strFilter == null && _strFilter.equals("")){
//			System.out.println("1");
//		}
//		
//		System.out.println("2");
//
//	}
}
