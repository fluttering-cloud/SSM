package com.wang.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
public class EmailService {

     /*
      * @username 发件人
      * @password 密码/授权码
      * @host 邮箱端口，qq：smtp.qq.com  网易：smtp.163.com
      * @title 邮件主题
      * @text 邮件内容
      * @recipient 收件人
      */

    //一个简单的邮件发送
    public void send(JavaMailSenderImpl mailSender, String username,String password,
                        String host,String title,String text,String recipient ){

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        //实现多源发送，当用户使用qq邮箱发送时host为配置文件内的host,当用户使用网易邮箱时host为smtp.163.com
        if(host != null){
            mailSender.setHost(host);
        }


        //简单的邮件对象
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        //设置邮件主题
        mailMessage.setSubject(title);

        //设置邮件内容
        mailMessage.setText(text);

        //设置接收对象
        mailMessage.setTo(recipient);

        //设置发件人
        mailMessage.setFrom(username);

        //发送
        mailSender.send(mailMessage);
    }

    /*
       @fileName 附件名称
       @filePath 附件的路径
     */

    //一个复杂的邮件发送
    public void send(JavaMailSenderImpl mailSender,String username,String password,String host,
                      String title,String text,String fileName,String filePath,String recipient) throws MessagingException {

        mailSender.setUsername(username);
        mailSender.setPassword(password);

        //实现多源发送，当用户使用qq邮箱发送时host为配置文件内的host,当用户使用网易邮箱时host为smtp.163.com
        if(host != null){
            mailSender.setHost(host);
        }

        //复杂的邮件对象
        MimeMessage mailMessage = mailSender.createMimeMessage();

        //组装
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage,true);


        try {
            //主题
            helper.setSubject(title);
            //正文,true表示识别html
            helper.setText(text,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //附件
        helper.addAttachment(fileName,new File(filePath));

        helper.setTo(recipient);

        helper.setFrom(username);

        mailSender.send(mailMessage);
    }

}
