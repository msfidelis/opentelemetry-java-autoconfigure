package com.review.review.dto;

import com.review.review.entity.Review;
import io.opentelemetry.instrumentation.annotations.WithSpan;

public record ReviewListResponse(
        Long id,
        Float rate,
        String review
) {
    @WithSpan
    public ReviewListResponse(Review review) {
        this(review.getId(), review.getRate(), review.getReview());
    }
}
