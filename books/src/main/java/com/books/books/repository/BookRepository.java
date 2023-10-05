package com.books.books.repository;

import com.books.books.entity.Author;
import com.books.books.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAllByActiveTrue(Pageable page);

    Optional<Book> findByIdAndActiveTrue(Long id);
}
