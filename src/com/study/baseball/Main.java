package com.study.baseball;

import java.util.Scanner;

public class Main {
	
	
	
	
	public static void main(String[] args) {
		
		Baseball baseball = new Baseball();
		Scanner scan = new Scanner(System.in);
		String inputValue = "Y";
		
		while(!inputValue.toUpperCase().equals("N")){
			
			baseball.BaseBallRun();
			
			// �߱� ���� ��
			baseball.BaseBallProc();
			
			// �߱� ���� ����
			baseball.BaseBallEnd();
			
			System.out.print("�׸� �Ϸ��� 'n' or 'N' : ");
			inputValue = scan.next();
		}
		
		System.out.print("�����ϼ̽��ϴ�.");
	}


}
