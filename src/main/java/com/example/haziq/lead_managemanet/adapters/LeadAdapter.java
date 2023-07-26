package com.example.haziq.lead_managemanet.adapters;

import com.example.haziq.lead_managemanet.models.ClientDetails;
import com.example.haziq.lead_managemanet.models.Lead;
import com.example.haziq.lead_managemanet.models.User;
import com.example.haziq.lead_managemanet.repositories.ClientDetailsRepository;
import com.example.haziq.lead_managemanet.repositories.LeadRepository;
import com.example.haziq.lead_managemanet.request_bodies.LeadAndClientDetails;

public class LeadAdapter {
  private LeadAndClientDetails leadDetails;
  private User currentUser;
  private LeadRepository leadRepository;
  private ClientDetailsRepository clientRepository;

  public LeadAdapter(LeadAndClientDetails leadDetails, User currentUser, LeadRepository leadRepository, ClientDetailsRepository clientRepository) {
    this.leadDetails = leadDetails;
    this.currentUser = currentUser;
    this.leadRepository = leadRepository;
    this.clientRepository = clientRepository;
  }

  public Lead create_lead_with_details() {
    ClientDetails client = new ClientDetails(leadDetails.getClientName(),
            leadDetails.getContactNumber(), leadDetails.getAddress());
    clientRepository.save(client);
    Lead lead = new Lead(leadDetails.getLeadName(),
            leadDetails.getTestType(), leadDetails.getPlatformUsed(), client, currentUser);
    leadRepository.save(lead);
    return lead;
  }
}
