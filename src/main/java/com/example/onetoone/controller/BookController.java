package com.example.onetoone.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetoone.model.Author;
import com.example.onetoone.model.Book;
import com.example.onetoone.service.BookService;

@RestController
@RequestMapping("/book")

//This is controller class for "Book"
public class BookController {
	private BookService bookservice;
	
	@GetMapping("/getBook")
	public ResponseEntity<List<Book>> getAllBook(){
		return new ResponseEntity<>(bookservice.getAllBook(),HttpStatus.OK);
	}
	@GetMapping("/getBook/{BookId}")
	public ResponseEntity<Book> getBookById(@PathVariable long BookId){
		return ResponseEntity.ok(bookservice.getBookById(BookId));
	}
	@PostMapping("/addBook")
	public ResponseEntity<Book> saveBook(@RequestBody Book book){
		return ResponseEntity.ok(bookservice.saveBook(book));
	}

}
