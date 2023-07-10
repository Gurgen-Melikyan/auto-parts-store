package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAllCategories();
    Category findById(int id);
    Page<Category> findAll(Pageable pageable);
    void addCategory (String name);
    Category save(Category category);
    void deleteById(int id);
}
