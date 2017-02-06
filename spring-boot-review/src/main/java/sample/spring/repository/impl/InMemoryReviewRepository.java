package sample.spring.repository.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

import sample.spring.domain.Review;
import sample.spring.repository.ReviewRepository;

@Repository
public class InMemoryReviewRepository implements ReviewRepository {
	private Map<String, Review> listOfReviews;

	public InMemoryReviewRepository() {
		listOfReviews = new HashMap<String, Review>();
	}

	@Override
	public Review create(Review review) {
		if (listOfReviews.keySet().contains(review.getId())) {
			throw new IllegalArgumentException(
					String.format(
							"Can not create a review. A review with the give id (%) already exist",
							review.getId()));
		}
		
		listOfReviews.put(review.getId(), review);
		
		return review;
	}

	@Override
	public Review read(String reviewId) {
		return listOfReviews.get(reviewId);
	}

	@Override
	public void update(String reviewId, Review review) {
		if (!listOfReviews.keySet().contains(reviewId)) {
			throw new IllegalArgumentException(
					String.format(
							"Can not update review. The review with the give id (%) does not does not exist",
							reviewId));
		}
		listOfReviews.put(reviewId, review);
	}

	@Override
	public void delete(String reviewId) {
		if (!listOfReviews.keySet().contains(reviewId)) {
			throw new IllegalArgumentException(
					String.format(
							"Can not delete review. The review with the give id (%) does not does not exist",
							reviewId));
		}
		
		listOfReviews.remove(reviewId);
	}

	@Override
	public Collection<Review> getAll() {
		return listOfReviews.values();
	}
}
