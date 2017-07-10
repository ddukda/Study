package com.study.headfirst.extend;

public class Test {
	// City 열거형 객체 선언
    public enum City { Seoul, Busan, Daegu, Gwangju, Daejun }
    
    
    public Test(String a){
    	
    }
    
    public Test(String a, String b){
    	
    }
    // Season 열겨형 객체 선언
    public enum Season{
        
        spring("March through May"),
        summer("June through August"),
        fall("September through November"),
        winter("December through February");
    
        private String span;
        
        // 열거 값에 (String) 값 span 에 대입
        Season(String months){
            span = months;
        }
        
        // span 값 반환
        public String getSpan(){
            return span;
        }
    }
    
    public enum ErrCode{
    	
    	CP_SUCCESS("0000"),
    	NOT_EXIST("1000");
    	
    	private String ErrCode;
    	
    	ErrCode(String err){
    		ErrCode = err;
    	}
    	
    	public String getErrCode(){
    		return ErrCode;
    	}
    	
    }
    
    
    public static void main(String[] args){
    	Wolf wolf = new Wolf("with");
    	ErrCode err = ErrCode.CP_SUCCESS;
    	String szRst = err.getErrCode();
    	
    	if(szRst.equals(ErrCode.CP_SUCCESS.getErrCode())){
    		
    		err = ErrCode.NOT_EXIST;
    		szRst = err.getErrCode();
    	}
    	
        System.out.println(err + " " + szRst + " " + wolf.boundaries);
        
        
        
    }
    
//	public static void main(String[] args){
//		Wolf wolf = new Wolf();
//		
//		wolf.eat();
//		wolf.makeNoise();
//		wolf.roam();
//		wolf.sleep();
//		
//		
//		
//		Hippo hippo = new Hippo();
//		
//		Animal anim = new Animal();
//		
//		Animal animHippo = new Hippo();
//		
//		animHippo.hippo();
//		
//	}
	
	
//	public String toString(){
//		return "";
//	}
	
//	Object
	
}
