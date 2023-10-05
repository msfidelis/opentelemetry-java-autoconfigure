package com.books.books.service;


import com.books.books.dto.AuthorDTOResponse;
import com.books.books.dto.AuthorUpdateRequest;
import com.books.books.entity.Author;
import com.books.books.repository.AuthorRepository;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository repository;

    @WithSpan
    public Author createAuthor(Author author) {
        repository.save(author);
        return author;
    }

    @WithSpan
    public Author updateAuthor(Author author, AuthorUpdateRequest body) {
        if (body.birth() != null) {
            author.setBirth(body.birth());
        }
        if (body.location() != null) {
            author.setLocation(body.location());
        }
        return author;
    }

    @WithSpan
    public Page<AuthorDTOResponse> listAuthor(Pageable page) {
        return repository.findAllByActiveTrue(page).map(AuthorDTOResponse::new);
    }

    @WithSpan
    public Author getAuthor(Long id) {
        Author author = repository.findByIdAndActiveTrue(id).orElse(null);
        return author;
    }

    @WithSpan
    public void disableAuthor(Long id) {
        Author author = repository.getReferenceById(id);
        author.setActive(false);
    }

}
