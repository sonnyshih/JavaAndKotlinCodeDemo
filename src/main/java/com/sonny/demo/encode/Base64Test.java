package com.sonny.demo.encode;

import sun.misc.BASE64Encoder;

public class Base64Test {

	public static void main(String[] args) {
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String id ="556b451c-3dc1-4d4b-8d0e-73894bf516c8";
		String token = "2dfcddf87f16a6d8bf56c831c17834214509a99df3dfbf22900cbb3ee423712e";
		String OrignAuth = id + ":" + token;
		String auth = base64Encoder.encode(OrignAuth.getBytes());
		System.out.println("auth="+auth);
		
	}
	
}
