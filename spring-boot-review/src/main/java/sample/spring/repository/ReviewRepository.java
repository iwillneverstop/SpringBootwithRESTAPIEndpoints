package sample.spring.repository;

import java.util.Collection;

import sample.spring.domain.Review;

public interface ReviewRepository {

	Review create(Review review);
	Review read(String reviewId);
	void update(String reviewId, Review cart);
	void delete(String reviewId);
	
	Collection<Review> getAll();
}