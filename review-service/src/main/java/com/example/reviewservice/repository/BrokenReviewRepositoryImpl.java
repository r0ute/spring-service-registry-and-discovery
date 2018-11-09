package com.example.reviewservice.repository;

import com.example.reviewservice.model.Review;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("brokenReviewRepository")
public class BrokenReviewRepositoryImpl implements ReviewRepository {

    @Override
    public List<Review> getReviews() {
        throw new UnsupportedOperationException("Sorry, not today.");
    }
}
