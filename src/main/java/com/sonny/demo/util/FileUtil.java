/*******************************************************************
 * Copyright  (C) Newegg Corporation. All rights reserved.
 *
 * Author: Sonny Shih (sonny.h.shih@newegg.com)
 * Create Date: 2019/03/22
 * Usage:
 *
 * RevisionHistory
 * Date    Author    Description
 *
 ********************************************************************/

package com.sonny.demo.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtil {

    public static InputStream getInputStream(String path){
        InputStream inputStream = FileUtil.class.getResourceAsStream(path);

        return inputStream;
    }

    public static String getFileRealPath(String path){
        return FileUtil.class.getResource(path).getPath();
    }

    public static String getString(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }

        return stringBuilder.toString();
    }
}
