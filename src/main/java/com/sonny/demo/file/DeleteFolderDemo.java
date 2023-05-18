package com.sonny.demo.file;

import java.io.File;

public class DeleteFolderDemo {
    public static void main(String[] args) {
        String dirPath = "/Users/hongjie/Downloads/temp/hello";

        deleteFolder(dirPath);
    }

    public static void deleteFolder(String path){

        File dir = new File(path);
        if (!dir.exists()){
            System.out.println(">>>>> Delete folder is not exist");
            return;
        }

        if (dir.listFiles().length>0) {

            for (File file: dir.listFiles()) {

                // if it is file, delete it
                if (file.isFile()) {
                    file.delete();
                }

                // if it is directory, keep going to find inside folder.
                if (file.isDirectory()){
                    deleteFolder(file.getPath());
                }
            }
        }

        dir.delete();

    }


}
