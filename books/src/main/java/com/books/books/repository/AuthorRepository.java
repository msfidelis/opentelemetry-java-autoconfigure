package com.books.books.repository;

import com.books.books.dto.AuthorDTOResponse;
import com.books.books.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Page<Author> findAllByActiveTrue(Pageable page);

    Optional<Author> findByIdAndActiveTrue(Long id);
}
