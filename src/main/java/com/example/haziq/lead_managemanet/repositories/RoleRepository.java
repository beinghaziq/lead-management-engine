package com.example.haziq.lead_managemanet.repositories;

import com.example.haziq.lead_managemanet.enums.RoleName;
import com.example.haziq.lead_managemanet.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
  Optional<Role> findByName(RoleName roleName);
}
