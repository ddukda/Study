package jino.study.enumeration;

public class EnumTest01 {
    public static void main(String[] args) {
        for(Type type : Type.values()){
            System.out.println(type.getName());
        }
    }
}

enum Type{
	// 상수("연결할 문자")
    WALKING("워킹화"), RUNNING("러닝화"), TRACKING("트래킹화"), HIKING("등산화");
     
    final private String name;
     
    private Type(String name) { //enum에서 생성자 같은 역할
        this.name = name;
    }
    public String getName() { // 문자를 받아오는 함수
        return name;
    }
}




