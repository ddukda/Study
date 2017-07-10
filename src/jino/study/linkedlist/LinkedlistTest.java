package jino.study.linkedlist;

import java.util.LinkedList;

public class LinkedlistTest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		LinkedList<String> a = new LinkedList<String>();
		LinkedList<String> b = new LinkedList<String>();
		String[] alphabet = {"A","B","C","D","E"};
		
		for (String s : alphabet){
			a.add(s);
			System.out.println(a);
		}
		
		System.out.println("==============================");
		
		for (String s : alphabet){
			a.add(s);
			System.out.println(a);
			a.poll();
			System.out.println(a.peek());
		}
		
		System.out.println("==============================");
		
		System.out.println(a);
		b = (LinkedList<String>)a.clone();
		System.out.println(b);
		
	}
	
}
