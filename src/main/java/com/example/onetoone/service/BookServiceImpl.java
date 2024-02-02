package com.example.onetoone.service;

import java.util.List;

import com.example.onetoone.model.Book;
import com.example.onetoone.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;

public class BookServiceImpl implements BookService{

	private BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBook() {
		bookRepository.findAll();
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(long BookId) {
		return bookRepository.findById(BookId).orElseThrow(() ->new  EntityNotFoundException("Book not found By"+BookId));
	}

	@Override
	public Book saveBook(Book book) {
		bookRepository.save(book);
		return book;
	}

}
