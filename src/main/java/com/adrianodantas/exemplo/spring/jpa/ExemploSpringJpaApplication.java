package com.adrianodantas.exemplo.spring.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.adrianodantas.exemplo.spring.jpa.entity.Course;
import com.adrianodantas.exemplo.spring.jpa.repository.CourseRepository;

@SpringBootApplication
public class ExemploSpringJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExemploSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("findAll() -> {}", courseRepository.findAll());
		
		logger.info("save() -> {}", courseRepository.save(new Course(null, "C# Design Patterns")));
	}
}
