package com.xupt.zxh.graduation.project.util;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.security.Security;
import java.util.Properties;

/**
 * 邮件相关类
 * Created by 张涛 on 2017/5/2.
 */
public class EmailUtil {

    /**
     * 发送邮件,并返回结果；true：表示发送成功；false：表示发送失败
     * @return
     */
    public static boolean sendEmail(final String content,final String email){
        boolean result = true;
        String host = ConstantsUtil.getValue("email_host");
        String username = ConstantsUtil.getValue("email_username");
        String password = ConstantsUtil.getValue("email_password");
        String subject = ConstantsUtil.getValue("email_forget_password_subject");
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        //获取系统属性
        Properties properties = System.getProperties();
        //设定邮件服务器
        properties.setProperty("mail.smtp.host", host);	//指定主机名
        properties.setProperty("mail.smtp.port", "25");
        properties.put("mail.smtp.auth", "true");	//使用安全验证
//        // 开启debug调试
//        properties.setProperty("mail.debug", "true");

        // 设置环境信息
        Session session = Session.getInstance(properties);

        // 创建邮件对象
        Message msg = new MimeMessage(session);
        try {
            //发送HTML邮件
            // MiniMultipart类是一个容器类，包含MimeBodyPart类型的对象
            Multipart mainPart = new MimeMultipart();
            // 创建一个包含HTML内容的MimeBodyPart
            BodyPart html = new MimeBodyPart();
            // 设置HTML内容
            html.setContent(content, "text/html; charset=utf-8");
            mainPart.addBodyPart(html);

            msg.setSubject(subject);
            msg.setFrom(new InternetAddress(username));
//            msg.setText(content);
            msg.setContent(mainPart);
            Transport transport = session.getTransport();
            transport.connect(username,password);
            transport.sendMessage(msg,new Address[]{new InternetAddress(email)});
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
        }

//        Authenticator auth = new Authenticator(){
//            public PasswordAuthentication getPasswordAuthentication(){
//                return new PasswordAuthentication(username,password);	//此处要求username和password是final类型
//            }
//        };

//        //获取默认的session对象
//        Session session = Session.getDefaultInstance(properties,auth);
//        //创建默认的MimeMessage对象
//        MimeMessage mimeMessage  = new MimeMessage(session);
//        try {
//            //设置头部，设置邮件发送人
//            mimeMessage.setFrom(new InternetAddress(username));
//            //添加头部，设置邮件接收人
//            mimeMessage.addRecipients(Message.RecipientType.TO,email);
//            //设置邮件的主题
//            mimeMessage.setSubject(subject);
//            //设置邮件内容
//            mimeMessage.setText(content);
//            mimeMessage.setSentDate(new Date());
//
//            Transport transport = session.getTransport("smtp");
//            transport.connect(host,username,password);
//            //发送邮件
//            transport.send(mimeMessage);
//        }catch (Exception e){
//            e.printStackTrace();
//            System.out.println("邮件发送失败！");
//            result = false;
//            return result;
//        }
        return result;
    }

}
