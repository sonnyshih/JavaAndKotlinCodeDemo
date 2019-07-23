package com.sonny.demo.file;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sonny.demo.file.entity.CapabilityInfoEntity;
import com.sonny.demo.file.entity.DeviceInfoEntity;
import com.sonny.demo.util.FileUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class ReadResDemo {
    public static String CAPABILITY_JSON_PATH = "/deviceData.json";

    public static void main(String[] args) {
        CapabilityInfoEntity capabilityInfo = getCapabilityInfo();

        List<DeviceInfoEntity> devicelist = capabilityInfo.getCapabilityInfoList();

        for (DeviceInfoEntity entity: devicelist ) {
            System.out.println("Device Name: " + entity.getDeviceName());
            System.out.println("Platform Name: " + entity.getPlatformName());
            System.out.println("Platform Version: " + entity.getPlatformVersion());
            System.out.println("###########");
        }


    }


    public static CapabilityInfoEntity getCapabilityInfo() {
        InputStream inputStream = FileUtil.getInputStream(CAPABILITY_JSON_PATH);
        String jsonString = null;
        try {
            jsonString = FileUtil.getString(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Type type = new TypeToken<CapabilityInfoEntity>() {  }.getType();
        Gson gson = new Gson();

        CapabilityInfoEntity capabilityInfo = gson.fromJson(jsonString, type);

        return capabilityInfo;
    }
}
