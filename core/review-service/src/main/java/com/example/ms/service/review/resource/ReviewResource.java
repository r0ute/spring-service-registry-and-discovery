package com.example.ms.service.review.resource;

import com.example.ms.service.review.dto.ReviewSearchRequest;
import com.example.ms.service.review.service.ReviewService;
import com.example.ms.service.review.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reviews")
public class ReviewResource {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews(ReviewSearchRequest request) {
        return reviewService.getReviews(request);
    }
}
