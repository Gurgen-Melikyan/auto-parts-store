package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAllProducts();
    Optional<Product> findById(int id);
    Page<Product> findAll(Pageable pageable);
    void addProduct(User currentUser, MultipartFile multipartFile, Product product) throws IOException;
    void deleteById(int id);
}
