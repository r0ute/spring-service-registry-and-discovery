package com.example.reviewservice.resource;

import com.example.reviewservice.model.Review;
import com.example.reviewservice.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewResource {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getReviews() {
        return reviewService.getReviews();
    }
}
