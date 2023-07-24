package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Orders;
import com.example.autopartsstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
    Optional<Orders>findByUser_Id(int userId);


}
