package com.sonny.demo.XMPPDemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class XmppSampleCodeDemo {

	
	public static void main(String[] args) {

		String address = "10.16.197.69";
//		String address = "talk.google.com";
		int port = 5222;
		boolean flag = false;
		
		String initiate_conn="<stream:stream to=\"10.16.197.69\" xmlns=\"jabber:client\" xmlns:stream=\"http://etherx.jabber.org/streams\" version=\"1.0\">";
		


		try {
			Socket client = new Socket(address, port);
			
            BufferedWriter to_server = new BufferedWriter(
                    new OutputStreamWriter(client.getOutputStream(),"UTF-8"));

            DataInputStream input = new DataInputStream(client.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input,"UTF-8"));

            
            to_server.write(initiate_conn);
            to_server.flush();
            
//            String responseLine="";
//			while (!(responseLine.contains("</stream:features>"))) {
//				char c = (char) bufferedReader.read();
//				responseLine += c;
//			}
//            System.out.println("Server: " + responseLine);

            
			String responseLine = "";
			flag = true;
			while (flag) {
				char c = (char) bufferedReader.read();
				responseLine += c;
				
				if  (responseLine.contains("</stream:features>")) {
					flag = false;
				}
				
			}
			
			System.out.println("Server: " + responseLine);
            
			client.close();
			client = null;
		} catch (IOException e) {
			e.printStackTrace();

			System.out.println("open Socket fail ! = " + e.getMessage());
		}
	}
	
	public static void connectGTalk(){
		
		String initiate_conn="<stream:stream to=\"gmail.com\" version=\"1.0\" xmlns=\"jabber:client\" xmlns:stream=\"http://etherx.jabber.org/streams\">";
		String start_tls="<starttls xmlns=\"urn:ietf:params:xml:ns:xmpp-tls\"/>";
		
		 try {
	            Socket connection = new Socket("talk.google.com", 5222);
	            DataInputStream input = new DataInputStream(connection.getInputStream());
	            BufferedReader d = new BufferedReader(new InputStreamReader(input,"UTF-8"));
	            BufferedWriter to_server = new BufferedWriter(
	                    new OutputStreamWriter(connection.getOutputStream(),"UTF-8")
	                    );
	            String responseLine="";
	            to_server.write(initiate_conn);
	            to_server.flush();
	            int in;
	            while(!(responseLine.contains("</stream:features>")))
	            {
	                responseLine += (char)d.read();   
	            }
	            System.out.println("Server: " + responseLine);
	            to_server.write(start_tls);
	            to_server.flush();
	            responseLine="";
	            while(!(responseLine.contains("<proceed xmlns=\"urn:ietf:params:xml:ns:xmpp-tls\"/>")))
	                responseLine += (char)d.read();   
	            System.out.println("Server: " + responseLine);
	            
	            connection.close();
	            connection = null;

	        } catch (UnknownHostException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }		

	}

}
