package com.review.review.repository;

import com.review.review.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//    Page<Review> findAllByActiveTrue(Pageable page);
//
//    Page<Review> findAllByIdBook(Long id);

}
