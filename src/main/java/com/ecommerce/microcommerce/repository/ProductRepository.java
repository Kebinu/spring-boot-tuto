package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> findAll();
    Product findById(int id);
    Product save(Product product);
}
