package com.example.autopartsstore.controller;


import com.example.autopartsstore.entity.Cart;
import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.repository.CartRepository;
import com.example.autopartsstore.repository.OrdersRepository;
import com.example.autopartsstore.security.CurrentUser;
import com.example.autopartsstore.service.CartService;
import com.example.autopartsstore.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrdersController {
    private final OrdersRepository ordersRepository;
    private final OrderService orderService;
    private final CartRepository cartRepository;
    private final CartService cartService;


    @GetMapping
    public String ordersPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        double sum = 0;
        Cart cartByUserId = cartService.getCartByUserId(currentUser.getUser().getId());
        if (cartByUserId != null) {
            List<Product> productsInCart = cartService.getProductsInCart(cartByUserId.getId());
            for (Product product : productsInCart) {
                sum += product.getPrice();
            }

            if (!productsInCart.isEmpty()) {
                modelMap.addAttribute("productInCart", productsInCart);
                modelMap.addAttribute("sum", sum);
                modelMap.addAttribute("cart", cartByUserId);
            }
        }
        return "orderPage";
    }

    @PostMapping("/add")
    public String addProduct(@AuthenticationPrincipal CurrentUser currentUser,
                             @RequestParam("id") int cartId) {
        orderService.saveOrder(cartId, currentUser.getUser());

        return "redirect:/orders";
    }
}
