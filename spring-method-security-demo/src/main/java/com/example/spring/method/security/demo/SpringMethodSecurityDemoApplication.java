package com.example.spring.method.security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;

@SpringBootApplication
@EnableGlobalAuthentication
public class SpringMethodSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMethodSecurityDemoApplication.class, args);
	}

}
