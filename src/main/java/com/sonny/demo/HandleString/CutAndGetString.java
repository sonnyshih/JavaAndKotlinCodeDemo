package com.sonny.demo.HandleString;

public class CutAndGetString {

	private static String START_CHAR = "[";
	private static String END_CHAR = "]";

	
	public static void main(String[] args) {
		int startPosition = 0;
		int endPosition = 0;
		
		String temp =new String("[test] test [hello]");
		
	      
		for (int i = 0; i < temp.length(); i++) {
//			System.out.println("char " + i + "=" + temp.charAt(i));
			
			if (String.valueOf(temp.charAt(i)).equals(START_CHAR) ) {
				startPosition = i;
				System.out.println("Start = " + startPosition);
			}
			
			if (String.valueOf(temp.charAt(i)).equals(END_CHAR) ) {
				System.out.println("End = " + endPosition);
				endPosition = i;
				System.out.println(temp.substring(startPosition, endPosition+1));
			}
			
		}
	}

}
