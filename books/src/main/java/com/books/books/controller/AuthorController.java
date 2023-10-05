package com.books.books.controller;

import com.books.books.dto.AuthorCreateRequest;
import com.books.books.dto.AuthorDTOResponse;
import com.books.books.dto.AuthorUpdateRequest;
import com.books.books.entity.Author;
import com.books.books.service.AuthorService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody AuthorCreateRequest body) {
        System.out.println(body);
        Author author = authorService.createAuthor(new Author(body));
        return new ResponseEntity(author, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity list(Pageable page) {
        Page<AuthorDTOResponse> authors = authorService.listAuthor(page);
        return new ResponseEntity(authors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable("id") Long id) {
        Author author = authorService.getAuthor(id);
        if (author == null) {
            return new ResponseEntity((HttpStatus.NO_CONTENT));
        }
        AuthorDTOResponse response = new AuthorDTOResponse(author);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable("id") Long id, @Valid @RequestBody AuthorUpdateRequest body) {
        Author author = authorService.getAuthor(id);
        if (author == null) {
            return new ResponseEntity((HttpStatus.NO_CONTENT));
        }
        Author newAuthor = authorService.updateAuthor(author, body);
        return new ResponseEntity(newAuthor, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable("id") Long id) {
        Author author = authorService.getAuthor(id);
        if (author != null) {
            authorService.disableAuthor(id);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

}
