package com.email.service;



import org.springframework.stereotype.Service;

import java.util.Properties;



import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	public boolean sendEmail(String subject, String message, String to) {
		//rest of the code
		boolean f=false;
		String from="priyankaramchandrarathod@gmail.com";


		//localhost:8080/hello		
		//variable for gmail
		String host="smtp.gmail.com";
		
		//get the  propertis
		
		Properties properties=System.getProperties();
		System.out.println("PROPERTIES"+properties);
		
		//setting important to properties object
		
		//host set
		
		properties.put("mail.smtp.host",host);
		properties.put("mail.smtp.port","465");
		properties.put("mail.smtp.ssl.enable","true");
		properties.put("mail.smtp.auth","true");
		
		//step1:to get the session object
		Session session=Session.getInstance(properties, new Authenticator()
		{
		protected PasswordAuthentication getPasswordAuthentication()
		{
			//return new PasswordAuthentication("priyankarathod9284@gmail.com", "generated_app_password_here");

		return new PasswordAuthentication("priyankaramchandrarathod@gmail.com","paqz gahk nqdx ubcl");
		}
		});

		session.setDebug(true);

		//step2:compose the message[text,multi media]

		MimeMessage m=new MimeMessage(session);

		try {

		//from email
		m.setFrom(from);
		//adding recipient to message



		// m.addRecipient(Message,RecipientType.TO,new InternetAddress(to));
		m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
		m.setSubject(subject);

		//adding text to message

		m.setText(message);
		//step3:send the message using Transport class

		Transport.send(m);

		System.out.println("sent success....1");

		f=true;

		}

		catch(Exception e) {

		e.printStackTrace();

		}

		return f;	
	}
}
