package com.spring.bookstore.service;

import com.spring.bookstore.entity.BookEntity;
import com.spring.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    public List<BookEntity> findAll() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    public Object findById(int id) {
        return bookRepository.findById(id);
    }
}
