package com.example.bookstore.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


//tietokantakäsittelyn rajapinta
public interface BookRepository extends CrudRepository<Book, Long> {

List<Book> findByAuthor(String author);
}
