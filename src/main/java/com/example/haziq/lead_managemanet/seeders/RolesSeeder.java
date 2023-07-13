package com.example.haziq.lead_managemanet.seeders;

import com.example.haziq.lead_managemanet.models.Role;
import com.example.haziq.lead_managemanet.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.example.haziq.lead_managemanet.enums.RoleName.*;

@Component
public class RolesSeeder implements CommandLineRunner {

  @Autowired
  RoleRepository roleRepository;

  @Override
  public void run(String... args) throws Exception {
    createRoles();
  }

  private void createRoles() {
    if (roleRepository.count() == 0) {
      Role businessDeveloper = new Role(1, BuisnessDeveloper);
      Role superAdmin = new Role(2, SuperAdmin);
      Role engineer = new Role(3, Engineer);
      Role technicalManager = new Role(4, TechnicalManager);
      roleRepository.save(superAdmin);
      roleRepository.save(businessDeveloper);
      roleRepository.save(engineer);
      roleRepository.save(technicalManager);
    }
    System.out.println(roleRepository.count());
  }
}
