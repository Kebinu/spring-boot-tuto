package com.ecommerce.microcommerce.repository;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    public static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Ordinateur portable", 350, 200));
        products.add(new Product(2, "Aspirateur robot", 500, 150));
        products.add(new Product(3, "Table de ping-pong", 750, 350));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        Optional<Product> product = products.stream().filter(p -> p.getId() == id).findFirst();
        if (product.isPresent()) {
            return product.get();
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
