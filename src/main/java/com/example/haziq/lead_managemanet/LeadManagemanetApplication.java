package com.example.haziq.lead_managemanet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)

public class LeadManagemanetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagemanetApplication.class, args);
	}
}
