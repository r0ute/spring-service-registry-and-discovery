package com.example.reviewservice.model;

import java.util.UUID;

public class Review {

    private UUID id;

    private String text;

    private UUID productId;

    public Review(UUID id, String text, UUID productId) {
        this.id = id;
        this.text = text;
        this.productId = productId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }
}
