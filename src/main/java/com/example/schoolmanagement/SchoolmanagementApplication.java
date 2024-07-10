package com.example.schoolmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.example.schoolmanagement.model")
@EnableJpaRepositories(basePackages = "com.example.schoolmanagement.repository")
public class SchoolmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchoolmanagementApplication.class, args);
	}

}
