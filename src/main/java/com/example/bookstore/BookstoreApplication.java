package com.example.bookstore;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
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
    public CommandLineRunner bookstoreDemo(BookRepository bookRepository, CategoryRepository crepository){
        return args -> {

            //title, author, year, isbn, price-->
            //public Book(Long id,String model, String author, int year, String isbn, double price) {
            log.info("save books");

            crepository.save(new Category("Drama"));
            crepository.save(new Category("Thriller"));
            crepository.save(new Category("Scifi"));
            crepository.save(new Category("Learning"));
            crepository.save(new Category("Kids"));
            crepository.save(new Category("Comics"));
            crepository.save(new Category("Other"));

            bookRepository.save(new Book("Sinuhe Egyptiläinen", "Mika Waltari", 1952, "0001", 43.90, crepository.findByName("Drama").get(0)));
            bookRepository.save(new Book("Horna", "Ilkka Remes", 2014, "0002", 55.50, crepository.findByName("Thriller").get(0)));

            log.info("fetch all books");
            for (Book book : bookRepository.findAll()){
                log.info(book.toString());
            }
        };

    }

}
