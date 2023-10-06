package com.review.review.dto;

import com.review.review.entity.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ReviewCreateRequest(
        @NotBlank
        String review,

        @Min(value = 0)
        @Max(value = 5)
        Float rate,

        @Min(value = 1)
        Long book_id)
{
}
