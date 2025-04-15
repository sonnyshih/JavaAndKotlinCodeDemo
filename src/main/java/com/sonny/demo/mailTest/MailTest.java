package com.sonny.demo.mailTest;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.util.Properties;

public class MailTest {
    public static void main(String[] args) {
        startSendmail();
    }

    private static void startSendmail(){
        boolean isDebugMode = true;
        String host = "smtp.gmail.com";
        int port = 587;
        String username = "jobtestshih1@gmail.com";
        String password = "zpp";

        Properties props = new Properties();

        //Configuring properties for gmail
        //If you are not using gmail you may need to change the values
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        //Creating a new session
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // set True can see the SMTP Debug Log
        session.setDebug(isDebugMode);
        String fromMail = "sonnyshih@gmail.com";
        String email = "jobtestshih1@gmail.com";
        String subject = "Hello";
        String content = "good day";

        // only Text
//        sendMail(session, fromMail,  email, subject, content);


        String workingDir = System.getProperty("user.dir");
        System.out.println("Working Directory = " + workingDir);

        String dirPath = workingDir + "/src/main/java/com/sonny/demo/mailTest/";
        System.out.println("dirPath = " + dirPath);

        String fileName = "01.jpg";
        String filePath = dirPath + fileName;
                sendMail(session, fromMail,  email, subject, content, filePath, fileName);


    }

    // Only Text
    public static void sendMail(Session session, String fromMail, final String email, final String subject, final String content){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Creating MimeMessage object
                    MimeMessage mimeMessage = new MimeMessage(session);

                    //Setting sender address
                    mimeMessage.setFrom(new InternetAddress(fromMail));

                    //Adding receiver
                    mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

                    //Adding subject
                    mimeMessage.setSubject(subject);

                    //Adding message
                    mimeMessage.setText(content);

                    //Sending email
                    Transport.send(mimeMessage);

//                    listener.JavaMailAPIResponse(true, "Send Successfully");

                } catch (MessagingException e) {
//                    listener.JavaMailAPIResponse(false, e.toString());
                    e.printStackTrace();
                }

            }// End run

        }).start();

    }


    // Have attached file
    public static void sendMail(Session session, String fromMail, final String email, final String subject, final String content,
                         final String filePath, final String fileName){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Creating MimeMessage object
                    MimeMessage mimeMessage = new MimeMessage(session);

                    //Setting sender address
                    mimeMessage.setFrom(new InternetAddress(fromMail));

                    //Adding receiver
                    mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

                    //Adding subject
                    mimeMessage.setSubject(subject);

                    // Create the message part
                    BodyPart messageBodyPart = new MimeBodyPart();

                    // Now set the actual message
                    messageBodyPart.setText(content);

                    // Create a multipar message
                    Multipart multipart = new MimeMultipart();

                    // Set text message part
                    multipart.addBodyPart(messageBodyPart);

                    // Part two is attachment
                    messageBodyPart = new MimeBodyPart();

                    DataSource source = new FileDataSource(filePath);
                    messageBodyPart.setDataHandler(new DataHandler(source));
                    messageBodyPart.setFileName(fileName);
                    multipart.addBodyPart(messageBodyPart);

                    // Send the complete message parts
                    mimeMessage.setContent(multipart);

                    //Sending email
                    Transport.send(mimeMessage);

//                    listener.JavaMailAPIResponse(true, "Send Successfully");

                } catch (MessagingException e) {
//                    listener.JavaMailAPIResponse(false, e.toString());
                    e.printStackTrace();
                }

            }// End run
        }).start();

    }

}
