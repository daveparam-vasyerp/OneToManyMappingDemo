package com.example.onetoone.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.onetoone.Exeption.AuthorNotFound;
import com.example.onetoone.dto.ResponceDto;

@RestControllerAdvice
public class CustomExceptionHendler  {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AuthorNotFound.class)
		public ResponceDto authorNotfound(AuthorNotFound ex) {
			ResponceDto responce=new ResponceDto(404,"error",ex.getMessage());
			return responce;
			
		}
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(AuthorNotFound.class)
		public ResponceDto bookNotFound(AuthorNotFound ex) {
			ResponceDto responce=new ResponceDto(404,"error",ex.getMessage());
			return responce;
			
		}
	
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
		public ResponceDto GeneralException(Exception ex) {
			ResponceDto responce=new ResponceDto(404,"error",ex.toString());
			return responce;
			
		}
	
	
	
		
		
		
	}
