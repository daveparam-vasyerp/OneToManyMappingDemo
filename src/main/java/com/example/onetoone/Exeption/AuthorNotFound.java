package com.example.onetoone.Exeption;

public class AuthorNotFound extends RuntimeException{
	
	public AuthorNotFound(String message) {
		super(message);
	}
	public AuthorNotFound () {
		super();
	}
}
