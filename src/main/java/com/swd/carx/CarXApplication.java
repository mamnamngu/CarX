package com.swd.carx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.swd.carx.config.FirebaseService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableScheduling
@EnableWebMvc
public class CarXApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarXApplication.class, args);
//		FirebaseService.writeToDatabase();
	}

}
