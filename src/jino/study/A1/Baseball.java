package jino.study.A1;

import java.util.Scanner;

public class Baseball {
	
	private Scanner scan = new Scanner(System.in);
	
	// 배열로 변경
	private int[] num = new int[3];
	
	private int[] input = new int[3];
	
	private String inputValue;
	
//	Baseball(int num1, int num2, int num3){
//		this.num1 = num1;
//		this.num2 = num2;
//		this.num3 = num3;
//	}
	
	public void BaseBallRun() {
		// 야구 게임 시작
		// 숫자 3 개를 랜덤으로 받는다.
		// 중복은 안됨.
		System.out.println("야구 게임 시작");
		System.out.println("숫자 3개 랜덤으로 저장(0~9)");
		
		num[0] = (int)(Math.random()*10 - 1);
		num[1] = (int)(Math.random()*10 - 1);
		num[2] = (int)(Math.random()*10 - 1);
		
		while(num[1] == num[0]){
			num[1] = (int)(Math.random()*10 - 1);
		}
		
		while((num[2] == num[0]) || (num[2] == num[1])){
			num[2] = (int)(Math.random()*10 - 1);
		}
		
		System.out.println(num[0] + " " + num[1] + " " + num[2]);
	}
	

	public void BaseBallProc() {
		// 야구 게임 진행
		// 사용자가 숫자 3개를 입력 하고,(0~9)
		// 그 에 따른 결과를 받는다.
		System.out.println("야구 게임 중");
		int count = 1;
		while(true){
			System.out.print(count + ". 숫자 입력 3자리 : ");
			inputValue = scan.next();
			
			
			// 3자리를 입력 받아야 함
			
			if( inputValue.length() != 3){
				System.out.println("숫자 입력은 3자리로 부탁!");
				continue;
			}
			
			// 첫번째 숫자
			input[0] = Integer.parseInt(inputValue.substring(0,1));
			// 두번째 숫자
			input[1] = Integer.parseInt(inputValue.substring(1,2));
			// 세번째 숫자
			input[2] = Integer.parseInt(inputValue.substring(2,3));
			
			System.out.println("    input value : " + input[0] + " " + input[1] + " " + input[2]);
			
			int strikeCount = 0;
			int ballcount = 0;
			
			for(int i=0; i<3; i++){
				for(int j=0; j<3; j++){
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
			
			if(strikeCount == 3){
				System.out.println(" >> 종료");
				break;
			}
			
			count++;	
		}
		
	}

	
	
	public void BaseBallEnd() {
		// 야구 게임 종료
		// 사용자에게 다시 시작할지 묻거나, 종료 한다.
		System.out.println("야구 게임 종료");
	}
}
