package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class BookstoreApplication {

    private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }



    @Bean
    public CommandLineRunner bookstoreDemo(BookRepository bookRepository){
        return args -> {

            //title, author, year, isbn, price-->
            //public Book(Long id,String model, String author, int year, int isbn, double price) {
            log.info("save books");
            bookRepository.save(new Book("Sinuhe Egyptiläinen", "Mika Waltari", 1952, "0001", 43.90));
            bookRepository.save(new Book("Horna", "Ilkka Remes", 2014, "0002", 55.50));

            log.info("fetch all books");
            for (Book book : bookRepository.findAll()){
                log.info(book.toString());
            }
        };

    }

}
