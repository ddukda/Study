package jino.tip.patchlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLEncoder;

public class patchSplit {

	public static void main(String[] args) {
		String filePath = patchSplit.class.getResource(".").getPath() + "/list.txt";
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(filePath));
			String s;

			while ((s = in.readLine()) != null) {
				System.out.println(s.substring(s.lastIndexOf("/")+1));
			}
			
			System.out.println("\n\n");
			
			in = new BufferedReader(new FileReader(filePath));
			while ((s = in.readLine()) != null) {
				System.out.println(s.substring(0,s.lastIndexOf("/")+1));
			}
			in.close();
		} catch (IOException e) {
			System.err.println(e); // 에러가 있다면 메시지 출력
			System.exit(1);
		}
	}

}
