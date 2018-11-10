package com.example.ms.service.review.dto;

import java.util.UUID;

public class ReviewSearchRequest {

    private UUID productId;

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
}
