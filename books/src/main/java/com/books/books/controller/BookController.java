package com.books.books.controller;

import brave.Response;
import com.books.books.dto.AuthorDTOResponse;
import com.books.books.dto.BookCreateRequest;
import com.books.books.dto.BookDTOResponse;
import com.books.books.dto.BookUpdateRequest;
import com.books.books.entity.Author;
import com.books.books.entity.Book;
import com.books.books.service.AuthorService;
import com.books.books.service.BookService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody BookCreateRequest body) {
        System.out.println(body);

        Book book = new Book(body);

        // Find Author to Join
        Author author = authorService.getAuthor(body.author_id());
        book.setAuthor(author);

        Book newBook = bookService.create(book);
        return new ResponseEntity(newBook, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity list(Pageable page) {
        Page<BookDTOResponse> books = bookService.list(page);
        return new ResponseEntity(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        if (book == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        BookDTOResponse response = new BookDTOResponse(book);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody BookUpdateRequest body) {
        Book book = bookService.getBook(id);
        if (book == null) {
            return new ResponseEntity((HttpStatus.NO_CONTENT));
        }
        Book updatedBook = bookService.update(book, body);
        return new ResponseEntity(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Book book = bookService.getBook(id);
        if (book != null) {
            bookService.disable(id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
