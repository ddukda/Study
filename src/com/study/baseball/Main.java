package com.study.baseball;

import java.util.Scanner;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		
		Baseball baseball = new Baseball();
		Scanner scan = new Scanner(System.in);
		String inputValue = "Y";
		
		while(!inputValue.toUpperCase().equals("N")){
			
			baseball.BaseBallRun();
			
			// 야구 게임 중
			baseball.BaseBallProc();
			
			// 야구 게임 종료
			baseball.BaseBallEnd();
			
			System.out.print("그만 하려면 'n' or 'N' : ");
			inputValue = scan.next();
		}
		
		System.out.print("수고하셨습니다.");
	}


}
