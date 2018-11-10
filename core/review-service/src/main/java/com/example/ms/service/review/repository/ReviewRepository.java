package com.example.ms.service.review.repository;

import com.example.ms.service.review.dto.ReviewSearchRequest;
import com.example.ms.service.review.model.Review;

import java.util.List;

public interface ReviewRepository {

    List<Review> getReviews(ReviewSearchRequest request);
}
