package com.example.autopartsstore.service.impl;

import com.example.autopartsstore.entity.Cart;
import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.entity.User;
import com.example.autopartsstore.repository.CartRepository;
import com.example.autopartsstore.repository.ProductRepository;
import com.example.autopartsstore.service.CartService;
import com.example.autopartsstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final ProductService productService;
    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    @Override
    public void addToCart(List<Integer> products, User currentUser) {
        int id = currentUser.getId();
        Cart cart = cartRepository.findByUser_Id(id);
        if (cart == null) {
            cart = new Cart();
            cart.setUser(currentUser);
        }

        if (products != null && !products.isEmpty()) {
            List<Product> productList = new ArrayList<>();
            for (Integer productId : products) {
                Optional<Product> byId = productRepository.findById(productId);
                if (byId.isPresent()) {
                    productList.add(byId.get());
                }
            }
            cart.setProductList(productList);
        }
        cartRepository.save(cart);
    }

    @Override
    public Cart getCartByUserId(int userId) {
        return cartRepository.findByUser_Id(userId);
    }

    @Override
    public void crateCart(Cart cart) {
        cartRepository.save(cart);
    }


    @Override
    public List<Product> getProductsInCart(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        return cart.getProductList();
    }

    @Override
    public void emptyCart(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cartRepository.delete(cart);
    }
}
