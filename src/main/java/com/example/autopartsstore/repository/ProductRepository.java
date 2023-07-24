package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    Product findByUser_Id(int id);

}
