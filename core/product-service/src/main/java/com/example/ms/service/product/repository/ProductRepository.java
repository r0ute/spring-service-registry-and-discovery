package com.example.ms.service.product.repository;

import com.example.ms.service.product.model.Product;

import java.util.List;
import java.util.UUID;

public interface ProductRepository {

    List<Product> getProducts();

    Product getProduct(UUID id);
}
