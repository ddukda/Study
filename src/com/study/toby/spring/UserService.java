package com.study.toby.spring;

public interface UserService {

	public void set(String name, String number);
	public void set(String name, String number, String plus);
	public String getName();
	public String getNumber();
	
}
