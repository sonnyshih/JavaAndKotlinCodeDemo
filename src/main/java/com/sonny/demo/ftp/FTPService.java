package com.sonny.demo.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;

public class FTPService {

    private FTPServiceListener listener;
    private FTPClient ftpClient = null;
    private String url;
    private int port;
    private String username;
    private String password;


    public FTPService(String url, int port, String username, String password, FTPServiceListener listener) {
        this.url = url;
        this.port = port;
        this.username = username;
        this.password = password;
        this.listener = listener;
        init();
    }

    private void init(){
        ftpClient = new FTPClient();
        ftpClient.setConnectTimeout(5000);      // set timeout
        ftpClient.setControlEncoding("UTF-8");  // set the Encode
    }

    public void connect(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                int reply = 0;

                try {
                    ftpClient.connect(url, port);
                    ftpClient.login(username, password);
                    reply = ftpClient.getReplyCode();

                    if (!FTPReply.isPositiveCompletion(reply)) {
                        ftpClient.disconnect();
                    }

                } catch (IOException e) {

                    e.printStackTrace();
                    if (listener!=null){
                        listener.connectFail(e.toString());
                    }

                }

                if (listener!=null){
                    listener.connected(ftpClient);
                }

            }
        }).start();
    }

    public void setListener(FTPServiceListener listener) {
        this.listener = listener;
    }

    public FTPClient getFtpClient() {
        return ftpClient;
    }

    public interface FTPServiceListener {
        void connected(FTPClient ftpClient);
        void connectFail(String message);
    }

}
