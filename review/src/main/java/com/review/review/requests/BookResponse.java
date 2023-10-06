package com.review.review.requests;

import lombok.Getter;
import lombok.Setter;

public class BookResponse {
    private Long id;
    private String name;
    private int year;
    private Author author;

    // getters, setters e possivelmente construtores, equals(), hashCode(), toString()

    @Getter
    @Setter
    public static class Author {
        private Long id;
        private String name;
        private String location;
        private int birth;
        private boolean active;
    }
}
