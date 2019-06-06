package com.sonny.demo.http;

import java.net.MalformedURLException;
import java.net.URL;

public class GetURLFileNameAndPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String urlStr = "https://promotions.newegg.com/nepro/17-5000/1920x360.jpg";

		
		System.out.println("Protocol: " + getProtocol(urlStr));
		
		System.out.println("Host: " + getHost(urlStr));
		
		System.out.println("Path: " + getPath(urlStr));
		
		String fileName = urlStr.substring(urlStr.lastIndexOf('/')+1, urlStr.length());
		String fileNameWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));
		String fileExtension = urlStr.substring(urlStr.lastIndexOf(".")+1);

		
		System.out.println("file name = "+ fileName);
		System.out.println("fileNameWithoutExtension = "+fileNameWithoutExtension);
		System.out.println("fileExtension = "+fileExtension);
		
	}

	
	public static String getProtocol(String urlString){
        String protocol = "";

        try {
            URL url = new URL(urlString);
            protocol = url.getProtocol();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return protocol;
    }

    public static String getHost(String urlString){
        String hostString = "";
        try {
            URL url = new URL(urlString);
            hostString = url.getHost();
            if (url.getPort() != -1) {
                hostString += ":" + url.getPort();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return hostString;
    }

    public static String getPath(String urlString){

        String path = "";

        try {
            URL url = new URL(urlString);
            path =url.getPath();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return path;

    }
	
}
