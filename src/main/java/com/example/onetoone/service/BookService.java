package com.example.onetoone.service;

import java.util.List;

import com.example.onetoone.model.Book;

public interface BookService {
	
	public List<Book> getAllBook();
	public Book getBookById(long BookId);
	public Book saveBook(Book book);
	

}
