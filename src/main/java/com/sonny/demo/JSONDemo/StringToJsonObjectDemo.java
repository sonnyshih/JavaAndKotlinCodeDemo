package com.sonny.demo.JSONDemo;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class StringToJsonObjectDemo {

    public static void main(String[] args) {
        arrayStringToJsonObject();
    }

    public static void arrayStringToJsonObject(){
        String arrayString = "[{\"chapterID\":\"101\",\"partIDs\":[\"101\",\"101\",\"101\"]}," +
                             " {\"chapterID\":\"100\",\"partIDs\":[\"101\"]}]";

        Gson gson = new Gson();
        Type listType = new TypeToken<List<JsonObject>>() {}.getType();


        List<JsonObject> list = gson.fromJson(arrayString, listType);
        for (JsonObject obj: list) {
            System.out.println("chapterID: "+ obj.get("chapterID").getAsString());

            JsonArray partList = obj.get("partIDs").getAsJsonArray();

            for (int i=0; i< partList.size(); i++){
                System.out.println("part ID:" + partList.get(i).getAsString());
            }

            System.out.println("##########");
        }

    }
}
