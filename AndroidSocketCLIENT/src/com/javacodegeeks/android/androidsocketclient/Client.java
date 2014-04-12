package com.javacodegeeks.android.androidsocketclient;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Client extends Activity {

	private Socket socket;

	private static final int SERVERPORT = 3000;
	private static final String SERVER_IP = "192.168.2.215";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);		
		
		new Thread(new ClientThread()).start();
	}
	
	public void sendButtonClick(View view) {
		try {
			EditText et1 = (EditText) findViewById(R.id.editKullanici);
			String str1 = et1.getText().toString();
			
			EditText et2 = (EditText) findViewById(R.id.editParola);
			String str2 = et2.getText().toString();
			
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())),
					true);
			out.println(str1);
			out.println(str2);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	class ClientThread implements Runnable {

		@Override
		public void run() {
			
			try {
				InetAddress serverAddr = InetAddress.getByName(SERVER_IP);

				socket = new Socket(serverAddr, SERVERPORT);

			} catch (UnknownHostException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}
}