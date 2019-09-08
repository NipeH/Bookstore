package com.example.bookstore.web;

import com.example.bookstore.domain.Book;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class BookController {

    @RequestMapping(value="/index", method = RequestMethod.GET)
    public String getBookForm(Model model) {

        model.addAttribute("book", new Book()); // tekee tyhjän Kirja-olion


        return "index";

    }


}
