package com.example.ms.service.review.service;

import com.example.ms.service.review.model.Review;
import com.example.ms.service.review.repository.ReviewRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    @Qualifier("reviewRepository")
    private ReviewRepository reviewRepository;

    @Autowired
    @Qualifier("brokenReviewRepository")
    private ReviewRepository brokenReviewRepository;

    @Override
    @HystrixCommand(fallbackMethod = "getEmptyReviews")
    public List<Review> getReviews() {
        if (LocalDateTime.now().getMinute() % 2 == 0) {
            return brokenReviewRepository.getReviews();
        } else {
            return reviewRepository.getReviews();
        }
    }

    public List<Review> getEmptyReviews() {
        return Collections.emptyList();
    }
}
