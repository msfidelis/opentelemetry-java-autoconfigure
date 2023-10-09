package com.review.review.dto;

import io.opentelemetry.instrumentation.annotations.SpanAttribute;
import org.springframework.http.HttpStatus;

public record ErrorResponse(@SpanAttribute("status") HttpStatus status, @SpanAttribute("message") String message) {
}
