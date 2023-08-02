package com.example.haziq.lead_managemanet.controllers;

import com.example.haziq.lead_managemanet.adapters.LeadAdapter;
import com.example.haziq.lead_managemanet.models.Lead;
import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.ClientDetailsRepository;
import com.example.haziq.lead_managemanet.repositories.LeadRepository;
import com.example.haziq.lead_managemanet.repositories.UserRepository;
import com.example.haziq.lead_managemanet.request_bodies.LeadAndClientDetails;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeadsController {
  private ClientDetailsRepository clientRepository;
  private UserRepository userRepository;
  private LeadRepository leadRepository;

  public LeadsController(ClientDetailsRepository clientRepository, LeadRepository leadRepository, UserRepository userRepository) {
    this.clientRepository = clientRepository;
    this.leadRepository = leadRepository;
    this.userRepository = userRepository;
  }

  @PreAuthorize("hasAuthority('Admin') or hasAuthority('BuisnessDeveloper')")
  @PostMapping(path = "/leads")
  public Lead createPostsForUser(@RequestBody LeadAndClientDetails leadDetails, @CookieValue(name = "HTTP-X-AUTH-TOKEN", required = false) String authToken) {
    User loggedUser = userRepository.findByAuthToken(authToken);
    LeadAdapter adapter = new LeadAdapter(leadDetails, loggedUser, leadRepository, clientRepository);
    Lead lead = adapter.create_lead_with_details();
    return lead;
  }
}
