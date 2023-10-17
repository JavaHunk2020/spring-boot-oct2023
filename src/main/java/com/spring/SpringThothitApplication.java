package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringThothitApplication implements CommandLineRunner {
	
	//it is used to pull the bean and assign over here
	@Autowired
	BizService bizService;

	public static void main(String[] args) {
		SpringApplication.run(SpringThothitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		bizService.foo();
	}

}
