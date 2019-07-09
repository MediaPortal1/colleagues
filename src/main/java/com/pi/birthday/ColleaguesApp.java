package com.pi.birthday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
public class ColleaguesApp {

	public static void main(String[] args) {
		SpringApplication.run(ColleaguesApp.class, args);
	}

	@Bean
	public BCryptPasswordEncoder provideEncoder(){
		return new BCryptPasswordEncoder();
	}
}
