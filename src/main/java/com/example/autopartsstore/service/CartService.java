package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.Cart;
import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface CartService {
    void addToCart(List<Integer> products,User currentUser);

    Cart getCartByUserId(int userId);

    void crateCart(Cart cart);

    List<Product> getProductsInCart(int cartId);

    void emptyCart(int cartId);

}
