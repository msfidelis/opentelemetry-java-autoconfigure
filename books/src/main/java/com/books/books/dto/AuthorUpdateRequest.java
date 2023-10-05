package com.books.books.dto;

import jakarta.validation.constraints.*;

import java.time.Year;

public record AuthorUpdateRequest(
        @Min(value = 1800)
        @Max(value = Year.MAX_VALUE)
        Integer birth,

        @NotBlank
        String location
) {
}
