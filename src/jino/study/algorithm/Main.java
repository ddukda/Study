package jino.study.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String szInput;
		String[] szArrInput;
		String szA, szB;
		int A,B;
		long cnt=0;
		
		szInput = sc.nextLine();
		szArrInput = szInput.split(" ");
		
		szA = szArrInput[0];
		szB = szArrInput[1];
		
		A = Integer.parseInt(szA);
		B = Integer.parseInt(szB);
		
		while(true){
			if( (A % 3) == 0 ) cnt++;
			else if ( szA.indexOf("3") > -1 ) cnt++;
			A++;
			if(A==B) break;
		}
		
		System.out.println(""  + (cnt % 20150523));
		
		sc.close();
	}

}

