package br.com.fiap.microservice.Nac2MS.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.fiap.microservice.Nac2MS.model.Email;
import br.com.fiap.microservice.Nac2MS.model.StatusEmail;
import br.com.fiap.microservice.Nac2MS.repository.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	private EmailRepository emailRepository;
	
	
	@Autowired
	private JavaMailSender emailSender;
	
	
	public Email sendEmail(Email email) {
		
		
		email.setSendDataEmail(LocalDateTime.now());
		
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(email.getEmailFrom());
			message.setTo(email.getEmailTo());
			message.setSubject(email.getSubject());
			message.setText(email.getText());
			
			emailSender.send(message);
			
			email.setStatusEmail(StatusEmail.SENT);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			email.setStatusEmail(StatusEmail.ERROR);
			
		}
		finally {
			email =  emailRepository.save(email);
		}
		
		return email;
		
		
		
	}
	
	public Optional<Email> searchEmail(String  id){
		return emailRepository.findById(id);
	}
	

}
