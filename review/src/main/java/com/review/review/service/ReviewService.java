package com.review.review.service;

import com.review.review.entity.Review;
import com.review.review.repository.ReviewRepository;
import com.review.review.requests.BookClient;
import com.review.review.requests.BookResponse;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository repository;

    @Autowired
    private BookClient bookClient;

    @WithSpan
    public Review create(Review review) {
        repository.save(review);
        return review;
    }

    @WithSpan
    public BookResponse fetchBook(Long id_book) {
        try {
            return bookClient.getBookById(id_book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
