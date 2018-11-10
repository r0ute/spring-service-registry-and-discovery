package com.example.ms.service.review.repository;

import com.example.ms.service.review.dto.ReviewSearchRequest;
import com.example.ms.service.review.model.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
@Qualifier("reviewRepository")
public class InMemoryReviewRepositoryImpl implements ReviewRepository {

    private static final List<Review> reviews = Collections.unmodifiableList(Arrays.asList(
            new Review(UUID.fromString("60dfb450-3786-49df-95e1-c6efb2a42058"), "huh", UUID.fromString("b1d21097-b4d3-4c82-b5fa-67295e92f5be")),
            new Review(UUID.fromString("b8ac7ef1-0673-4c40-831d-2c5af208a7a8"), "yeap", UUID.fromString("b1d21097-b4d3-4c82-b5fa-67295e92f5be")),
            new Review(UUID.fromString("86dc65dc-9d65-4423-92c4-4e56e4f94df6"), "nope", UUID.fromString("f0293680-0bea-4800-b151-20df8b223894"))
    ));

    @Override
    public List<Review> getReviews(ReviewSearchRequest request) {
        return reviews.stream()
                .filter(review -> request.getProductId() == null || Objects.equals(request.getProductId(), review.getProductId()))
                .collect(Collectors.toList());
    }
}
