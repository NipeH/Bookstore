package com.example.bookstore.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//title, author, year, isbn, price
@Entity
public class Book {

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String model, author, isbn;
    private int year;
    private double price;




    public Book(){


    }


    public Book(String model, String author, int year, String isbn, double price) {
        super();

        this.model = model;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
               // "id='"+id+ '\'' +
                "model='" + model + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", isbn=" + isbn +
                ", price=" + price +
                '}';
    }
}
