package jino.study.A20130626;

public class Test {
	public String listTest(){
		return "check test...";
		
		
		
	}
	
	
	public static void main(String[] args){
		String test = "야:임마:몰라";
		
		String[] arrTest = test.split(":");
		
			
		for(int i=0; arrTest.length < i; i++)
			System.out.println(arrTest[i]);
	}
}
