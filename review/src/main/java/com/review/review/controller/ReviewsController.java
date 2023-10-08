package com.review.review.controller;

import com.review.review.dto.ErrorResponse;
import com.review.review.dto.ReviewCreateRequest;
import com.review.review.dto.ReviewListResponse;
import com.review.review.entity.Review;
import com.review.review.requests.BookResponse;
import com.review.review.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity create(@RequestBody ReviewCreateRequest body) {
        BookResponse book = reviewService.fetchBook(body.book_id());

        if (book == null) {
            ErrorResponse error = new ErrorResponse(HttpStatus.BAD_REQUEST, "Book " + body.book_id() + " not found");
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }

        Review review = reviewService.create(new Review(body));
        return new ResponseEntity(review, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity detail(@RequestParam("book") Long book_id) {
        List<Review> reviews = reviewService.getReviews(book_id);
        List<ReviewListResponse> response = reviews
                .stream()
                .map(ReviewListResponse::new)
                .collect(Collectors.toList());
        return new ResponseEntity(response, HttpStatus.OK);
    }


}
