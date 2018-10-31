package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.repository.ProductRepository;
import com.ecommerce.microcommerce.utils.ProductFilter;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    //Produits
    @GetMapping(value = "Produits")
    public MappingJacksonValue listProduits() {
        List<Product> produits = productRepository.findAll();
        return ProductFilter.produitsFilters(produits);
    }

    //Produits/{id}
    @GetMapping(value = "Produits/{id}")
    public ResponseEntity<MappingJacksonValue> afficherProduit(@PathVariable int id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(ProductFilter.produitsFilters(product));
    }

    @PostMapping(value = "Produits")
    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
        Product product1 = productRepository.save(product);
        if (product1 == null) {
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product1.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
