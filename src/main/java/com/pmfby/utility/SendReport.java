package com.pmfby.utility;

import com.pmfby.config.MailConfig;
import com.pmfby.config.PMFBYConfig;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class SendReport {


    public static void sendEmailWithAttachments(String host, String port, final String userName, final String userPassword,
                                                String toAddress, String subject, String body, String[] attachFiles){
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.user", userName);
        properties.put("mail.password", userPassword);


        Session session = Session.getDefaultInstance(properties,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, userPassword);
                    }
                });

        try{
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(userName));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
            message.setSubject(subject);
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(body);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);

            if(attachFiles!=null && attachFiles.length > 0){
                for(String filePath : attachFiles){
                    MimeBodyPart attachment = new MimeBodyPart();
                    try{
                        attachment.attachFile(filePath);
                    }
                    catch (IOException e){
                        e.getStackTrace();
                        e.printStackTrace();
                    }
                    multipart.addBodyPart(attachment);
                }
            }

            message.setContent(multipart);
            Transport.send(message);
        }
        catch (Exception e){
            e.getStackTrace();
            e.printStackTrace();
        }
    }


    public static File getLatestFileFromDirectory(String dirPath){
        File dir = new File(dirPath);
        File[] files = dir.listFiles();
        if(files == null || files.length == 0)
            return null;

        File lastModifiedFile = files[0];
        for(int i = 1; i<files.length; i++){
            if(lastModifiedFile.lastModified() < files[i].lastModified())
                lastModifiedFile = files[i];
        }
        return lastModifiedFile;
    }


    public static void sendEmail(){
        String host = MailConfig.HOST;
        String port = MailConfig.PORT;
        String mailFrom = MailConfig.MAIL_FROM;
        String password = MailConfig.PASSWORD;
        String mailTo = MailConfig.RECIPIENTS;
        String subject = "TEST";
        String body = "TEST...";

        String[] attachFiles = new String[1];
        attachFiles[0] = getLatestFileFromDirectory(PMFBYConfig.REPORT_PATH).getAbsolutePath();

        try{
            sendEmailWithAttachments(host, port, mailFrom, password, mailTo, subject, body, attachFiles);
            System.out.println("MAIL SENT");
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("COULD NOT SEND EMAIL");
        }
    }
}
