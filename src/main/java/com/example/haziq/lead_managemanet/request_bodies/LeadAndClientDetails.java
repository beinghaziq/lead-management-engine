package com.example.haziq.lead_managemanet.request_bodies;

public class LeadAndClientDetails {
  private String leadName;
  private String testType;
  private String platformUsed;
  private String clientName;
  private String contactNumber;
  private String address;

  public LeadAndClientDetails(String leadName, String testType, String platformUsed, String clientName, String contactNumber, String address) {
    this.leadName = leadName;
    this.testType = testType;
    this.platformUsed = platformUsed;
    this.clientName = clientName;
    this.contactNumber = contactNumber;
    this.address = address;
  }

  public String getLeadName() {
    return leadName;
  }

  public void setLeadName(String leadName) {
    this.leadName = leadName;
  }

  public String getTestType() {
    return testType;
  }

  public void setTestType(String testType) {
    this.testType = testType;
  }

  public String getPlatformUsed() {
    return platformUsed;
  }

  public void setPlatformUsed(String platformUsed) {
    this.platformUsed = platformUsed;
  }

  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  public String getContactNumber() {
    return contactNumber;
  }

  public void setContactNumber(String contactNumber) {
    this.contactNumber = contactNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
