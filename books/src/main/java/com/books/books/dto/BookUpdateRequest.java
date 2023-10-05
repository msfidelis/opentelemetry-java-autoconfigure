package com.books.books.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.Year;

public record BookUpdateRequest(

        String name,

        @Nullable
        @Min(value = 1800)
        @Max(value = Year.MAX_VALUE)
        Integer year,

        @Nullable
        @Min(value = 1)
        Long author_id
) {
}
