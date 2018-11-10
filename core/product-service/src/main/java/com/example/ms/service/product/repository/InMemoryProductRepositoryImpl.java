package com.example.ms.service.product.repository;

import com.example.ms.service.product.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class InMemoryProductRepositoryImpl implements ProductRepository {

    private static final List<Product> products = Collections.unmodifiableList(Arrays.asList(
            new Product(UUID.fromString("b1d21097-b4d3-4c82-b5fa-67295e92f5be"), "foo", "foo desc"),
            new Product(UUID.fromString("f0293680-0bea-4800-b151-20df8b223894"), "bar", "bar desc")
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product getProduct(UUID id) {
        return products.stream()
                .filter(product -> Objects.equals(product.getId(), id))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
