package com.college_predict;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
@EntityScan(basePackages = "com.college_predict.model")
public class CollegePredictApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegePredictApplication.class, args);
	}

}
