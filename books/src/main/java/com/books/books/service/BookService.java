package com.books.books.service;

import com.books.books.dto.AuthorDTOResponse;
import com.books.books.dto.BookDTOResponse;
import com.books.books.dto.BookUpdateRequest;
import com.books.books.entity.Author;
import com.books.books.entity.Book;
import com.books.books.repository.BookRepository;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private AuthorService authorService;

    @WithSpan
    public Book create(Book book) {
        repository.save(book);
        return book;
    }

    public Book update(Book book, BookUpdateRequest body) {
        if (body.year() != null) {
            book.setYear(body.year());
        }
        if (body.name() != null) {
            book.setName(body.name());
        }
        if (body.author_id() != null) {
            Author author = authorService.getAuthor(body.author_id());
            book.setAuthor(author);
        }
        return book;
    }

    @WithSpan
    public Page<BookDTOResponse> list(Pageable page) {
        return repository.findAllByActiveTrue(page).map(BookDTOResponse::new);
    }

    @WithSpan
    public Book getBook(Long id) {
        Book book = repository.findByIdAndActiveTrue(id).orElse(null);
        return book;
    }

    public void disable(Long id) {
        Book book = repository.getReferenceById(id);
        book.setActive(false);
    }
}
