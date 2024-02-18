package com.sonny.demo.ftp;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.util.Properties;

public class SFTPService {

    private SFTPServiceListener listener;
    private Session session;
    private ChannelSftp channelSftp = null;
    private String host;
    private int port;
    private String username;
    private String password;

    public SFTPService(String host, int port, String username, String password, SFTPServiceListener listener) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.listener = listener;
        init();
    }

    private void init(){
        JSch jsch = new JSch();
        try {
            session = jsch.getSession(username, host, port);
            session.setPassword(password);

            // set the properties
            Properties configTemp = new Properties();
            configTemp.put("StrictHostKeyChecking", "no");
            session.setConfig(configTemp);
            session.setTimeout(5000);   // set the timeout

        } catch (JSchException e) {
            e.printStackTrace();
        }

    }

    public void connect(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                Channel channel = null;

                try {

                    if (session!=null) {
                        session.connect();
                        channel = session.openChannel("sftp");
                        channel.connect();
                        channelSftp = (ChannelSftp) channel;
                    }

                } catch (JSchException e) {
                    e.printStackTrace();
                    if (listener!=null){
                        listener.connectFail(e.toString());
                    }
                }

                if (listener!=null){
                    listener.connected(channelSftp);
                }

            }
        }).start();

    }

    public interface SFTPServiceListener{
        void connected(ChannelSftp channelSftp);
        void connectFail(String message);
    }
}
