package jino.study.algorithm;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String szInput;
        int nA=0, nB=0;
		
		szInput = sc.nextLine();
        nA = Integer.parseInt(szInput);
        szInput = sc.nextLine();
        nB = Integer.parseInt(szInput);
        System.out.println(nA + nB);
    }
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		String szInput;
//		String[] szArrInput;
//		String szA,szB;
//		int cnt=0, nALength=0, De = 10;
//		char[] G;
//		String szFlag = "A";
//		
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		
//		szA = szArrInput[0];
//		szB = szArrInput[1];
//		
//		BigInteger A = new BigInteger(szA);
//		BigInteger B = new BigInteger(szB);
//		
//		
//		BigInteger C;
//		BigInteger D = new BigInteger("1");
//		BigInteger E = new BigInteger("1");
//		
//		while(true){
//			
//			int aIndex = 0;
//			nALength = szA.length();
//			
//			if ( (aIndex = szA.indexOf("3")) > -1 || (aIndex = szA.indexOf("6")) > -1 || (aIndex = szA.indexOf("9")) > -1 ) {
//				
//				
//				if(nALength-aIndex > 1){
//					if(nALength-aIndex != 2) {
//						De = 1;
//						for(int i=0; i<nALength-aIndex-1; i++){
//							De*=10;
//						}
//					}else{
//						De = 10;	
//					}
//					
//					E = new BigInteger(String.valueOf(De-Integer.parseInt(szA.substring(aIndex+1))));
//					cnt = cnt + E.intValue();
//					szFlag = "B";
//				}else{
//						cnt++;
//				}
//				
//			}else{
//				G = szA.toCharArray();
//				C = new BigInteger("0");
//				for(int i=0; i<G.length; i++){
//					C = C.add(new BigInteger(String.valueOf(G[i])));
//				}	
//				if((C.intValue() % 3) == 0){
//					cnt++;
//				}
//			}
//			
//			System.out.println(szFlag + ", " + De + ", " + cnt + ", " +nALength+ ", " +aIndex + ", " + A);
//			
//			
//			
//			if(A.equals(B)) break;
//			else if(A.compareTo(B) == 1){
//				
//				cnt = cnt - A.subtract(B).intValue();			
//				
//				break;
//			}
//			
//			if(szFlag.equals("A")){
//				A = A.add(D);
//			}else{
//				A = A.add(E);
//				szFlag="A";
//			}
//			
//			
//			
//			szA = String.valueOf(A);
//		}
//		System.out.println(""  + (cnt % 20150523));
//		
//		sc.close();
//	}

}


//public class Main {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		String szInput;
//		String[] szArrInput;
//		String szA,szB;
//		int cnt=0, nA=0;
//		char[] G;
//
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		szA = szArrInput[0];
//		szB = szArrInput[1];
//		
//		BigInteger A = new BigInteger(szA);
//		BigInteger B = new BigInteger(szB);
//		BigInteger C;
//		BigInteger D = new BigInteger("1");
//		System.out.println((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
//		while(true){
//			
//			G = szA.toCharArray();
//			
//			C = new BigInteger("0");
//			
//			for(int i=0; i<G.length; i++){
//				C = C.add(new BigInteger(String.valueOf(G[i])));
//			}	
//			
//			nA = C.intValue();
//			
//			if ( szA.indexOf("3") > -1 || 
//				 szA.indexOf("6") > -1 ||
//				 szA.indexOf("9") > -1 ||
//				 (nA % 3) == 0) {
//				cnt++;
//			}			
//			
//			if(A.equals(B)) break;
//			
//			A = A.add(D);
//			szA = String.valueOf(A);
//		}
//		System.out.println((new SimpleDateFormat("yyyyMMddHHmmssSSS")).format(new Date()));
//		System.out.println(""  + (cnt % 20150523));
//		
//		sc.close();
//	}
//
//}

