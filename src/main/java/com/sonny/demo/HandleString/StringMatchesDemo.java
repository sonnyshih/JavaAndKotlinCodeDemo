package com.sonny.demo.HandleString;
import com.sonny.demo.util.StringUtil;


public class StringMatchesDemo {

	public static void main(String[] args) {
//		String aaString = ".";
//		System.out.println(StringUtil.isNumber(aaString));
//		Float.parseFloat(aaString);
		
		String alertPrice = "0.0";
		String floatPattern = "([1-9]+[0-9]*)?[0-9]{1}(\\.{1}[0-9]+[0-9]*)?";
		System.out.println(alertPrice.matches(floatPattern));
	}

}
