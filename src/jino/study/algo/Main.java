package jino.study.algo;

import java.util.Scanner;

public class Main {
//	https://www.algospot.com/judge/problem/read/WEIRD
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String szTime = sc.nextLine();
		int nTime = Integer.parseInt(szTime);
		
		while(nTime-- > 0){
			String szRst = "";

			
				
			
			System.out.println(szRst);
		}
		
		sc.close();
	}
	
}

//String szXY1 = sc.nextLine(); 
//String[] arrXY1 = szXY1.split(" ");
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	String szTime = sc.nextLine();
//	int nTime = Integer.parseInt(szTime);
//	
//	while(nTime-- > 0){
//		String szRst = "";
//
//		
//			
//		
//		System.out.println(szRst);
//	}
//	
//	sc.close();
//}

//https://www.algospot.com/judge/problem/read/DRAWRECT
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String szTime = sc.nextLine();
//		int nTime = Integer.parseInt(szTime);
//		
//		while(nTime-- > 0){
//			String szRst = "";
//			String szXY1 = sc.nextLine(); 
//			String szXY2 = sc.nextLine();
//			String szXY3 = sc.nextLine();
//			
//			String[] arrXY1 = szXY1.split(" ");
//			String[] arrXY2 = szXY2.split(" ");
//			String[] arrXY3 = szXY3.split(" ");
//			
//			String szX1 = arrXY1[0];
//			String szX2 = arrXY2[0];
//			String szX3 = arrXY3[0];
//			String szY1 = arrXY1[1];
//			String szY2 = arrXY2[1];
//			String szY3 = arrXY3[1];
//			
//			String szX4 = "";
//			String szY4 = "";
//			
//			if(szX1.equals(szX2)){
//				szX4 = szX3;
//			}else if(szX1.equals(szX3)){
//				szX4 = szX2;
//			}else if(szX2.equals(szX3)){
//				szX4 = szX1;
//			}
//			
//			if(szY1.equals(szY2)){
//				szY4 = szY3;
//			}else if(szY1.equals(szY3)){
//				szY4 = szY2;
//			}else if(szY2.equals(szY3)){
//				szY4 = szY1;
//			}
//			
//			szRst = szX4 + " " + szY4;			
//			
//			System.out.println(szRst);
//		}
//		
//		sc.close();
//	}
//	
//}

//https://www.algospot.com/judge/problem/read/XHAENEUNG
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String szTime = sc.nextLine();
//		int nTime = Integer.parseInt(szTime);
//		
//		while(nTime-- > 0){
//			String szRst = "";
//			String szInput = sc.nextLine();
//			String[] arrInput = szInput.split(" ");
//			// 0 번째 숫자 / 1번째 연산자 / 2번째 숫자 / 3번째 연산자 / 4번째 답
//			int n1, n2, nRst;
//			String szAnswer;
//			
//			n1 = convertNum(arrInput[0]);
//			n2 = convertNum(arrInput[2]);
//			
//			nRst = result(n1, n2, arrInput[1]);
//			
//			
//			
//			if(nRst < 0 || nRst > 10){
//				szRst = "NO";
//			}else{
//				szAnswer = convertStrNum(nRst);
//				szRst = compSpell(szAnswer, arrInput[4]);
//			}
//			
//			System.out.println(szRst);
//		}
//		
//		sc.close();
//	}
//	
//	public static String compSpell(String A1, String A2){
//		String szRst = "";
//		String szTemp = "";
//		int A1length = A1.length();
//		int A2length = A2.length();
//		
//		if(A1length != A2length){
//			return "NO";
//		}
//		
//		String[] arrA1 = new String[A1length];
//		String[] arrA2 = new String[A2length];
//		
//		
//		for(int i=0; i<A1length; i++){
//			arrA1[i] = String.valueOf(A1.charAt(i));
//		}
//		
//		for(int i=0; i<A2length; i++){
//			arrA2[i] = String.valueOf(A2.charAt(i));
//		}
//		
//		for(int i=0; i<A1length-1; i++){
//			
//			for(int j=0; j<A1length-1; j++){
//				
//				if(arrA1[j].charAt(0) > arrA1[j+1].charAt(0)){
//					szTemp = arrA1[j];
//					arrA1[j] = arrA1[j+1];
//					arrA1[j+1] = szTemp ;
//				}
//				
//				if(arrA2[j].charAt(0) > arrA2[j+1].charAt(0)){
//					szTemp = arrA2[j];
//					arrA2[j] = arrA2[j+1];
//					arrA2[j+1] = szTemp ;
//				}
//			}
//		}
//		
//	
//		
//		
//		A1 = ""; A2 ="";
//		for(int i=0; i<A1length; i++){
//			A1 += arrA1[i];
//			A2 += arrA2[i];
//		}
//		
//		if(A1.equals(A2)){
//			szRst = "YES";
//		}else{
//			szRst = "NO";
//		}
//			
//		return szRst;
//	}
//	
//	
//	public static String convertStrNum(int nRst){
//		String[] arrNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//		return arrNum[nRst];
//	}
//	
//	 
//	public static int convertNum(String szNum){
//		int nNum = 0;
//		String[] arrNum = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
//		
//		for(int i=0; i<arrNum.length; i++){
//			if(arrNum[i].equals(szNum)){
//				nNum = i;
//				break;
//			}
//		}
//
//		return nNum;
//	}
//	
//	public static int result(int n1, int n2, String szOper){
//		int nNum = 0;
//		String[] arrOper = {"+", "-", "*"};
//		
//		
//		for(int i=0; i<arrOper.length; i++){
//			if(arrOper[i].equals(szOper)){
//				nNum = i;
//				break;
//			}
//		}
//		
//		if(nNum == 0){
//			return n1 + n2;
//		}else if(nNum == 1){
//			return n1 - n2;
//		}else{
//			return n1 * n2;
//		}
//	}











