package com.spring.bookstore.controller;

import com.spring.bookstore.entity.BookEntity;
import com.spring.bookstore.entity.CategoryEntity;
import com.spring.bookstore.repository.BookRepository;
import com.spring.bookstore.service.BookService;
import com.spring.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class BookController {

    @Autowired
    BookService bookService;
    @Autowired
    CategoryService categoryService;
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
    public String showEditBook(@PathVariable int id, Model model) {
        BookEntity book1 = (BookEntity) bookService.findById(id);
        model.addAttribute("book", book1);
        model.addAttribute("msg", "Add New Book");
        model.addAttribute("action", "newBook");
        setCategoryList(model);
        return "bookactions";
    }

    @PostMapping(value = "/newBook")
    public String editBook(@ModelAttribute("book") BookEntity book) {
        bookService.save(book);
        return "redirect:/";
    }

    public void setCategoryList(Model model) {
        List<CategoryEntity> cateList = (List<CategoryEntity>) categoryService.findAll();
        if(!cateList.isEmpty()) {
            Map<Integer, String> categories = new HashMap<>();
            for (CategoryEntity category: cateList) {
                categories.put( category.getId(), category.getName());
            }
            model.addAttribute("categoryList", categories);
        }
    }
}
