package com.walker.learningspringsecurity.service;

import com.walker.learningspringsecurity.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> findAll();
    Product create(Product product);
    Product update(Product product);
    void delete(Long id);
}
