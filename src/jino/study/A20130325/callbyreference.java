package jino.study.A20130325;

public class callbyreference {
	int value;
	
	callbyreference(int _value){
		this.value = _value;
	}	
	
	public static void main(String[] args){
		callbyreference a = new callbyreference(1);
		callbyreference b = new callbyreference(3);
				
		swap(a, b);
		
		if (a.value == 3 && b.value == 1){
			System.out.println("swap Success");
			System.out.println("a.value : " + a.value + "  b.value : " + b.value);
		}else{
			System.out.println("swap Fail");
			System.out.println("a.value : " + a.value + "  b.value : " + b.value);
		}
	}
	
	public static void swap(callbyreference a, callbyreference b){
		int temp;
		temp = a.value;
		a.value = b.value;
		b.value = temp;
	}
	
		
}
