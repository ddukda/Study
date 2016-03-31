package jino.study.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class sUB {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		String szInput;
//		String[] szArrInput;
//		String szA, szB;
//		int A,B;
//		long cnt=0;
//		
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		
//		szA = szArrInput[0];
//		szB = szArrInput[1];
//		
//		A = Integer.parseInt(szA);
//		B = Integer.parseInt(szB);
//		
//		while(true){
//			if( (A % 3) == 0 ) cnt++;
//			else if ( szA.indexOf("3") > -1 ) cnt++;
//			A++;
//			if(A==B) break;
//		}
//		
//		System.out.println(""  + (cnt % 20150523));
//		
//		sc.close();
	}
}
	

//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		String szInput;
//		String[] szArrInput;
//		int N,K;
//		long totalNum, M=0;
//		
//		
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		
//		N = Integer.parseInt(szArrInput[0]);
//		K = Integer.parseInt(szArrInput[1]);
//		
//		totalNum = K;
//		M = K;
//		for(int i=1; i<N; i++){
//			totalNum *= K; 
//		}
//		
//		for(int i=1; i<N-5; i++){
//			M *= K; 
//		}
//		M *= (N-5+1);
//		M *= 2;
//		
//		System.out.println(totalNum);
//		
//		System.out.println(M);
//		
//		System.out.println((totalNum - M) % 1000000009);
//		
//		sc.close();
//	}
//
//	
//	
//}

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String szInput, szAns = "0";
//		String[] szArrInput;
//		int nX1=0, nX2=0, nY1=0, nY2=0;
//		int nNum = 0;
//		int[] nAns;
//		int nXSize = 1001;
//		int nYSize = 1001;
//		int[][] nRec = new int[nXSize][nYSize];
//		
//		for(int i=0; i<nXSize; i++){
//			for(int j=0; j<nYSize; j++){
//				nRec[i][j] = -1;
//			}
//		}
//		
//		
//		szInput = sc.nextLine();
//		nNum = Integer.parseInt(szInput);
//		nAns = new int[nNum];
//		for(int i=0; i<nNum; i++){
//			
//			szInput = sc.nextLine();
//			szArrInput = szInput.split(" ");
//			
//			nX1 = Integer.parseInt( szArrInput[0] );
//			nY1 = Integer.parseInt( szArrInput[1] );
//			nX2 = nX1 + Integer.parseInt( szArrInput[2] );
//			nY2 = nY1 + Integer.parseInt( szArrInput[3] );
//			
//			
//			for(int j=0; j<nX2-nX1; j++){
//				for(int k=0; k<nY2-nY1; k++){
//					nRec[nY1+k][nX1+j] = i;
//				}
//			}
//		}
//		
//		for(int i=0; i<nXSize; i++){
//			for(int j=0; j<nYSize; j++){
//				if(nRec[i][j] != -1) nAns[nRec[i][j]]++;	
//			}
//			
//		}
//		
//		
//		for(int i=0; i<nNum; i++){
//			System.out.println("" + (nAns[i]));	
//		}
//		
//		
//		sc.close();
//	}
//
//	
//	
//}

//public class Main {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String szInput, szDir = "", szAns = "0";
//		String[] szArrInput;
//		int nX, nThisX = 0, nBaseX = 1;
//		int nY, nThisY = 0, nBaseY = 1;
//		int nNum = 0;
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		
//		nX = Integer.parseInt(szArrInput[0]);
//		nY = Integer.parseInt(szArrInput[1]);
//		
//		szInput = sc.nextLine();
//		nNum = Integer.parseInt(szInput);
//		
//		nThisX = 1; nThisY = 1;
//		
//		if(nNum > nX*nY){
//			szAns = "0";
//		}
//		else{
//			for(int i=1; i<=nNum; i++){				
//				if(nThisX == nBaseX && nThisY != nY) szDir = "u";
//				else if(nThisX == nBaseX && nThisY == nY) szDir = "r";
//				else if(nThisX == nX && nThisY == nY) szDir = "d";
//				else if(nThisX == nX && nThisY == nBaseY) {szDir = "l"; nY--; nX--;nBaseX++;nBaseY++;}
//
//				if(szDir.equals("u")) {if(i!=1)nThisY++;}
//				else if(szDir.equals("r")) nThisX++;
//				else if(szDir.equals("d")) nThisY--;
//				else if(szDir.equals("l")) nThisX--;
//				
////				System.out.println(nThisX + " " + nThisY + ", " + nX + " " + nY + ", " + nBaseX + " " + nBaseY + " // " + i + " // " + szDir);
//			}
//			
//			szAns = nThisX + " " + nThisY;
//		}
//		
//		System.out.println(szAns);
//		sc.close();
//	}
//
//	
//	
//}

