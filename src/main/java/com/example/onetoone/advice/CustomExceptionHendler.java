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
		public ResponceDto authorNotfoundHendler(Exception ex) {
			ResponceDto responce=new ResponceDto(404,"error",ex.getMessage());
			return responce;
			
		}
		
		
		
	}
