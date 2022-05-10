package com.amith.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amith.springcloud.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
