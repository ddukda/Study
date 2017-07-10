package com.study.headfirst.net;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class HFSocket {

	
	public static void main(String[] args) throws UnknownHostException, IOException{
		
		Socket chatSocket = new Socket("127.0.0.1", 5000); 
		
	}
}
