package com.example.haziq.lead_managemanet.repositories;

import com.example.haziq.lead_managemanet.enums.RoleName;
import com.example.haziq.lead_managemanet.models.Role;
import com.example.haziq.lead_managemanet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static com.example.haziq.lead_managemanet.enums.RoleName.SuperAdmin;

public interface UserRepository extends JpaRepository<User, Integer> {
}
