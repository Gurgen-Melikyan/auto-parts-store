package com.example.autopartsstore.service.impl;

import com.example.autopartsstore.entity.Product;
import com.example.autopartsstore.entity.User;
import com.example.autopartsstore.repository.ProductRepository;
import com.example.autopartsstore.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.io.File;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Value("${autoPartsStore.upload.image.path}")
    private String imageUploadPath;

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
//        Optional<Product> byId = productRepository.findById(id);
//        if (byId.isEmpty()) {
//            return null;
//        }
//        return byId;
        return productRepository.findById(id);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public void addProduct(User currentUser, MultipartFile multipartFile, Product product) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            String fileName = System.nanoTime() + "_" + multipartFile.getOriginalFilename();
            File file = new File(imageUploadPath + fileName);
            multipartFile.transferTo(file);
            product.setImgName(fileName);
        }
        product.setUser(currentUser);
        productRepository.save(product);
    }


    @Override
    public void deleteById(int id) {
        productRepository.deleteById(id);
    }
}
