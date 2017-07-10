package com.study.baseball;

import java.util.Scanner;

public class Baseball {
	
	private Scanner scan = new Scanner(System.in);
	
	// �迭�� ����
	private int[] num = new int[10];
	
	private int[] input = new int[5];
	
	private String inputValue;
	private int nInputValue;
		
	public void BaseBallRun() {
		// �߱� ���� ����
		// ���� 3 ���� �������� �޴´�.
		// �ߺ��� �ȵ�.
		System.out.println("�߱� ���� ����");
		
		boolean status = true;
		
		while(status){
			System.out.print("���ڸ� �������� �ұ��(���� 3,4,5 �� �Է�) : ");
			inputValue = scan.next();
			
			if(!isNumCheck(inputValue)){
				System.out.println("���ڸ� �Է� �ϼ���.");
				continue;
			}
			
			nInputValue = Integer.parseInt(inputValue); 
			
			if(nInputValue > 5 || nInputValue < 3){
				System.out.println("���ڸ� �� �� �Է� �ϼ̽��ϴ�.");
				status = true;
			}else{
				status = false;
			}
		}
		
		System.out.println(inputValue + "�ڸ��� ���� ����.");
		
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
		// �߱� ���� ����
		// ����ڰ� ���� 3���� �Է� �ϰ�,(0~9)
		// �� �� ���� ����� �޴´�.
		System.out.println("�߱� ���� ��");
		int count = 1;
		int failCount = 0;
		while(true){
			System.out.print(count + "ȸ. ���� �Է� " + nInputValue + "�ڸ� : ");
			inputValue = scan.next();
			
			if( inputValue.length() != nInputValue){
				System.out.println("���� �Է��� "+nInputValue+"�ڸ��� �ϼž� �մϴ�!");
				continue;
			}
			
			if(!isNumCheck(inputValue)){
				System.out.println("���ڸ� �Է� �ϼ���.");
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
				System.out.println("  -- ���� ���ڸ� �ѹ� �̻� �Է��Ͻø� �ȵ˴ϴ�.");
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
				System.out.print(" >> ����! : ");
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
		// �߱� ���� ����
		// ����ڿ��� �ٽ� �������� ���ų�, ���� �Ѵ�.
		System.out.println("�߱� ���� ����");
	}
}
