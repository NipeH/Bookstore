package com.example.bookstore.web;

import com.example.bookstore.domain.Book;


import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

//One to many tht


@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository crepository;

    //kirjojen listaaminen
    @RequestMapping(value="/booklist", method = RequestMethod.GET)
    public String getBooks(Model model) {
        List<Book> books = (List<Book>) bookRepository.findAll();
        model.addAttribute("books", books); // välitetään kirjalista html templatelle model-olion avulla

        return "booklist";
    }

    //tyhjän kirjalomakkeen muodostaminen
    @RequestMapping(value="/newbook", method = RequestMethod.GET)
    public String getBookForm(Model model) {
        model.addAttribute("book", new Book()); // tekee tyhjän Kirja-olion
        model.addAttribute("categories", crepository.findAll());

        return "bookform";

    }

    @RequestMapping(value="/newbook", method = RequestMethod.POST)
        public String saveBook(@ModelAttribute Book book){
            bookRepository.save(book);

            return "redirect:/booklist";
        }

    @RequestMapping(value="/deletebook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId){
            bookRepository.deleteById(bookId);
            return "redirect:../booklist";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editBook(@PathVariable("id") Long bookId, Model model) {
        model.addAttribute("book", bookRepository.findById(bookId));

        return "edit";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }
}
