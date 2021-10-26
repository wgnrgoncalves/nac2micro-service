package br.com.fiap.microservice.Nac2MS.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.microservice.Nac2MS.dto.EmailDto;
import br.com.fiap.microservice.Nac2MS.model.Email;
import br.com.fiap.microservice.Nac2MS.service.EmailService;


@RestController
public class EmailController {
	
	@Autowired
	private EmailService service;
	
	@PostMapping("/send")
	public ResponseEntity<Email> sendEmail(@RequestBody EmailDto emailDto){
		
		Email email = new Email();
		BeanUtils.copyProperties(emailDto, email);
		
		service.sendEmail(email);
		
		return new ResponseEntity<>(email, HttpStatus.OK);
		
	}
	
	
	@PostMapping("/seach/id")
	public Optional<Email> pesquisaEmail(@RequestBody String id){		
		return service.searchEmail(id);
	}
	
	@GetMapping("/teste")
	public EmailDto getEmail(){
	  EmailDto r = new EmailDto();
	  r.setEmailFrom("wngrgoncalves@gmail.com");
	  r.setEmailTo("rm83459@fiap.com.br");
	  r.setSubject("teste");
	  r.setText("teste");
	  return r;
		
	}

	

}