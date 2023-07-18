package com.example.haziq.lead_managemanet.repositories;

import com.example.haziq.lead_managemanet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
  User findByEmail(String email);
}