//https://www.algospot.com/judge/problem/read/HOTSUMMER
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	String szTime = sc.nextLine();
//	int nTime = Integer.parseInt(szTime);
//	
//	while(nTime-- > 0){
//		String szRst = "";
//		
//		String szTotal = sc.nextLine();
//		String szInput = sc.nextLine();
//		String[] arrInput = szInput.split(" ");
//		int nRst = 0;
//		
//		int nTotal = Integer.parseInt(szTotal);
//		
//		for(int i=0; i<arrInput.length; i++){
//			nRst += Integer.parseInt(arrInput[i]);
//		}
//		
//		if(nRst <= nTotal){
//			szRst = "YES";
//		}else{
//			szRst = "NO";
//		}
//		
//		
//		System.out.println(szRst);
//	}
//	
//	sc.close();
//}




//https://www.algospot.com/judge/problem/read/MISPELL
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	String szTime = sc.nextLine();
//	int nTime = Integer.parseInt(szTime);
//	
//	while(nTime-- > 0){
//		String szInput = sc.nextLine();
//		String szRst = "";
//		
//		String[] arrInput = szInput.split(" ");
//		int nMissPoint = Integer.parseInt(arrInput[0]) - 1;
//		if(nMissPoint == -1){
//			szRst = arrInput[1].trim();
//		}else{
//			String szCheckString = arrInput[1].trim();
//			szRst = szCheckString.substring(0, nMissPoint) + szCheckString.substring(nMissPoint+1);
//		}
//		
//		
//		System.out.println(szRst);
//	}
//	
//	sc.close();
//}



//https://www.algospot.com/judge/problem/read/ENCRYPT
//
//
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int nTime = sc.nextInt();
//	sc.nextLine();
//	
//	while(nTime-- > 0){
//		String szInput = sc.nextLine();
//		String szRst = "";
//		int nInputLength = 0;
//		nInputLength = szInput.length(); 
//		String[] arrInput = new String[nInputLength];
//		String[] arrOutput= new String[nInputLength];
//		
//		for(int i=0; i<nInputLength; i++){
//			arrInput[i] = String.valueOf(szInput.charAt(i));
//		}
//		
//		int cnt = 0;
//		for(int i=0; i<2; i++){
//			for(int j=0; j<nInputLength; j++){
//				if(i == 0 && j%2 == 0){
//					arrOutput[cnt++] = arrInput[j];
//				}else if(i == 1 && j%2 != 0){
//					arrOutput[cnt++] = arrInput[j];
//				}
//			}
//		}
//		
//		for(int i=0; i<nInputLength; i++){
//			szRst += arrOutput[i];
//		}
//		
//		System.out.println(szRst);
//	}
//	
//	sc.close();
// }





