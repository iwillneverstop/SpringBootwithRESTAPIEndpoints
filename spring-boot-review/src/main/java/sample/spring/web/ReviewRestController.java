package sample.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sample.spring.domain.Review;
import sample.spring.repository.ReviewRepository;

@Controller
@RequestMapping(value = "reviewsapi/v1.0/reviews")
public class ReviewRestController {

	@Autowired
	ReviewRepository repo;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?>  getReviews(){
		return new ResponseEntity<>(repo.getAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> create(@RequestBody Review review){
		
		try{
			Review oReview = repo.create(review);
			return new ResponseEntity<>(oReview, HttpStatus.CREATED);
		} catch (IllegalArgumentException oEx){
			return new ResponseEntity<>("Duplicate reivew ID found", HttpStatus.CONFLICT);
		}
	}
	
	@RequestMapping(value ="/{reviewid}", method = RequestMethod.GET)
	public ResponseEntity<?> read(@PathVariable(value = "reviewid") String reviewid){
		
		Review oReview = repo.read(reviewid);
		if(oReview != null){
			return new ResponseEntity<>(oReview, HttpStatus.OK);
		} 
		
		return new ResponseEntity<>("No review with that ID found", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/{reviewid}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable(value = "reviewid") String reviewid, @RequestBody Review review) {
		try{
			repo.update(reviewid, review);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException oEx){
			return new ResponseEntity<>("No review with that ID found", HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value ="/{reviewid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable(value = "reviewid") String reviewid){
		try{
			repo.delete(reviewid);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (IllegalArgumentException oEx){
			return new ResponseEntity<>("No review with that ID found", HttpStatus.NOT_FOUND);
		}
	}
	
	
	
	
	
	
}
