package com.study.headfirst.extend;

public class Hippo extends Feline implements Pet, Bird{

	public Hippo(String name) {
		super(name);
	}

	public void makeNoise(){
		
	}
	
	public void eat(){
		
	}
	
	public void hippo(){
		
	}

	
	//--- interface implement
	// Pet
	@Override
	public void friendly() {
		
	}

	// Pet
	@Override
	public void bark() {
		
	}

	// Bird
	@Override
	public void fly() {
		
	}
}
