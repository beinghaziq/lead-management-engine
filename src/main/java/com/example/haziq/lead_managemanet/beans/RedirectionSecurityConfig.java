package com.example.haziq.lead_managemanet.beans;

import com.example.haziq.lead_managemanet.filters.CustomAuthenticationFilter;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class RedirectionSecurityConfig {

  private final UserRepository userRepository;

  @Autowired
  public RedirectionSecurityConfig(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable());
    http.authorizeRequests().anyRequest().permitAll();

    http.addFilterBefore(new CustomAuthenticationFilter(userRepository), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }

}
