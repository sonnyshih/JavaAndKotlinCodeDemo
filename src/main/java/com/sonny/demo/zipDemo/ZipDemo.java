package com.sonny.demo.zipDemo;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/zipDemo/";
        System.out.println("dirPath = " + dirPath);

//        zipOneFile(dirPath);

//        zipMultipleFile(dirPath);

    }

    public static void zipOneFile(String dirPath){

        // Write message to a file.
        String path = dirPath + "file_test.txt";
        try {
            File file = new File(path);

            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello world \nWelcome to computer science portal \nGood Job!!");
            fileWriter.flush(); //flushing the writer
            fileWriter.close(); //closing the writer
        } catch (IOException e) {
            e.printStackTrace();
        }

        // compress a file to zip file
        String zipPath = dirPath + "file_test_impressed.zip";
        try {
            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            File fileToZip = new File(path);
            FileInputStream fis = new FileInputStream(fileToZip);

            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.close();
            fis.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void zipMultipleFile(String dirPath){
        // create 10 files
        for (int i=0; i<10; i++){
            String path = dirPath + "file_"+ i +".txt";
            try {
                File file = new File(path);
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write("Hello world "+ i +" \nWelcome to computer science portal \nGood Job!!");
                fileWriter.flush(); //flushing the writer
                fileWriter.close(); //closing the writer
            } catch (IOException e) {
                e.printStackTrace();
            }
        }// End for


        try {
            // compress multi file to zip file
            String zipPath = dirPath + "multi_file_Compressed.zip";

            FileOutputStream fos = new FileOutputStream(zipPath);
            ZipOutputStream zipOut = new ZipOutputStream(fos);

            for (int i=0; i<10; i++) {
                String path = dirPath + "file_" + i + ".txt";

                File fileToZip = new File(path);
                FileInputStream fis = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
                zipOut.putNextEntry(zipEntry);

                byte[] bytes = new byte[1024];
                int length;
                while((length = fis.read(bytes)) >= 0) {
                    zipOut.write(bytes, 0, length);
                }
                fis.close();
            }// End for

            zipOut.close();
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
