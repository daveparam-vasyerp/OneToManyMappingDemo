package com.example.onetoone.model;

import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data

//This is Entity class/model class for "Author"
public class Author {
	@Id
	@GeneratedValue
	private long authorId;
	private String  authorName;
	private String authorEmail;
	private long authorPhone;
	
	@OneToOne
	private Book book;
	
	
	public Author() {
		super();
	}

	public Author( String authorname, String authoremail, long authorphone) {
		super();
		this.authorName = authorname;
		this.authorEmail = authoremail;
		this.authorPhone = authorphone;
	}

	public Author(String authorName, String authorEmail, long authorPhone, Book book) {
		super();
		this.authorName = authorName;
		this.authorEmail = authorEmail;
		this.authorPhone = authorPhone;
		this.book = book;
	}
	
	

	

}
