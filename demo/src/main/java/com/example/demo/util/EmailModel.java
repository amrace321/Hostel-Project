package com.example.demo.util;

import javax.persistence.Entity;

/*@Entity*/
public class EmailModel {

	private String sendTo;

	private String Subject;

	private String message;

	public String getSendTo() {
		return sendTo;
	}

	public void setSendTo(String sendTo) {
		this.sendTo = sendTo;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
