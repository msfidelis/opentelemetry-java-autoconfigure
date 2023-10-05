package com.books.books.controller;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @PostMapping
    @Transactional
    public void create() {

    }

    @GetMapping
    public void list() {

    }

    @GetMapping("/{id}")
    public void detail() {

    }

    @PutMapping("/{id}")
    public void update() {

    }

    @DeleteMapping("/{id}")
    public void delete() {

    }

}
