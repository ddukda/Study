package com.test;

import java.net.URLEncoder;

public class abc {

	public static void main(String[] args) {
	
		try{
			System.out.println(URLEncoder.encode("양진호", "utf-8").replace("%C2%A0","%20"));
		}catch ( Exception e){
			System.out.println(e.toString());
		}
	}

}
