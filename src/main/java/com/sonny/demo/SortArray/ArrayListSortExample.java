package com.sonny.demo.SortArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Random;

public class ArrayListSortExample {

	
	public static void main(String[] args) {
		
		ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
		
		for (int i = 0; i < 10; i++) {
			HashMap<String, Object> hashMap = new HashMap<String, Object>();
			
			String key = "key";
			String value = "value" + Integer.toString(getRandmoNumber());
			
			hashMap.put(key, value);
			arrayList.add(hashMap);
		}
		
		
		System.out.println("##### before sort #####");
		for (HashMap<String, Object> hashMap : arrayList) {
			System.out.println("value: " + hashMap.get("key"));
		}
		
		Collections.sort(arrayList, new Comparator<HashMap<String, Object>>(){

			@Override
			public int compare(HashMap<String, Object> firstObject, HashMap<String, Object> secondObject) {
				System.out.println("lhs.value =" + firstObject.get("key").toString());
				System.out.println("rhs.value =" + secondObject.get("key").toString());
				return firstObject.get("key").toString().compareToIgnoreCase(secondObject.get("key").toString());
			}
			
		});

		System.out.println("\n##### after sort #####");

		for (HashMap<String, Object> hashMap : arrayList) {
			System.out.println("value: " + hashMap.get("key"));
		}

	}


	public static int getRandmoNumber() {
		Random random = new Random();
		int number;
		number = random.nextInt(100); // the random number range. (0~100)
		System.out.println("Random Number: " + number);

		return number;

	}
}
