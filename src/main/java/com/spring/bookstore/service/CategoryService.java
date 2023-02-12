package com.spring.bookstore.service;

import com.spring.bookstore.entity.CategoryEntity;
import com.spring.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Object findAll() {
        return categoryRepository.findAll();
    }
}
