package com.walker.learningspringsecurity.controller;

import com.walker.learningspringsecurity.entity.Product;
import com.walker.learningspringsecurity.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor //Injeção de dependências via construtor
public class ProductController {
    private final ProductService productService;
    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Product> findAllProducts(){
        return productService.findAll();
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public Product createProducts(@RequestBody Product product){
        return productService.create(product);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Product updateProducts(@RequestBody Product product){
        return productService.update(product);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void deleteProducts(@RequestParam("id") Long id){
        productService.delete(id);
    }
}
