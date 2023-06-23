package com.example.autopartsstore.controller;


import com.example.autopartsstore.entity.Category;
import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.security.CurrentUser;
import com.example.autopartsstore.service.CategoryService;
import com.example.autopartsstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping()
    public String ProductsPage(
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size,
            ModelMap modelMap) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Sort sort = Sort.by(Sort.Order.desc("id"));
        Pageable pageable = PageRequest.of(currentPage - 1, pageSize, sort);

        Page<Product> result = productService.findAll(pageable);
        int totalPages = result.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            modelMap.addAttribute("pageNumbers", pageNumbers);
        }
        modelMap.addAttribute("products", result);
        return "products";
    }


    @GetMapping("/add")
    public String addProductPage(ModelMap modelMap) {
        List<Category> allCategories = categoryService.findAllCategories();
        modelMap.addAttribute("categories",allCategories);
        return "addProduct";
    }


    @PostMapping("/add")
    public String addCategory(@AuthenticationPrincipal CurrentUser currentUser,
                              @ModelAttribute Product product,
                              @RequestParam("image") MultipartFile multipartFile) throws IOException {
        productService.addProduct(currentUser.getUser(),multipartFile,product);
        return "redirect:/products";
    }



    @GetMapping("/remove")
    public String removeProduct(@RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/products";
    }
}
