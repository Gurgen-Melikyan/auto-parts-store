package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Cart;
import com.example.autopartsstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByUser_Id(int userId);



}
