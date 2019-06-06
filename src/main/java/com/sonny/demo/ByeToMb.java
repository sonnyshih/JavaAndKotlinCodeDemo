package com.sonny.demo;

public class ByeToMb {

	public static void main(String[] args) {
		long length = 3670016;	// Bye
		int sub_index = 0;
		String show = "";
		
		float abc = (float)length / 1048576;
		System.out.println(abc);
        sub_index = (String.valueOf(abc)).indexOf(".");
        System.out.println(sub_index);
        show = (abc + "00").substring(0, sub_index + 2) + "MB";
        System.out.println(abc + "00");
        System.out.println(show);

	}

}
