package com.example.productservice.repository;

import com.example.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {

    private static List<Product> products = Arrays.asList(
            new Product(UUID.randomUUID(), "foo", "foo desc"),
            new Product(UUID.randomUUID(), "bar", "bar desc")
    );


    public List<Product> getProducts() {
        return products;
    }
}
