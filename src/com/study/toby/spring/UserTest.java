package com.study.toby.spring;

public class UserTest {

	public static void main(String[] args) {

		String name = "양진호";
		String number = "1";

		UserServiceImpl us = new UserServiceImpl(); // Interface Impl Class

		us.set(name, number);
		System.out.println(us.getName() + " " + us.getNumber());

		UserService usi1 = new UserServiceImpl(); // Interface Direct call

		usi1.set("1", "2");
		System.out.println(usi1.getName());

		UserService usi2 = new UserServiceTx();
		usi2.set("1", "2", "3");
		// System.out.println(usi2.getPlus(); // >> error

		UserServiceTx usi3 = new UserServiceTx();
		usi3.set("1", "2", "3");
		System.out.println(usi3.getPlus());

		// UserServiceImpl 에는 getPlus 가 없고, UserServiceTx 에는 getPlus가 있음
		// usi1 은 UserServiceImpl 을 담고
		// usi2 은 UserServiceTx 를 담음
		// UserServiceTx 에는 getPlus 메소드가 있지만, UserService interface 에는 getPlus가 없으므로 호출은 안됨(선언은 되는데)

	}
}
