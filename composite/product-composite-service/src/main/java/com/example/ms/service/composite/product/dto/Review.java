package com.example.ms.service.composite.product.dto;

import java.util.UUID;

public class Review {

    private UUID id;

    private String text;

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
}
