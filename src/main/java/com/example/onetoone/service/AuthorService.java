package com.example.onetoone.service;

import java.util.List;

import com.example.onetoone.model.Author;

public interface AuthorService {
	
	public List<Author> getAll();

	public String deleteAuthor(long authorId);
	public Author addAuthor(Author author);
	public Author updateAuthoe(Author author);
	public Author findByAuthorId(long authorId);
	public Author AssignBook(long authorId,long bookId);
	
}
