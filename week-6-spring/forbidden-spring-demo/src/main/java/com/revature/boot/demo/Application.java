package com.revature.boot.demo;

import com.revature.boot.demo.entities.DirectorRepository;
import com.revature.boot.demo.entities.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
