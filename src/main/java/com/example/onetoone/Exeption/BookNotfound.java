package com.example.onetoone.Exeption;

public class BookNotfound extends RuntimeException{

	public BookNotfound(String msg) {
		super(msg);
		
	}
	public BookNotfound() {
		super();
	}
}
