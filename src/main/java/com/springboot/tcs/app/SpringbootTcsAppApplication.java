package com.springboot.tcs.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages= {"com.springboot.tcs.app"})
public class SpringbootTcsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootTcsAppApplication.class, args);
	}

}
