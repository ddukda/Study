package com.jino.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class sample03 extends Thread
{
	static ArrayList<PrintWriter> arGeneral = new ArrayList<PrintWriter>();
	Socket socket;

	public sample03(Socket socket)
	{
		this.socket = socket;
	}

	@Override
	public void run()
	{
		InputStream os;
		try
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			arGeneral.add(out);

			while (true)
			{
				String msg = in.readLine();
				System.out.println(msg);
				for (int i = 0; i < arGeneral.size(); i++)
				{
					arGeneral.get(i).println(msg);
				}
			}

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}
