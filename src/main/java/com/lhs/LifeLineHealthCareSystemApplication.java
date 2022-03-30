package com.lhs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LifeLineHealthCareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LifeLineHealthCareSystemApplication.class, args);

		// nrew vcjd
		// new change in master

	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
