package jino.study;

public class ExtendsStudy {
	public static void main(String[] args){
		Parent p1 = new Parent();
		Parent p = new Child();
		Child c = new Child();
		
		System.out.println("p.x     : " + p.x);

		p1.method();
		System.out.println();
		p.method();
		
		System.out.println();
		
		System.out.println("c.x     : " + c.x);
		c.method();
		System.out.println("c.A     : " + c.A);
		
	}
}


class Parent{
	int x = 100;
	int A = 450;
	void method(){
		System.out.println("Parent method");
	}
}

class Child extends Parent{
//class Child{
	int x = 200;
	int y = 1;
	void method(){
		System.out.println("x       : " + x);
		System.out.println("super.x : " + super.x);
		System.out.println("this.x  : " + this.x);
		
	}
}
/*
p.x : 200
x : 200
super.x : 100
this.x : 200

p.x : 200
x : 200
super.x : 100
this.x : 200
*/