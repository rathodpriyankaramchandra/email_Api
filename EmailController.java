package com.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.email.model.EmailRequest;
import com.email.service.EmailService;


@RestController
public class EmailController {

	@Autowired(required=true)

	private EmailService emailService;

	@GetMapping("/hello")
	public String hello() {
		return "hello this is my email api";
	}
	
	//api to send email
			@RequestMapping(value="/sendemail",method=RequestMethod.POST)

			public ResponseEntity<?>sendEmail(@RequestBody EmailRequest request)
			{
				System.out.println(request);
				boolean result=	this.emailService.sendEmail(request.getSubject(),request.getMessage(), request.getTo());

				//return ResponseEntity.ok("Done..");
			if(result)
			{
				return ResponseEntity.ok("Email is sent successfully..");
			}else
			{
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not sent");
			}
			}
		}



