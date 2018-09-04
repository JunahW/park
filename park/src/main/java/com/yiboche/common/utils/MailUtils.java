package com.yiboche.common.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	public static void sendMail(String email, String emailMsg) throws AddressException, MessagingException {

		final Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		// 此处填写SMTP服务器
		props.put("mail.smtp.host", "smtp.qq.com");
		// 端口号，QQ邮箱给出了两个端口，但是另一个我一直使用不了，所以就给出这一个587
		props.put("mail.smtp.port", "587");
		// 此处填写你的账号
		props.put("mail.user", "2176915248@qq.com");
		// 此处的密码就是前面说的16位STMP口令
		props.put("mail.password", "dzzrrdxmncjvdjad");

		// 构建授权信息，用于进行SMTP进行身份验证
		Authenticator authenticator = new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				// 用户名、密码
				String userName = props.getProperty("mail.user");
				String password = props.getProperty("mail.password");
				return new PasswordAuthentication(userName, password);
			}
		};

		Session session = Session.getInstance(props, authenticator);

		// 创建邮件消息
		MimeMessage message = new MimeMessage(session);

		// 设置发件人
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));
		message.setFrom(form);

		// 设置收件人的邮箱
		message.setRecipient(RecipientType.TO, new InternetAddress(email));

		// 璁剧疆閭欢涓婚
		message.setSubject("用戶激活");
		// message.setText("杩欐槸涓�灏佹縺娲婚偖浠讹紝璇�<a href='#'>点击激活</a>");

		// 内容类型
		String url = "<a href='http://localhost:8080/eleba/user/active.action?code=" + emailMsg + "'>点击激活</a>";

		message.setContent(url, "text/html;charset=utf-8");

		// 3.发送
		Transport.send(message);
	}
}
