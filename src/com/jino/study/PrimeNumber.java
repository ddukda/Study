package com.jino.study;

public class PrimeNumber {

	public static void main(String args[]){
		
		int n = 1000; // 판별 할 수
		boolean[] bPrimeNumber = new boolean[n+1];
		int i; 		  // 판별 된 수
		
		for(i=0; i<=n; i++){
			
			if(i == 0 || i == 1){
				bPrimeNumber[i] = true;
				continue;
			}
			
			if(bPrimeNumber[i] == false){
				
			}
			
			
			
			
			
			
			System.out.println(i);
		}
	}
	
	
}
