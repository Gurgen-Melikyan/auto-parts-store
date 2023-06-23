package com.example.autopartsstore.repository;

import com.example.autopartsstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {
}
