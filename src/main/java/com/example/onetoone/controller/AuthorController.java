package com.example.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.onetoone.model.Author;
import com.example.onetoone.service.AuthorService;
import com.example.onetoone.service.BookService;
import com.example.onetoone.service.FileService;

@RestController
@RequestMapping("/author")

//This is controller class for "Author"
public class AuthorController {
	@Autowired
	private AuthorService authorservice;
	@Autowired
	private FileService fileService;
	
	@GetMapping("/getAuthor")
	
	public ResponseEntity<List<Author>>  getAll(){
		return new 	ResponseEntity<>(authorservice.getAll(),HttpStatus.OK);
	}
	@GetMapping("/getAuthor/{AuthorId}")
	public ResponseEntity<Author> findByAuthorId(@PathVariable long AuthorId){
		return ResponseEntity.ok(authorservice.findByAuthorId(AuthorId));
		
	}
	@DeleteMapping("/deleteAuthor/{AuthorId}")
	public ResponseEntity<String> deleteAuthor(@PathVariable long AuthorId){
		return ResponseEntity.ok(authorservice.deleteAuthor(AuthorId));
	}
	@PostMapping("/addAuthor")
	public ResponseEntity<Author> addAuthor(@RequestBody Author author){
		return ResponseEntity.ok(authorservice.addAuthor(author));
	}
	@PutMapping("/updateAuthor")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author){
		return ResponseEntity.ok(authorservice.updateAuthoe(author));
	}
	@PostMapping("/assingBook/{authorId}/{bookId}")
	public ResponseEntity<Author> assignBook(@PathVariable long authorId,@PathVariable long bookId){
		return ResponseEntity.ok(authorservice.AssignBook(authorId, bookId));
	}
	@PostMapping("/upload")
	public ResponseEntity<String> fileupload(@RequestParam("file") MultipartFile file){
		return fileService.fileupload(file);
	}
	@GetMapping("/download/{filename}")
	
	public ResponseEntity<Object> filedownload(@PathVariable String filename){
		return fileService.filedownload(filename);
	}
	@PostMapping("/append")
	public ResponseEntity<String> fileAppend(@RequestParam String file,@RequestParam("content") String content){
		return fileService.fileAppend(file,content);
	}
}
