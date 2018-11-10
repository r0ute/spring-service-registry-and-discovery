package com.example.ms.service.product.resource;

import com.example.ms.service.product.model.Product;
import com.example.ms.service.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @GetMapping("/{id")
    public Product getProduct(@RequestParam UUID id) {
        return productRepository.getProduct(id);
    }
}
