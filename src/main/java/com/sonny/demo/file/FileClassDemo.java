package com.sonny.demo.file;

import java.io.File;

public class FileClassDemo {

	public static void main(String[] args) {
		
		File file = new File("d:\\temp\\test.txt");
		
		System.out.println(file.exists());
		System.out.println(file.getPath());
		System.out.println(file.getParent());
		System.out.println(file.length() + " bytes");	// byte
		System.out.println(file.length()/1024 + " Kbs");
		
	}

}
