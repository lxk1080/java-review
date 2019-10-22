package com.book.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class Monitor {

	// 邮箱精简版
	public static void main(String[] args) {
		Monitor.sendTextEmail("这是一个主题", "内容什么的是什么我也不知道啊！");
	}
	
	
	// 邮件发送协议 
    private final static String PROTOCOL = "smtp";
    
    // SMTP邮件服务器默认端口 
    private final static String PORT = "25"; 

    // 是否要求身份认证 
    private final static String IS_AUTH = "true"; 
    
    // 是否启用调试模式（启用调试模式可打印客户端与服务器交互过程时一问一答的响应消息） 
    private final static String IS_ENABLED_DEBUG_MOD = "true"; 
    
    
    /**
     *  需要自行设置
     */
    // SMTP邮件服务器 
    private final static String HOST = "smtp.sina.com"; 

    // 发件人 
    private static String from = "*****mail@sina.com";
    
    // 密码
    private static String passwd = "www.*****.com";

    // 收件人 
    private static String to = "*****save@sina.com";

    // 初始化连接邮件服务器的会话信息 
    private static Properties props = new Properties(); 
   
	public static void sendTextEmail(String title, String content){ 
		props = new Properties(); 
        props.setProperty("mail.transport.protocol", PROTOCOL); 
        props.setProperty("mail.smtp.host", HOST); 
        props.setProperty("mail.smtp.port", PORT); 
        props.setProperty("mail.smtp.auth", IS_AUTH); 
        props.setProperty("mail.debug",IS_ENABLED_DEBUG_MOD); 
        props.put("mail.smtp.starttls.enable", "true");
        // 创建Session实例对象 
        Session session = Session.getDefaultInstance(props); 
        // 创建MimeMessage实例对象 
        MimeMessage message = new MimeMessage(session); 
        
        try {
        	// 设置发件人 
			message.setFrom(new InternetAddress(from));
			 // 设置邮件主题 
	        message.setSubject(title); 
	        // 设置纯文本内容为邮件正文 
	        message.setText(content);
	        // 设置发送时间 
	        message.setSentDate(new Date()); 
	        // 设置收件人 
	        message.setRecipient(RecipientType.TO, new InternetAddress(to)); 
	        // 保存并生成最终的邮件内容 
	        message.saveChanges(); 
	        // 获得Transport实例对象 
	        Transport transport = session.getTransport(); 
	        // 打开连接 
	        transport.connect(from, passwd); 
	        // 将message对象传递给transport对象，将邮件发送出去 
	        transport.sendMessage(message, message.getAllRecipients()); 
	        // 关闭连接 
	        transport.close();
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		} 
    } 
}
