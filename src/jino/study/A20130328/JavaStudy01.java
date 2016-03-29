package jino.study.A20130328;

public class JavaStudy01 {
	
	public static void main(String[] args){
		
		startCase1();
		startCase2();
//		startCase3();
		
	}

	private static void startCase1() {
		// startCase1
		System.out.println("\nstartCase1..");
		for(int i=0; i<10; i++){
			for(int j=0; j<=i; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
		
	}

	private static void startCase2() {
		// startCase2
		System.out.println("\nstartCase2..");
		for(int i=0; i<10; i++){
			for(int j=0; j<10-i; j++){
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
