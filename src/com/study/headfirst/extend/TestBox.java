package com.study.headfirst.extend;

import java.util.Calendar;
import java.util.Date;

public class TestBox {

	Integer i;
	int j;
	
	public static void main(String args[]){
//		TestBox t = new TestBox();
//		t.go();
		
		int nPrice = 1500;
		
		String szPrice = String.format("가격 : %,d", nPrice);
		System.out.println(szPrice);
		String szDate = String.format("%tr", new Date());
		System.out.println(szDate);
		System.out.println(String.format("%tB %<td일 %<tA %<tr", new Date()));
		
		
		Calendar cal = Calendar.getInstance();
		
	}
	
	public void go(){
		try{
//			j = i;
			System.out.println(i);
			System.out.println(j);
		} catch (Exception e){
			System.out.println(e);
		}
	}
}
