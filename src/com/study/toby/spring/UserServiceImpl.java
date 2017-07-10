package com.study.toby.spring;

public class UserServiceImpl implements UserService{
	
	private String name;
	private String number;
	private String plus;
	
	public void set(String name, String number){
		this.name = name;
		this.number = number;
	}
	
	public void set(String name, String number, String plus){
		this.name = name;
		this.number = number;
		this.plus = plus;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getNumber(){
		return this.number;
	}

}
