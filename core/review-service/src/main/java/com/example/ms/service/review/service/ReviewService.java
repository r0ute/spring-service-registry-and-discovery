package com.example.ms.service.review.service;

import com.example.ms.service.review.dto.ReviewSearchRequest;
import com.example.ms.service.review.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> getReviews(ReviewSearchRequest request);
}
