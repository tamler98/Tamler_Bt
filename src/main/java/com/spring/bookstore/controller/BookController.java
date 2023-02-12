package com.spring.bookstore.controller;

import com.spring.bookstore.entity.BookEntity;
import com.spring.bookstore.repository.BookRepository;
import com.spring.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class BookController {

    @Autowired
    BookService bookService;
    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showBook(Model model, @ModelAttribute(name="book") BookEntity book) {
        List<BookEntity> bookList = (List<BookEntity>) bookService.findAll();
        model.addAttribute("bookList", bookList);
        return "homepage";
    }

    @GetMapping(value = "/edit/{id}")
    public String editBook(@ModelAttribute("book") BookEntity book,@PathVariable int id, Model model) {
        BookEntity book1 = (BookEntity) bookService.findById(id);
        model.addAttribute("book", book1);

        return "editBook";
    }
}
