package com.example.models;

public class InvalidNumberException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public InvalidNumberException(String message){
		super(message);
	}

}
