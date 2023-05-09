package com.cognizant.springopenapidemo.model;

import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class Party {

  private String partyName;
  @NotBlank
  private String location;
  private List<Student> attendingStudents;
  private List<Drink> availableDrinks;

  public Party(String partyName, String location, List<Drink> availableDrinks) {
    this.partyName = partyName;
    this.location = location;
    this.availableDrinks = availableDrinks;
    this.attendingStudents = new ArrayList<>();
  }

  public String getPartyName() {
    return partyName;
  }

  public String getLocation() {
    return location;
  }

  public List<Student> getAttendingStudents() {
    return attendingStudents;
  }

  public List<Drink> getAvailableDrinks() {
    return availableDrinks;
  }

  public void setPartyName(String partyName) {
    this.partyName = partyName;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public void setAvailableDrinks(
      List<Drink> availableDrinks) {
    this.availableDrinks = availableDrinks;
  }

  public void addStudent(Student student){
    this.attendingStudents.add(student);
  }
}
