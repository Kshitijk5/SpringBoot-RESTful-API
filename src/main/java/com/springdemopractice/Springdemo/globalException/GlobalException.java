package com.springdemopractice.Springdemo.globalException;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException{
	
	@ExceptionHandler
	public Status NosuchId(TeacherNoSuchIdException t) {
		
	    Status status = new Status();
	    status.setStatus(HttpStatus.NOT_FOUND.value());
	    status.setMessage(t.getMessage());
	    status.setDate(new Date());
	    return status;
		
	}
	
	

}
