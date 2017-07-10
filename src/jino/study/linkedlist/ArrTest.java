package jino.study.linkedlist;

public class ArrTest {
	public static void main(String[] args){
		String szPhoneRate 	= null;
		String szYoungFeeYN = "N";
    	String szFeeType = "N";
    	
    	if (szYoungFeeYN.equals("Y")) {
    		String szRst1 =  szFeeType;
    		String szRst2 =  szYoungFeeYN;
    		System.out.println("if1");
    	} else if ( szPhoneRate.equals("P") || szPhoneRate.equals("C") ){
    		String szRst0 =  Integer.toString(15);
    		System.out.println("if2");
    	} 
		
		
	}
	
}
