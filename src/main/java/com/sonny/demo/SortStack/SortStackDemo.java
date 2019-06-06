package com.sonny.demo.SortStack;

import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class SortStackDemo {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();

		String c1 = "search within:amd|cpu"; 
//		String c1 = "GPU:Radeon RX 400 Series"; 
		stack.push(c1);

		String c2 = "manufacturer:biostar"; 
//		String c2 = "Department:Desktop Graphics Cards"; 
		stack.push(c2);

		String c3 = "sort by:featured items"; 
//		String c3 = "Memory Size:8GB"; 
		stack.push(c3);

		String c4 = "manufacturer:aiostar"; 
		stack.push(c4);

		String c5 = "sort by:featured items"; 
		stack.push(c5);

		String c6 = "search within:amd|cpu"; 
		stack.push(c6);

		Collections.sort(stack, new Comparator<String>() {
			public int compare(String str1, String str2) {
				int res = String.CASE_INSENSITIVE_ORDER.compare(str1, str2);
				if (res == 0) {
					res = str1.compareTo(str2);
				}
				return res;
			}
		});

		
		StringBuilder builder = new StringBuilder();
		for (String path : stack) {
			if (builder.length() > 0) {
				builder.append(",");
			}
			builder.append(path);
		}
		
		System.out.println(builder.toString());
		
	}

}
