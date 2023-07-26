package com.example.haziq.lead_managemanet.repositories;

import com.example.haziq.lead_managemanet.models.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeadRepository extends JpaRepository<Lead, Integer>  {
}
