package com.study.headfirst.extend;

public abstract class Animal {
	public String picture;
	public String food;
	public int hunger;
	public String boundaries;
	public String location;
	
	private String name;

	
	
	public String getName(){
		return name;
	}

	public Animal(){
		System.out.println("this is Animal abstract class.");		
	}
	
	public Animal(String name){
		this();
		this.name = name;
	}
	
	public void makeNoise(){

	}
	
	public void eat(){
		
	}
	
	public void sleep(){
		
	}
	
	public void roam(){
		
	}
}
