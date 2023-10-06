package com.review.review.requests;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "bookClient", url = "http://0.0.0.0:9000")
public interface BookClient {

    @GetMapping("/books/{id}")
    BookResponse getBookById(@PathVariable("id") Long id);

}
