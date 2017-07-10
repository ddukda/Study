package jino.study;

public class GetMember {
	
	
	public static void main(String args[]){
		SMember sMember = new SMember();
		sMember.A = 10;
		sMember.B = 5;
		
		if(sMember.A > sMember.B){
			sMember.A = 30;
			sMember.B = 30;
		}
		else {
			sMember.A = 10;
			sMember.B = 10;
		}
		
		
		System.out.println("sMember.A > " + sMember.A);
		System.out.println("sMember.B > " + sMember.B);
		
		
	}
}
 