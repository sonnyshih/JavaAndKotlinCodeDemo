package com.sonny.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneFormat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		String phone="123-123-4567";
//		String patternStr = "(\\d{3}-)(\\d{3}-\\d{4})";
//        Pattern pattern = Pattern.compile(patternStr);
//        Matcher matcher = pattern.matcher(phone);
//        
//        System.out.println("asdf="+matcher.find());
		
//		String testString3 = "0911-111-111";
//		String patternStr = "(\\d{4}-)(\\d{3}-\\d{3})";
//		Pattern pattern = Pattern.compile(patternStr);
//		Matcher matcher = pattern.matcher(testString3);
//		System.out.println("asdf="+matcher.find());
		
//		StringBuilder builder = new StringBuilder();
		
		String phone = "1112223333";

		if (phone.length() == 10) {
			String first = phone.substring(0,3);
			String second = phone.substring(3,6);
			String third = phone.substring(6,10);
			
			String phoneString = "("+ first +") " + second + "-" + third;
			System.out.println(phoneString);
			
		} else if (phone.length() > 10) {
			String first = phone.substring(0,3);
			String second = phone.substring(3,6);
			String third = phone.substring(6,10);
			String ext = phone.substring(10);
			
			String phoneString = "("+ first +") " + second + "-" + third + " x" + ext;
			System.out.println(phoneString);
			
		} else {
			System.out.println("Error format");
		}
		
	}

}
