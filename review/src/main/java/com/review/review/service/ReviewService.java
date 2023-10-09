package com.review.review.service;

import com.review.review.dto.ReviewListResponse;
import com.review.review.entity.Review;
import com.review.review.repository.ReviewRepository;
import com.review.review.requests.BookClient;
import com.review.review.requests.BookResponse;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @CacheEvict(value = "Reviews", key = "#review.idBook")
    public Review create(@SpanAttribute("review") Review review) {
        repository.save(review);
        return review;
    }

    @WithSpan
    public BookResponse fetchBook(@SpanAttribute("id_book") Long id_book) {
        try {
            return bookClient.getBookById(id_book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @WithSpan
    @Cacheable(value = "Reviews", key = "#id_book")
    public List<Review> getReviews(@SpanAttribute("id_book") Long id_book) {
        List<Review> reviews = repository.findByIdBook(id_book);
        return reviews;
    }

}
