package com.books.books.entity;

import com.books.books.dto.AuthorCreateRequest;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "author")
@Entity(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Author {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
        private String location;
        private Integer birth;
        private Boolean active;

        @WithSpan
        public Author(AuthorCreateRequest author) {
                this.active = true;
                this.name = author.name();
                this.location = author.location();
                this.birth = author.birth();
        }

        @WithSpan
        public void delete() {
                this.active = false;
        }

}
