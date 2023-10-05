package com.books.books.dto;

import com.books.books.entity.Author;
import com.books.books.entity.Book;
import io.opentelemetry.instrumentation.annotations.WithSpan;

public record BookDTOResponse(Long id, String name, Integer year, Author author)
{

    @WithSpan
    public BookDTOResponse(Book book) {
        this(book.getId(), book.getName(), book.getYear(), book.getAuthor());
    }

}
