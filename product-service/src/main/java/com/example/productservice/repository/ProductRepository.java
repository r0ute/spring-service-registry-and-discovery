package com.example.productservice.repository;

import com.example.productservice.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();
}