//https://www.algospot.com/judge/problem/read/LECTURE
//
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int nTime = sc.nextInt();
//	sc.nextLine();
//	
//	while(nTime-- > 0){
//		String szInput = sc.nextLine(); 
//
//		int nInputLength = szInput.length();
//		String[] arrInput = new String[nInputLength/2];
//		String szTemp = "";
//
//		for(int i=0; i<arrInput.length; i++){
//			arrInput[i] = szInput.substring(i*2, i*2+2);
//		}
//		
//		for(int i=0; i<arrInput.length; i++){
//			for(int j=0; j<arrInput.length-1; j++){
//				if(arrInput[j].charAt(0) > arrInput[j+1].charAt(0)){
//					szTemp = arrInput[j];
//					arrInput[j] = arrInput[j+1];
//					arrInput[j+1] = szTemp;
//				}
//			}
//		}
//		
//		for(int i=0; i<arrInput.length; i++){
//			for(int j=0; j<arrInput.length-1; j++){
//				if(arrInput[j].charAt(0) == arrInput[j+1].charAt(0)){
//					if(arrInput[j].charAt(1) > arrInput[j+1].charAt(1)){
//						szTemp = arrInput[j];
//						arrInput[j] = arrInput[j+1];
//						arrInput[j+1] = szTemp;
//					}
//				}
//			}
//		}
//		
//		String szRst = "";
//		for(int i=0; i<arrInput.length; i++){
//			szRst += arrInput[i];
//		}
//		
//		System.out.println(szRst);
//	}
//	
//	sc.close();
// }


//https://www.algospot.com/judge/problem/submit/DRAWRECT
//
//public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int nTime = sc.nextInt();
//	sc.nextLine();
//	
//	int nX = 0;
//	int nY = 0;
//	
//	
//	while(nTime-- > 0){
//		
//		String firXY = sc.nextLine();
//		String secXY = sc.nextLine();
//		String thrXY = sc.nextLine();
//		
//		String[] XY1 = firXY.split(" ");
//		String X1 = XY1[0];
//		String Y1 = XY1[1];
//		
//		String[] XY2 = secXY.split(" ");
//		String X2 = XY2[0];
//		String Y2 = XY2[1];
//		
//		String[] XY3 = thrXY.split(" ");
//		String X3 = XY3[0];
//		String Y3 = XY3[1];
//		
//		int nX1 = Integer.parseInt(X1);
//		int nY1 = Integer.parseInt(Y1);
//		int nX2 = Integer.parseInt(X2);
//		int nY2 = Integer.parseInt(Y2);
//		int nX3 = Integer.parseInt(X3);
//		int nY3 = Integer.parseInt(Y3);
//		
//		if(nX1 == nX2) nX = nX3;
//		else if(nX2 == nX3) nX = nX1;
//		else if(nX1 == nX3) nX = nX2;
//		
//		if(nY1 == nY2) nY = nY3;
//		else if(nY2 == nY3) nY = nY1;
//		else if(nY1 == nY3) nY = nY2;
//		
//		System.out.println(nX + " " + nY);
//	}
//	
//	sc.close();
// }

//https://www.algospot.com/judge/problem/read/HELLOWORLD
//
// public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int nTime = sc.nextInt();
//	sc.nextLine();
//	String name = "";
//	
//	while(nTime-- > 0){
//		name = sc.nextLine();
//		System.out.println("Hello, " + name + "!");
//	}
//	
//	sc.close();
// }
 
//https://www.algospot.com/judge/problem/read/MERCY
// public static void main(String[] args) {
//	Scanner sc = new Scanner(System.in);
//	int nTime = sc.nextInt();
//	sc.nextLine();
//	
//	while(nTime-- > 0){
//		System.out.println("Hello Algospot!");
//	}
//	
//	sc.close();
// }