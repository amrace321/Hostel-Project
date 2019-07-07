package com.example.demo.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.hostelRepository.HostelRepo;
import com.example.demo.hostelRepository.StudentContactRepo;
import com.example.demo.modal.HostelInfoModel;
@Component
public class EmailService {
	@Autowired
	public HostelRepo hostelrepo;
	
	@Autowired
	public StudentContactRepo studentContactRepo;

	String username = "amrace321@gmail.com";

	String password = "ramdam123";

	public boolean sendEmail(EmailModel result) {

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		System.out.println("hit");
		// TODO Auto-generated method stub
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(result.getSendTo()));
			message.setSubject(result.getSubject());
			
			
			//HostelInfoModel hostelInfoModel2 =new HostelInfoModel();
			//message.setText("Hello sir "+"\\n\\n you have successfully booked this hostel \\n\\n\\n\\n\\n");
			message.setContent(result.getMessage(), "text/html");		
					
			// send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
			return true;

		} catch (MessagingException e) {
			
			return false;
		}
	}
}
