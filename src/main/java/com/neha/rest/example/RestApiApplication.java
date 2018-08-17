package com.neha.rest.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.neha.rest.example.model.Student;
import com.neha.rest.example.repository.StudentRepository;

@SpringBootApplication
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(StudentRepository repository){
		return args -> {
			repository.save(new Student("Jane", "Doe", "Junior"));
			repository.save(new Student("Martin", "Fowler", "Senior"));
			repository.save(new Student("Roy", "Fielding", "Freshman"));
		};
	}
}
