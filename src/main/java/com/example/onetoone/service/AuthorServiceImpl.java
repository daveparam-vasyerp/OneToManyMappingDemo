package com.example.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onetoone.Exeption.AuthorNotFound;
import com.example.onetoone.dto.ResponceDto;
import com.example.onetoone.model.Author;
import com.example.onetoone.model.Book;
import com.example.onetoone.repository.AuthorRepository;
import com.example.onetoone.repository.BookRepository;

import jakarta.persistence.EntityNotFoundException;
@Service

public class AuthorServiceImpl implements AuthorService  {
	@Autowired
	private AuthorRepository authorrepository;
	@Autowired
	private BookRepository bookRepository;
	
//	This Fetch Data for Author
	
	@Override
	public List<Author> getAll() {
		
		return authorrepository.findAll();
	}
	
	

	@Override
	public String deleteAuthor(long authorId) {
		if(!authorrepository.existsById(authorId)) {
			throw new EntityNotFoundException("Author not found with id: " + authorId);
		}
		return "deleted successfully";
	}
	

	@Override
	public Author addAuthor(Author author) {
		authorrepository.save(author);
		return author;
	}
	

	@Override
	public Author updateAuthoe(Author author) {
		Author existingAuthor=authorrepository.findById(author.getAuthorId()).orElseThrow(() ->new  AuthorNotFound("Author not found By "+ author.getAuthorId())) ;
		
		if(author.getAuthorName()!=null && author.getAuthorName().isEmpty()) {
			existingAuthor.setAuthorName(author.getAuthorName());
		}
		if(author.getAuthorEmail()!=null && author.getAuthorEmail().isEmpty()) {
			existingAuthor.setAuthorEmail(author.getAuthorEmail());
		}
		if((author.getAuthorPhone()+"").length()==10) {
			existingAuthor.setAuthorPhone(author.getAuthorPhone());
		}

		 authorrepository.save(existingAuthor);
		 return existingAuthor;
	}
	

	@Override
	public ResponceDto findByAuthorId(long authorId) {
		
		
		return new ResponceDto(200,"ok",authorrepository.findById(authorId).orElseThrow(() ->new  AuthorNotFound("Author not found By"+authorId)));
	}


	@Override
	public Author AssignBook(long authorId, long bookId) {
		Author author=authorrepository.findById(authorId).orElseThrow(() ->new  EntityNotFoundException("Author not found By"+authorId));
		Book book=bookRepository.findById(bookId).orElseThrow(() ->new  EntityNotFoundException("Author not found By"+bookId));
		author.setBook(book);
		return authorrepository.save(author);
	}
	
	
}
