package com.example.reviewservice.repository;

import com.example.reviewservice.model.Review;

import java.util.List;

public interface ReviewRepository {

    List<Review> getReviews();
}
