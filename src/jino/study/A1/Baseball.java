package jino.study.A1;

import java.util.Scanner;

public class Baseball {
	
	private Scanner scan = new Scanner(System.in);
	
	// �迭�� ����
	private int[] num = new int[3];
	
	private int[] input = new int[3];
	
	private String inputValue;
	
//	Baseball(int num1, int num2, int num3){
//		this.num1 = num1;
//		this.num2 = num2;
//		this.num3 = num3;
//	}
	
	public void BaseBallRun() {
		// �߱� ���� ����
		// ���� 3 ���� �������� �޴´�.
		// �ߺ��� �ȵ�.
		System.out.println("�߱� ���� ����");
		System.out.println("���� 3�� �������� ����(0~9)");
		
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
		// �߱� ���� ����
		// ����ڰ� ���� 3���� �Է� �ϰ�,(0~9)
		// �� �� ���� ����� �޴´�.
		System.out.println("�߱� ���� ��");
		int count = 1;
		while(true){
			System.out.print(count + ". ���� �Է� 3�ڸ� : ");
			inputValue = scan.next();
			
			
			// 3�ڸ��� �Է� �޾ƾ� ��
			
			if( inputValue.length() != 3){
				System.out.println("���� �Է��� 3�ڸ��� ��Ź!");
				continue;
			}
			
			// ù��° ����
			input[0] = Integer.parseInt(inputValue.substring(0,1));
			// �ι�° ����
			input[1] = Integer.parseInt(inputValue.substring(1,2));
			// ����° ����
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
				System.out.println(" >> ����");
				break;
			}
			
			count++;	
		}
		
	}

	
	
	public void BaseBallEnd() {
		// �߱� ���� ����
		// ����ڿ��� �ٽ� �������� ���ų�, ���� �Ѵ�.
		System.out.println("�߱� ���� ����");
	}
}
