package com.sonny.demo.WordConvertToPDF;

public class ConvertOffice {

    public static void convert(String sourceFile, Papers officeType) {
        officeType.convert(sourceFile);
    }

    public static String getFileName(String arg1) {
        int dot = arg1.lastIndexOf('.');
        if (dot != -1) {
            return arg1.substring(0, dot);
        }
        return arg1;
    }
}
