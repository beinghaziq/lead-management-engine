package com.example.haziq.lead_managemanet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class LeadManagemanetApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeadManagemanetApplication.class, args);
	}
  @Configuration
  public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }

  }

}
