package com.sonny.demo.HandleString;

import com.sun.jndi.url.iiopname.iiopnameURLContextFactory;

public class GetSymbolPosition {

	public static void main(String[] args) {
		String url = "https://www.ows.newegg.com/Products.egg/9SIA0PG0ZJ4410/Detail?ispremier=false&Ignorebbr=false";

		int end = url.indexOf("://");
		System.out.println("end=" + end);
		System.out.println(url.substring(0, end));
		System.out.println(getStr(url, 3));

		
		String host = getStr(url, 3);
        int start = url.indexOf("://") + 3;
        int hostLen = host.length();
        String hostString = host.substring(start, hostLen); 
        System.out.println(hostString);


        int position = url.indexOf(hostString) + hostString.length();
        int len = url.length();
        System.out.println(url.substring(position, len) );
        
        
	}

	private static String getStr(String str, int n) {
		int i = 0;
		int s = 0;
		while (i++ < n) {
			s = str.indexOf("/", s + 1);
			if (s == -1) {
				return str;
			}
		}
		return str.substring(0, s);
	}

}
