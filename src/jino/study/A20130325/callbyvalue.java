package jino.study.A20130325;

public class callbyvalue {
	
	public static void main(String[] args){
		int a = 1;
		int b = 3;
		
		swap(a, b);
		if (a == 3 && b == 1){
			System.out.println("swap Success");
			System.out.println("a : " + a + "  b: " + b);
		}else{
			System.out.println("swap Fail");
			System.out.println("a : " + a + "  b: " + b);
		}
	}
	
	public static void swap(int a, int b){
		int temp;
		temp = a;
		a = b;
		b = temp;
	}
	
		
}