//public class Main {
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String szInput;
//		String[] szArrInput;
//		int nInputX = 0;
//		int nInputY = 0;
//		String[][] szArrGridZero = {}, szArrGridOne = {};
//		int nAnsZero = 0, nAnsOne = 0;;
//	
//		
//		szInput = sc.nextLine();
//		szArrInput = szInput.split(" ");
//		
//		nInputY = Integer.parseInt(szArrInput[0]);
//		nInputX = Integer.parseInt(szArrInput[1]);
//		
//		szArrGridZero = new String[nInputY][nInputX];
//		szArrGridOne = new String[nInputY][nInputX];
//		
//		for(int i=0; i<nInputY; i++){
//			szInput = sc.nextLine();
//			szArrInput = szInput.split(" ");
//			
//			for(int j=0; j<nInputX; j++){
//				szArrGridZero[i][j] = szArrInput[j];
//				szArrGridOne[i][j] = szArrInput[j];
//			}
//			
//		}
//		System.out.println("");
//		for(int i=0; i<nInputY; i++){
//			for(int j=0; j<nInputX; j++){
//				System.out.print(szArrGridZero[i][j] + " ");
//			}
//			System.out.println("");
//		}
//		System.out.println("000000000000000000000");
//		
//		for(int i=0; i<nInputY; i++){
//			for(int j=0; j<nInputX; j++){
//				if(szArrGridZero[i][j].equals("0")){
//					changeZero(i,j,nInputX,nInputY,szArrGridZero);
//					System.out.println("");
//					for(int k=0; k<nInputY; k++){
//						for(int l=0; l<nInputX; l++){
//							System.out.print(szArrGridZero[k][l] + " ");
//						}
//						System.out.println("");
//					}
//					System.out.println("");
//					nAnsZero++;
//				}
//			}
//		}
//		
//		System.out.println("1111111111111111111111111");
//		for(int i=0; i<nInputY; i++){
//			for(int j=0; j<nInputX; j++){
//				System.out.print(szArrGridOne[i][j] + " ");
//			}
//			System.out.println("");
//		}
//		System.out.println("");
//		
//		for(int i=0; i<nInputY; i++){
//			for(int j=0; j<nInputX; j++){
//				if(szArrGridOne[i][j].equals("1")){
//					changeOne(i,j,nInputX,nInputY,szArrGridOne);
//					System.out.println("");
//					for(int k=0; k<nInputY; k++){
//						for(int l=0; l<nInputX; l++){
//							System.out.print(szArrGridOne[k][l] + " ");
//						}
//						System.out.println("");
//					}
//					System.out.println("");
//					nAnsOne++;
//				}
//			}
//		}
//		
//		
//			
//		System.out.println(nAnsZero + "");
//		System.out.println(nAnsOne + "");
//		System.out.println(nAnsZero>nAnsOne?nAnsOne+"":nAnsZero+"");
//		sc.close();
//	}
//
//	private static void changeZero(int i, int j, int nInputX, int nInputY, String[][] szArrGrid) {
//		szArrGrid[i][j] = "1";
//		
//		if(i != 0){
//			if(szArrGrid[i-1][j].equals("0")){
//				changeZero(i-1,j,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(j != 0){
//			if(szArrGrid[i][j-1].equals("0")){
//				changeZero(i,j-1,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(i < nInputY-1){
//			if(szArrGrid[i+1][j].equals("0")){
//				changeZero(i+1,j,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(j < nInputX-1){
//			if(szArrGrid[i][j+1].equals("0")){
//				changeZero(i,j+1,nInputX,nInputY,szArrGrid);
//			}
//		}
//	}
//	
//	private static void changeOne(int i, int j, int nInputX, int nInputY, String[][] szArrGrid) {
//		szArrGrid[i][j] = "0";
//		
//		if(i != 0){
//			if(szArrGrid[i-1][j].equals("1")){
//				changeOne(i-1,j,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(j != 0){
//			if(szArrGrid[i][j-1].equals("1")){
//				changeOne(i,j-1,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(i < nInputY-1){
//			if(szArrGrid[i+1][j].equals("1")){
//				changeOne(i+1,j,nInputX,nInputY,szArrGrid);
//			}
//		}
//		
//		if(j < nInputX-1){
//			if(szArrGrid[i][j+1].equals("1")){
//				changeOne(i,j+1,nInputX,nInputY,szArrGrid);
//			}
//		}
//	}
//	
//}


