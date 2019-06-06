package com.sonny.demo.file;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import sun.misc.BASE64Encoder;

public class DownloadFile {

	public static void main(String[] args) {
		
		/** Setting the Proxy Server 
		 *	If your network must use the proxy server, you must set it. 
		 **/
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		String proxyHost = "10.16.10.150";
		String proxyPort = "8080";
		String proxyUsername = "ss9t";
		String proxyPassword = "*ik,9ol.,";
		String uname_pwd = proxyUsername + ":" + proxyPassword;
		String auth = "Basic " + base64Encoder.encode(uname_pwd.getBytes());

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
				proxyHost, Integer.parseInt(proxyPort)));
		
		String urlString = "http://developer.android.com/images/home/android-jellybean.png";
		System.out.println("/* ##### Start to Download ##### */");
		try {
			
			URL url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection(proxy);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.setRequestProperty("Proxy-Authorization", auth);	
			httpURLConnection.connect();
	
			InputStream inputStream = httpURLConnection.getInputStream();
			
			// Create a new file stream
			OutputStream outputStream = new FileOutputStream("d:\\temp\\android-jellybean.png");

			int bufferSize = -1;	// calculate the size of reading data.
            byte[] buffer = new byte[1024];		// Create the 1024 bytes Buffer
            
            while ((bufferSize = inputStream.read(buffer)) != -1) {
            	outputStream.write(buffer, 0, bufferSize);
            }

            inputStream.close();
            outputStream.close();
            httpURLConnection.disconnect();
            
    		System.out.println("/* ##### Complete to Download ##### */");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(false);
		}
		

	}
}
