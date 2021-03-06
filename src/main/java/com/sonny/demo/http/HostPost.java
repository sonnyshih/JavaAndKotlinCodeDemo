package com.sonny.demo.http;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

import sun.misc.BASE64Encoder;

public class HostPost {

	public static void main(String[] args) {

		/**
		 * Setting the Proxy Server. If your network must use the proxy server,
		 * you must set it.
		 **/
		BASE64Encoder base64Encoder = new BASE64Encoder();
		
		String proxyHost = "10.16.10.150";
		String proxyPort = "8080";
		String proxyUsername = "ss9t";
		String proxyPassword = "&ujm8ik,";
		String uname_pwd = proxyUsername + ":" + proxyPassword;
		String auth = "Basic " + base64Encoder.encode(uname_pwd.getBytes());

		Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(
				proxyHost, Integer.parseInt(proxyPort)));

//		String urlString = "https://secure.ows.newegg.com/customers/order.egg/detail";
//		String inputJSON = "{\"PreSONumber\":0,\"SONumber\":142490259,\"CustomerNumber\":26243981,\"LoginName\":\"nparealtest@gmail.com\",\"OrderDate\":\"05/10/2013\",\"InvoiceNumber\":107338364}";

		String urlString = "https://secure.ows.newegg.com/ShoppingLogin.egg";
		String inputJSON = "{\"LoginName\":\"sonny.h.shih@newegg.com\",\"Password\":\"sonny!12345\"}";
		
		
		try {

			URL url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection(proxy);

			httpURLConnection.setDoOutput(true);	// �ϥ�post�ɻݳ]�w
			httpURLConnection.setDoInput(true);		// �ϥ�post�ɻݳ]�w
			httpURLConnection.setRequestMethod("POST");

			// �]���ݭn�z�LProxy�~�i�H�s�W�����A�]���ݭn�]�w Proxy-Authorization
			httpURLConnection.setRequestProperty("Proxy-Authorization", auth);
			
			httpURLConnection.setRequestProperty("Accept", "application/json");
			httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
//			httpURLConnection.setRequestProperty("Accept-Encoding", "gzip,deflate");
			httpURLConnection.setRequestProperty("X-HighResolution", "false");
			httpURLConnection.setRequestProperty("Content-type", "application/json"); // For JSON
			// httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded"); // For UrlEncoded
			// httpURLConnection.setRequestProperty("User-Agent", "Newegg AndroidTablet App / 2.0.0"); // For Tablet
			httpURLConnection.setRequestProperty("User-Agent", "Newegg Android App / 3.2.1"); // For Phone
			httpURLConnection.setRequestProperty("X-AuthToken", "U7KVXbjJnS4zVNqe5AZZqjXzw9flGciT1FN20wb1Bjw=");
			httpURLConnection.setRequestProperty("X-ThirdParty-UTMA", "");
			httpURLConnection.setRequestProperty("MobileVisitor", "VERSIONINFO=Unown Device");

			OutputStream os = httpURLConnection.getOutputStream();
			byte[] outputBytes = inputJSON.getBytes("UTF-8");
			os.write(outputBytes);
			os.flush();
			os.close();

			// System.out.println(httpURLConnection.getResponseCode() + " : " +
			// httpURLConnection.getResponseMessage());
			// System.out.println(httpURLConnection.getResponseCode() ==
			// HttpURLConnection.HTTP_OK);
			StringBuilder builder = new StringBuilder();
			if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(
								httpURLConnection.getInputStream()));

				String line;
				while ((line = reader.readLine()) != null) {
					builder.append(line);
				}

				System.out.println(builder.toString());

			}

			httpURLConnection.disconnect();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(false);
		}

	}

}
