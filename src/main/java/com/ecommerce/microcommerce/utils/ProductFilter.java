package com.ecommerce.microcommerce.utils;

import com.ecommerce.microcommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;

import java.util.List;

public class ProductFilter {

    public static MappingJacksonValue produitsFilters(List<Product> produits) {
        SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listFilter = new SimpleFilterProvider().addFilter("myDynamicFilter", myFilter);
        MappingJacksonValue produitsFilters = new MappingJacksonValue(produits);
        produitsFilters.setFilters(listFilter);
        return produitsFilters;
    }

    public static MappingJacksonValue produitsFilters(Product produit) {
        SimpleBeanPropertyFilter myFilter = SimpleBeanPropertyFilter.serializeAllExcept("prixAchat");
        FilterProvider listFilter = new SimpleFilterProvider().addFilter("myDynamicFilter", myFilter);
        MappingJacksonValue produitsFilters = new MappingJacksonValue(produit);
        produitsFilters.setFilters(listFilter);
        return produitsFilters;
    }
}
