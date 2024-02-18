package com.sonny.demo.ftp;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.*;

public class FTPDemo {

    public static void main(String[] args) {
        startFtp();
    }

    public static void startFtp(){
        String FTP_SERVER = "xxx.xxx.xxx.xxx";
        int SFTP_PORT = 21;
        String FTP_ACCOUNT = "abc";
        String FTP_PASSWORD = "123";

        FTPService ftpService = new FTPService(FTP_SERVER, SFTP_PORT, FTP_ACCOUNT, FTP_PASSWORD,
                new FTPService.FTPServiceListener(){

                    @Override
                    public void connected(FTPClient ftpClient) {
                        System.out.println("isConnected");
//                        getDirList(ftpClient);  // get dir list
//                        getFileList(ftpClient); // get file list
//                        createFolder(ftpClient, "/hello");    //create a folder
//                        startDownload(ftpClient);     // download file
                        startUpload(ftpClient);   // upload file

                        // disconnect
                        disconnect(ftpClient);
                    }

                    @Override
                    public void connectFail(String message) {
                        System.out.println("ftpFail = " + message);
                    }

                });

        ftpService.connect();
    }

    public static void disconnect(FTPClient ftpClient){
        // disconnect
        if (ftpClient!=null){
            try {
                ftpClient.logout();
                ftpClient.disconnect();
                System.out.println("disconnect");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /** ##### Only get dir list ##### */
    public static FTPFile[] getDirList(FTPClient ftpClient){
//        String path = "/";    // 根目錄
        String path = "/core";
        FTPFile[] dirList = null;

        if (ftpClient !=null && ftpClient.isConnected()) {

            try {
                ftpClient.setBufferSize(1024);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                dirList = ftpClient.listDirectories(path);  // only get folder list

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException error = " + e);
            }

        }

        for (FTPFile ftpFile :dirList) {
            System.out.println("name="+ftpFile.getName());
        }

        return dirList;
    }

    /** ##### get file and folder list ##### */
    public static FTPFile[] getFileList(FTPClient ftpClient){
        //        String path = "/";    // 根目錄
        String path = "/core";

        FTPFile[] fileList = null;

        if (ftpClient !=null && ftpClient.isConnected()) {

            try {
                ftpClient.setBufferSize(1024);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                fileList = ftpClient.listFiles(path);   // get folder and file

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (FTPFile ftpFile :fileList) {
            System.out.println("name = "+ftpFile.getName() + " isFile = " + ftpFile.isFile());
        }

        return fileList;
    }

    /** ##### create a folder ##### */
    public static boolean createFolder(FTPClient ftpClient, String path){

        boolean isSuccess = false;

        if (ftpClient !=null && ftpClient.isConnected()) {
            try {
                boolean isExist = ftpClient.changeWorkingDirectory(path);
                System.out.println(isExist);
                if (!isExist){
                    ftpClient.makeDirectory(path);
                    isSuccess = true;
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("IOException: " + e);
                isSuccess = false;
            }
        }

        return isSuccess;
    }

    public static void startDownload(FTPClient ftpClient){
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/ftp/";
        System.out.println("dirPath = " + dirPath);

        File remoteFile = new File("/", "05.jpg");
        File localFile = new File(dirPath, "test.jpg");

        boolean isSuccess = downloadFile(ftpClient, remoteFile, localFile);

        System.out.println("download isSuccess = " + isSuccess);
    }

    /** Demo Download file
     File remoteFile = new File("/uploadfile/banner/8", "60139188a9ed9.jpg");
     File localFile = new File(getExternalFilesDir(BASE_FOLDER), "test.jpg");
     */
    public static boolean downloadFile(FTPClient ftpClient, File remoteFile, File localFile){

        boolean isSuccess = false;

        if (ftpClient !=null && ftpClient.isConnected()) {

            try {
                // check the file is exist
                FTPFile[] remoteFiles = ftpClient.listFiles(remoteFile.getPath());
                if (remoteFiles.length == 0){
                    return false;
                }

                OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFile));
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                ftpClient.enterLocalPassiveMode();
                ftpClient.retrieveFile(remoteFile.getPath(), outputStream);
                outputStream.close();
                isSuccess = true;
            } catch (IOException e) {
                e.printStackTrace();
                isSuccess = false;
            }
        }

        return isSuccess;
    }


    public static void startUpload(FTPClient ftpClient){
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/ftp/";
        System.out.println("dirPath = " + dirPath);

        File localFile = new File(dirPath, "01.jpg");
        File remoteFile = new File("/", "hello.jpg");

        boolean isSuccess = uploadFile(ftpClient, localFile, remoteFile);
        System.out.println("upload isSuccess = " + isSuccess);
    }
    /** Demo upload file
     File localFile = new File(getExternalFilesDir(BASE_FOLDER + "2021042311380960"), "2021042311380960.pdf");
     File remoteFile = new File("/uploadfile", "test.pdf");
     */
    public static boolean uploadFile(FTPClient ftpClient, File localFile, File remoteFile) {
        boolean isSuccess = false;

        if (ftpClient != null && ftpClient.isConnected()) {
            try {
                ftpClient.setBufferSize(1024);
                ftpClient.enterLocalPassiveMode();
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//                String[] paths = remoteFile.getParent().split("/");
//                for (String s : paths) {
//                    ftpClient.makeDirectory(s);
//                    ftpClient.changeWorkingDirectory(s);
//                }
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(localFile));

                // 檢查遠端伺服器是否有相同的文件, 有的話表示上次沒傳成功, 需先砍掉
                FTPFile[] files = ftpClient.listFiles(remoteFile.getPath());
                if (files.length == 1) ftpClient.deleteFile(remoteFile.getPath());

                ftpClient.storeFile(remoteFile.getPath(), bis);
                bis.close();
//                size = ftpClient.listFiles(remoteFile.getPath())[0].getSize();
                isSuccess = true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return isSuccess;
    }
}
