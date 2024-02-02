package com.example.onetoone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data


//This is Entity class or model class for "Book"
public class Book {
	@Id
	@GeneratedValue
	private long bookId;
	private String bookName;
	private int bookPrice;
	
	public Book() {
		super();
	}

	public Book(long bookId, String bookName, int bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	
	

}
