package com.study.headfirst.thread;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionSort {

	
	// 알파벳 정렬 ArrayList
	public static void main(String args[]){
		
		ArrayList<String> list = new ArrayList<String> ();
		
		
		list.add("qab");
		list.add("abc");
		list.add("cfz");
		list.add("cfa");
		list.add("qqq");
		list.add("ccc");
		list.add("fff");
		list.add("zzz");
		list.add("bbb");
		list.add("ddd");
		list.add("aaa");
		
		for(String arrayListPrint : list){
			System.out.println("iist print : " + arrayListPrint);
		}
		
		Collections.sort(list);
		
		for(String arrayListPrint : list){
			System.out.println("iist sort print : " + arrayListPrint);
		}
		
		int x = 10;
		System.out.println("" + ~x + "^" + x);
		
	}
}
