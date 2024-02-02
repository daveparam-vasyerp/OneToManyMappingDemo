package com.example.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.onetoone.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
