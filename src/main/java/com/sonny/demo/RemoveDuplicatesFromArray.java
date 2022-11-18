package com.sonny.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    /**
     * Refer to : https://www.geeksforgeeks.org/how-to-remove-duplicates-from-arraylist-in-java/
     * */
    public static void main(String[] args) {
//        intTest();
        intString();
    }

    private static void intTest(){

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 10, 1, 2, 2, 3, 3, 10, 3, 4, 5, 5));

        System.out.println("ArrayList with duplicates: "  + list);

        // Remove duplicates
        ArrayList<Integer> newList = removeDuplicates(list);

        // Print the ArrayList with duplicates removed
        System.out.println("ArrayList with duplicates removed: " + newList);
    }

    private static void intString(){

        ArrayList<String> list = new ArrayList<>(Arrays.asList("aaaa@gmail.com", "bbb@gmail.com", "ccc@gmail.com", "ddd@gmail.com", "aaaa@gmail.com", "ccc@gmail.com"));

        System.out.println("ArrayList with duplicates: "  + list);

        // Remove duplicates
        ArrayList<String> newList = removeDuplicates(list);

        // Print the ArrayList with duplicates removed
        System.out.println("ArrayList with duplicates removed: " + newList);
    }


    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {

        ArrayList<T> newList = new ArrayList<T>();

        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }
}
