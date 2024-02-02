package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetoone.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
	

}
