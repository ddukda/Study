package jino.study.S2014;

public class ConstructorStudy {

	private String szMyName = "양진호";
	
	
	public ConstructorStudy() {
		this.szMyName = "심재혁";
	}
	
	public ConstructorStudy(String szParam1) {
		this.szMyName = szParam1;
		System.out.println(getMyName());
	}

	
	public String getMyName() {
		return this.szMyName;
	}
}