//
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a,b, ans;
//		String c[],d[];
//		a = sc.nextLine();
//		b = sc.nextLine();
//		c = a.split(" ");
//		d = b.split(" ");
//		
//		int p1=0, p2=0, draw=0, p1num=0, p2num=0;
//		
//		for(int i=0; i<10; i++){
//			p1num = Integer.parseInt(c[i]);
//			p2num = Integer.parseInt(d[i]);
//			if(p1num>p2num) p1++;
//			else if(p2num>p1num) p2++;
//			else draw++;
//		}
//		
//		if(p1>p2) ans="A";
//		else if(p2>p1) ans="B";
//		else ans="D";
//			
//		
//		System.out.println(ans);
//		sc.close();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a,b;
//		String c[],d[];
//		a = sc.nextLine();
//		b = sc.nextLine();
//		c = a.split(" ");
//		d = b.split(" ");
//
//		int cnt = 0;
//		for(int i=0; i<5; i++){
//			if(c[0].equals(d[i])) cnt++;
//		}
//		
//		System.out.println(cnt);
//		sc.close();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a;
//		String c[];
//		a = sc.nextLine();
//		c = a.split(" ");
//		
//		int input1 = Integer.parseInt(c[0]);
//		int input2 = Integer.parseInt(c[1]);
//		int n = 1;
//		for(int i=0; i<input2; i++) n = n * 10;
//		
//		int g = input1/n;
//		int h = input1%n;
//		
//		if(h>=(n/2)) g++;
//		System.out.println(g*n);
//		sc.close();
//	}
//}


//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a;
//		String c[];
//		a = sc.nextLine();
//		c = a.split(" ");
//		System.out.println(
//				((Integer.parseInt(c[0])-1)*Integer.parseInt(c[1])+1)
//				+"");
//		sc.close();
//	}
//}



//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String a;
//		String c[];
//		a = sc.nextLine();
//		c = a.split(" ");
//		int x=1,n = (int)((2.5*Float.parseFloat(c[0])+2.0*Float.parseFloat(c[1])+0.5*Float.parseFloat(c[2]))*2);
//		if(n%10 == 0) x = 0;
//		System.out.println(
//				( ( n/10)+x)*10
//				+ " amperes");
//		sc.close();
//	}
//}

//public static void main(String[] args) {
//Scanner sc = new Scanner(System.in);
//String a, b = "";
//String c[] = {};
//a = sc.nextLine();
//b = sc.nextLine();
//c = a.split(" ");
//int d = Integer.parseInt(b);
//int e = Integer.parseInt(c[0]);
//int f = Integer.parseInt(c[1]);
//int g = Integer.parseInt(c[2]);
//int k =( g + (d%60) );
//int h = k % 60;
//int i = ( f + (d/60) + k/60 ) % 60;
//int j = (e + ( f + + (d/60) + ( k )/60 ) / 60) % 24;
//System.out.println(j + " " + i + " " + h);
//sc.close();
//}


//public static void main(String[] args) {
//
//Scanner sc = new Scanner(System.in);
//String c[] = new String[5];
//int nArrInputLength[] = new int[5];
//
//String szOutPut = "";
//
//try{
//
//	for(int i=0; i<5; i++){
//		c[i] = sc.nextLine();
//		nArrInputLength[i] = c[i].length();
//	}
//
//	for(int i=0; i<15; i++){
//		
//		for(int j=0; j<5; j++){
//			if(nArrInputLength[j] > i){
//				szOutPut += c[j].charAt(i);
//			}	
//		}
//	}
//	
//	System.out.println(szOutPut);
//	
//}catch(Exception e){
//	System.out.println("EXCEPTION : " + e.toString());
//}finally{
//	sc.close();
//}
//
//
//}
