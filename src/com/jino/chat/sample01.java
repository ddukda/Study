package com.jino.chat;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteOrder;

import javax.swing.JFrame;

class MyFrame extends JFrame implements ActionListener
{
	public TextField tf;
	public TextArea ta;
	PrintWriter out;
	public MyFrame(PrintWriter out)
	{
		this.out = out;
		tf = new TextField();
		ta = new TextArea();
		setSize(600, 400);
		setVisible(true);
		add(tf, BorderLayout.SOUTH);
		add(ta, BorderLayout.CENTER);
		tf.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		if (arg0.getSource() == tf)
		{
			out.println(tf.getText().toString());
			tf.setText("");
		}
	}
}

public class sample01
{
	public static void main(String[] args)
	{
		BufferedReader user = new BufferedReader(new InputStreamReader(
				System.in));
		Socket socket;
		try
		{
			socket = new Socket("115.20.247.142", 1251);
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			MyFrame mf = new MyFrame(out);
			ReceiveThread rt = new ReceiveThread(socket, mf.ta);
			rt.start();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}

class ReceiveThread extends Thread
{
	Socket socket;
	TextArea ta;

	public ReceiveThread(Socket socket, TextArea ta)
	{
		this.socket = socket;
		this.ta = ta;
	}

	@Override
	public void run()
	{
		BufferedReader in;
		try
		{
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while (true)
			{
				ta.setText(ta.getText() +"\n"+ in.readLine());
			}

		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.run();
	}
}