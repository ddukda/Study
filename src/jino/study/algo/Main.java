package jino.study.algo;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String szInput, szAns = "";
		String[] szArrInput;
		
		szInput = sc.nextLine();
		int N = Integer.parseInt(szInput), temp = 0;
		
		szInput = sc.nextLine();
		szArrInput = szInput.split(" ");
		
		int[] nArrInput = new int[N];
		
		szArrInput = null;
						
		for(int i=0; i<N; i++){
			nArrInput[i] = Integer.parseInt(szArrInput[i]);
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N-1; j++){
				if(nArrInput[j] > nArrInput[j+1]){
					temp = nArrInput[j];
					nArrInput[j] = nArrInput[j+1];
					nArrInput[j+1] = temp;
				}
			}
		}
		
		
		
	}
}
