package jino.study.S2014;

public class ConstructorTest1 {

	public static void main(String[] args) {

		String Name = null;

		try {
			if (Name.equals("양진호"))
				System.out.println("if 될리가 없음 exception 임");
		} catch (Exception e) {
			System.out.println("당연히 exception 임");
		}

		System.out.println("근데 뒤에 나옴?");

	}

}
