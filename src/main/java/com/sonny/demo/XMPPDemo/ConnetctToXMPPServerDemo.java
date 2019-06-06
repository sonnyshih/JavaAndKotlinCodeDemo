package com.sonny.demo.XMPPDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnetctToXMPPServerDemo {

//	private static String address = "10.16.197.69";
//	private static String address = "talk.google.com";
	private static String address = "chat.facebook.com";

	private static int port = 5222;
	private static String initiate_conn;
	private static Socket client;
	private static BufferedWriter to_server;
	private static BufferedReader bufferedReader;
	private static boolean flag = false;
	
	
	public static void main(String[] args) {
		
		
		
		
		initiate_conn = "<stream:stream to=\""
				+ address
				+ "\" xmlns=\"jabber:client\" xmlns:stream=\"http://etherx.jabber.org/streams\" version=\"1.0\">";

		try {
			client = new Socket(address, port);
			
            to_server = new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream(),"UTF-8"));

            DataInputStream input = new DataInputStream(client.getInputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(input,"UTF-8"));

            to_server.write(initiate_conn);
            to_server.flush();
            
            new Thread(new Runnable() {
				
				@Override
				public void run() {
					String responseLine = "";
					flag = true;
					
					while (flag) {
						char c;
						try {
							c = (char) bufferedReader.read();
							responseLine += c;
						} catch (IOException e) {
							e.printStackTrace();
						}
						
						if  (responseLine.contains("</stream:features>")) {
							System.out.println("Client send:" + initiate_conn);
							System.out.println(" Client get: " + responseLine);
							System.out.println("###################################");
				            try {
				            	responseLine = "";
				            	initiate_conn = "<starttls xmlns='urn:ietf:params:xml:ns:xmpp-tls'/>";
								to_server.write(initiate_conn);
					            to_server.flush();
							} catch (IOException e) {
								e.printStackTrace();
							}

						}
						
						if (responseLine.contains("<proceed xmlns=") && responseLine.contains("/>")) {
							System.out.println("Client send:" + initiate_conn);
							System.out.println(" Client get: " + responseLine);
							
//				            try {
//				            	responseLine = "";
//								initiate_conn = "<stream:stream xmlns='jabber:client' xmlns:stream='http://etherx.jabber.org/streams' to='"
//										+ address + "' version='1.0'>";
//								to_server.write(initiate_conn);
//					            to_server.flush();
//							} catch (IOException e) {
//								e.printStackTrace();
//							}

							
							flag = false;
						} 
						
					}
					

					
				}
			}).start();
            
//			client.close();
//			client = null;

			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void send(){
		
	}

	public static void receive(){
		
	}
}
