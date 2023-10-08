package com.review.review.entity;


import com.review.review.dto.ReviewCreateRequest;
import jakarta.persistence.*;
import lombok.*;


@Table(name = "review")
@Entity(name = "review")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float rate;

    private Long idBook;

    private String review;

    private Boolean active;

    public Review(ReviewCreateRequest review) {
        this.active = true;
        this.rate = review.rate();
        this.idBook = review.book_id();
        this.review = review.review();
    }
}
