package com.books.books.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.Year;

public record BookCreateRequest(
        @NotBlank
        String name,

        @Min(value = 1800)
        @Max(value = Year.MAX_VALUE)
        Integer year,

        @NotBlank
        Long author_id

) {
}
