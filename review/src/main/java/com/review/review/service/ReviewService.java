package com.review.review.service;

import com.review.review.dto.ReviewListResponse;
import com.review.review.entity.Review;
import com.review.review.repository.ReviewRepository;
import com.review.review.requests.BookClient;
import com.review.review.requests.BookResponse;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<Review> getReviews(Long id_book) {
        List<Review> reviews = repository.findByIdBook(id_book);
        return reviews;
    }

}
