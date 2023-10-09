package com.review.review.repository;

import com.review.review.entity.Review;
import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByIdBook(@SpanAttribute("id_book") Long id_book);

}
