package com.springdemopractice.Springdemo.globalException;

public class TeacherNoSuchIdException extends Exception {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TeacherNoSuchIdException(String message) {
		super(message);
	}
}
