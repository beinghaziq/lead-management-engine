package com.example.haziq.lead_managemanet.repositories;

import com.example.haziq.lead_managemanet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
  @Query("SELECT u FROM users u WHERE u.auth_token = :authToken")
  User findByAuthToken(@Param("authToken") String authToken);
}
