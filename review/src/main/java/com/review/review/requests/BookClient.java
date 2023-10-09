package com.review.review.requests;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "bookClient", url = "${reviews.books.endpoint}")
public interface BookClient {

    @WithSpan
    @GetMapping("/books/{id}")
    BookResponse getBookById(@PathVariable("id") Long id);

}
