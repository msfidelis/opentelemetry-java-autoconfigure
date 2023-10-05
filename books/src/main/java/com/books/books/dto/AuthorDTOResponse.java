package com.books.books.dto;

import com.books.books.entity.Author;
import io.opentelemetry.instrumentation.annotations.WithSpan;

public record AuthorDTOResponse(
        Long id,
        String name,
        String location,
        Integer birthr
) {
    @WithSpan
    public AuthorDTOResponse(Author author) {
        this(author.getId(), author.getName(), author.getLocation(), author.getBirth());
    }
}
