package sample.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sample.spring.domain.Review;
import sample.spring.repository.ReviewRepository;

@SpringBootApplication
public class SpringBootReviewApplication {

	@Bean
	InitializingBean saveData(ReviewRepository repo){
		return new InitializingBean() {
			@Override
			public void afterPropertiesSet() throws Exception {
				repo.create(new Review("R001","Get to know Spring Boot","Today I will learn Spring Boot","01/01/2016"));
				repo.create(new Review("R002","Simple Spring Boot Project","I will do my first Spring 	Boot Project","01/02/2016"));
				repo.create(new Review("R003", "Spring Boot Reading","Read more about Spring Boot","02/01/2016"));
				repo.create(new Review("R004", "Spring Boot in the Cloud","Spring Boot using Cloud Foundry","03/01/2016"));
				
			}
		};
	}
	

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootReviewApplication.class, args);
	}
}
