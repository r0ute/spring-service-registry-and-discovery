package com.example.ms.service.composite.product.service;

import com.example.ms.service.composite.product.dto.Product;
import com.example.ms.service.composite.product.dto.Review;
import com.example.ms.service.composite.product.filter.LogRequestFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService {

    public static final String PRODUCT_SERVICE_ID = "product-service";

    public static final String REVIEW_SERVICE_ID = "review-service";

    @Autowired
    private LoadBalancerExchangeFilterFunction lbFunction;

    @Autowired
    private LogRequestFilter logRequestFilter;

    @Override
    public Mono<Product> getProduct(UUID id) {
        Mono<Product> product = WebClient.builder()
                .baseUrl("http://" + PRODUCT_SERVICE_ID)
                .filter(lbFunction)
                .filter(logRequestFilter)
                .build()
                .get()
                .uri("/products/{productId}", id)
                .retrieve()
                .bodyToMono(Product.class);

        Flux<Review> reviews = WebClient.builder()
                .baseUrl("http://" + REVIEW_SERVICE_ID)
                .filter(lbFunction)
                .filter(logRequestFilter)
                .build()
                .get()
                .uri("/reviews")
                .attribute("productId", id)
                .retrieve()
                .bodyToFlux(Review.class);

        return reviews.collectList()
                .zipWith(product, (reviews1, product1) -> {
                    product1.setReviews(reviews1);

                    return product1;
                }).doOnError(Throwable::printStackTrace);
    }
}
