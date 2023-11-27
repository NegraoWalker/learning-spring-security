package com.walker.learningspringsecurity.repository;

import com.walker.learningspringsecurity.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
