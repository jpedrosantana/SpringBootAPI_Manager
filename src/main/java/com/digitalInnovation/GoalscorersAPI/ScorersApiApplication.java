package com.digitalInnovation.GoalscorersAPI;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class ScorersApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScorersApiApplication.class, args);
		System.out.println("Top goal scorers server is running...");
	}

}
