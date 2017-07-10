package com.test;

public class Syudy02 {
	public static void main(String args[]){
		
		Object ob = "a";
		Object ob1 = 1;
		Object ob2 = 2;
		Object ob3 = 0;
		ob1 = 4;
		ob1 = 5;
		ob3 = Integer.parseInt(ob1.toString()) + Integer.parseInt(ob2.toString());
		
		
		System.out.println(ob3);
		
		
	}
}
