package com.sonny.demo.JSONDemo;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StringToJsonObjectDemo {

    public static void main(String[] args) {
        arrayStringToJsonObject();
    }

    public static void arrayStringToJsonObject(){
        String arrayString = "['aa', 'bb', 'ccc', 'dddd']";

        Gson gson = new Gson();
        Type listType = new TypeToken<List<String>>() {}.getType();


        List<String> list = gson.fromJson(arrayString, listType);
        for (String id: list) {
            System.out.println("ID: "+ id);
        }

    }
}
