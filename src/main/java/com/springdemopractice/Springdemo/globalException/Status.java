package com.springdemopractice.Springdemo.globalException;

import java.util.Date;

//import org.springframework.http.HttpStatus;

public class Status {
	private int status;
	private String customMessage;
	private Date date;

	public Status(int status, String customMessage, Date date) {

		this.status = status;
		this.customMessage = customMessage;
		this.date = date;
	}

	public Status() {

	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return customMessage;
	}

	public void setMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
