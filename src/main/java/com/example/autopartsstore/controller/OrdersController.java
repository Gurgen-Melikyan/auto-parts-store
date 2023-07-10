package com.example.autopartsstore.controller;


import com.example.autopartsstore.entity.Category;
import com.example.autopartsstore.repository.OrdersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRepository ordersRepository;
    
}
