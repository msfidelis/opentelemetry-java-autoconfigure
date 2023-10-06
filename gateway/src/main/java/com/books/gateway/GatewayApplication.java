package com.books.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

	@Value("${books.endpoint}")
	private String booksURI;

	@Value("${reviews.endpoint}")
	private String reviewsURI;

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routers(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/books/**").filters(f -> f.prefixPath("/")).uri(booksURI))
				.route(r -> r.path("/author/**").filters(f -> f.prefixPath("/")).uri(booksURI))
				.route(r -> r.path("/reviews/**").filters(f -> f.prefixPath("/")).uri(reviewsURI))
				.build();
	}
}
