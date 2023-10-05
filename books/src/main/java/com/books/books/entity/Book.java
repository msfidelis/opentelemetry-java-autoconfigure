package com.books.books.entity;

import com.books.books.dto.AuthorCreateRequest;
import com.books.books.dto.BookCreateRequest;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "book")
@Entity(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer year;
    private Long author_id;
    private Boolean active;

    @WithSpan
    public Book(BookCreateRequest book) {
        this.active = true;
        this.name = book.name();
        this.year = book.year();
        this.author_id = book.author_id();
    }

}
