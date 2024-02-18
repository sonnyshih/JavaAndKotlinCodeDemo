package com.sonny.demo.ftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.SftpException;
import com.sonny.demo.ftp.SFTPService.SFTPServiceListener;

public class SFTPDemo {

    public static void main(String[] args) {

        startSFTPAction();
    }

    private static void startSFTPAction(){
        String FTP_SERVER = "xxx.xxx.xxx.xxx";
        int SFTP_PORT = 22;
        String FTP_ACCOUNT = "abc";
        String FTP_PASSWORD = "123";

        SFTPService sftpService = new SFTPService(FTP_SERVER, SFTP_PORT, FTP_ACCOUNT, FTP_PASSWORD,
            new SFTPServiceListener(){

                @Override
                public void connected(ChannelSftp channelSftp) {
                    System.out.println("isConnected");
                    uploadFile(channelSftp);
                }

                @Override
                public void connectFail(String message) {
                    System.out.println("ftpFail = " + message);
                }

        });

        sftpService.connect();
    }

    private static void uploadFile(ChannelSftp channelSftp){
        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/ftp/";

        System.out.println("dirPath = " + dirPath);
        String fileName="01.jpg";
        String localFilePath = dirPath + fileName;

        if (channelSftp.isConnected()){

            String remoteFolder = "aaa";
            boolean isFolderExist = false;

            try {
                channelSftp.cd(remoteFolder);
                isFolderExist = true;
            } catch (SftpException e) {
                e.printStackTrace();
                System.out.println("chdir fail = " + e.toString());
            }

            // if folder is not exist, create the new folder
            if (!isFolderExist) {
                try {
                    channelSftp.mkdir(remoteFolder);
                    channelSftp.cd(remoteFolder);
                } catch (SftpException e) {
                    e.printStackTrace();
                    System.out.println("mkdir fail = " + e.toString());
                }
            }

            try {
                channelSftp.put(localFilePath, fileName, ChannelSftp.OVERWRITE);  //上傳檔案
                channelSftp.exit();

            } catch (SftpException e) {
                e.printStackTrace();
                System.out.println("upload fail = " + e.toString());
            }

            // disconnect
            channelSftp.disconnect();
        }

    }

}
