package br.com.fiap.microservice.Nac2MS.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
	
	
	
	@NotBlank
	private String emailFrom;
	
	@NotBlank
	private String emailTo;
	
	@NotBlank
	private String subject;
	
	@NotBlank
	private String text;

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getEmailTo() {
		return emailTo;
	}

	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	

}
