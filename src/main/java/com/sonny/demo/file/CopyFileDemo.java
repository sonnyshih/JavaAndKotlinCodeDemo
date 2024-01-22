package com.sonny.demo.file;

import java.io.*;

public class CopyFileDemo {

    public static void main(String[] args) {
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/file/";

        System.out.println("dirPath = " + dirPath);

        String sourcePath = dirPath + "03.jpg";
        String destPath   = dirPath + "03-test.jpg";

        File source = new File(sourcePath);
        File dest = new File(destPath);

        try {
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }

            is.close();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
