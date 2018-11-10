package com.example.ms.service.composite.product.resource;

import com.example.ms.service.composite.product.dto.Product;
import com.example.ms.service.composite.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Mono<Product> getProduct(@PathVariable UUID id) {
        return productService.getProduct(id);
    }
}
