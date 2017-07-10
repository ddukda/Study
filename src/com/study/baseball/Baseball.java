package com.study.baseball;

import java.util.Scanner;

public class Baseball {
	
	private Scanner scan = new Scanner(System.in);
	
	// 배열로 변경
	private int[] num = new int[10];
	
	private int[] input = new int[5];
	
	private String inputValue;
	private int nInputValue;
		
	public void BaseBallRun() {
		// 야구 게임 시작
		// 숫자 3 개를 랜덤으로 받는다.
		// 중복은 안됨.
		System.out.println("야구 게임 시작");
		
		boolean status = true;
		
		while(status){
			System.out.print("몇자리 게임으로 할까요(숫자 3,4,5 중 입력) : ");
			inputValue = scan.next();
			
			if(!isNumCheck(inputValue)){
				System.out.println("숫자만 입력 하세요.");
				continue;
			}
			
			nInputValue = Integer.parseInt(inputValue); 
			
			if(nInputValue > 5 || nInputValue < 3){
				System.out.println("숫자를 잘 못 입력 하셨습니다.");
				status = true;
			}else{
				status = false;
			}
		}
		
		System.out.println(inputValue + "자리로 게임 시작.");
		
		for(int j=0; j<10; j++){
			num[j] = j;
		}
		
		int nSelect = 0;
		int nTemp = 0;
		
		for(int i=0; i<100; i++){
			nSelect = (int)(Math.random()*10 - 1);
			nTemp = num[0];
			num[0] = num[nSelect];
			num[nSelect] = nTemp;
		}
		
	}
	

	public void BaseBallProc() {
		// 야구 게임 진행
		// 사용자가 숫자 3개를 입력 하고,(0~9)
		// 그 에 따른 결과를 받는다.
		System.out.println("야구 게임 중");
		int count = 1;
		int failCount = 0;
		while(true){
			System.out.print(count + "회. 숫자 입력 " + nInputValue + "자리 : ");
			inputValue = scan.next();
			
			if( inputValue.length() != nInputValue){
				System.out.println("숫자 입력은 "+nInputValue+"자리를 하셔야 합니다!");
				continue;
			}
			
			if(!isNumCheck(inputValue)){
				System.out.println("숫자만 입력 하세요.");
				continue;
			}
			
			for(int i=0; i<nInputValue; i++){
				input[i] = Integer.parseInt(inputValue.substring(i,i+1));
			}
			
			for(int i=0; i<nInputValue; i++){
				for(int j=0; j<nInputValue; j++){
					if( input[i] == input[j]){
						failCount++;
						break;
					}
				}
			}
			if( failCount > 0){
				System.out.println("  -- 같은 숫자를 한번 이상 입력하시면 안됩니다.");
				continue;
			}
			
			
			int strikeCount = 0;
			int ballcount = 0;
			
			for(int i=0; i<nInputValue; i++){
				for(int j=0; j<nInputValue; j++){
					if(i == j){
						if(input[i] == num[j]){
							strikeCount++;
						}
					}
					
					if(i != j){
						if(input[i] == num[j]){
							ballcount++;
						}
					}
				}
			}
			
			if(strikeCount == 0 && ballcount ==0){
				System.out.println(" >> out");
			}
			
			System.out.println("strike : " + strikeCount + ", ball : " + ballcount);
			
			if(strikeCount == nInputValue){
				System.out.print(" >> 정답! : ");
				for(int i=0; i<nInputValue; i++){
					System.out.print(num[i]+ "  ");
				}
				break;
			}
			
			count++;	
		}
		
	}

	
	
	private boolean isNumCheck(String chk) {
		try{
			Double.parseDouble(chk); 
			return true;
		}catch(NumberFormatException e){
			return false;
		}
	}


	public void BaseBallEnd() {
		// 야구 게임 종료
		// 사용자에게 다시 시작할지 묻거나, 종료 한다.
		System.out.println("야구 게임 종료");
	}
}
