package com.example.ms.service.composite.product.service;

import com.example.ms.service.composite.product.dto.Product;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProductService {

    Mono<Product> getProduct(UUID id);
}
