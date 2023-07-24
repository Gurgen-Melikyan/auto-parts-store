package com.example.autopartsstore.service;

import com.example.autopartsstore.entity.Orders;
import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.entity.User;

import java.util.List;

public interface OrderService {

    Orders getOrderByUserId(int userId);

    void crateOrder(Orders order);

    void emptyOrder(int orderId);

    List<Product> getProductsInOrder(int orderId);

    void saveOrder(int cartId, User currentUser);

    void removeById(int id);
}
