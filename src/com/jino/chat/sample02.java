package com.jino.chat;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class sample02
{
	public static void main(String[] args) throws IOException
	{
		int i = 1;
		ServerSocket server = null;
		server = new ServerSocket(1251, 5);
		while (true)
		{
			System.out.println("Accept 대기");
			Socket socket = server.accept();
			System.out.println("Accept 성공");
			
			sample03 pcrt = new sample03(socket);
			pcrt.start();
			
		}

		// Socket socket = new Socket("115.20.247.142",1251);
		// InputStream is = socket.getInputStream();
		// byte i = (byte)is.read();
		// System.out.println(i);

	}
}