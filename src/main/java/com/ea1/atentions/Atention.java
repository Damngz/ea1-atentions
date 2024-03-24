package com.ea1.atentions;

import java.time.LocalDate;

public class Atention {
  private int id;
  private LocalDate date;
  private Patient patient;
  private Doctor doctor;
  private String diagnosis;
  private String treatment;
  private String observations;

  public Atention(int id, LocalDate date, Patient patient, Doctor doctor, String diagnosis, String treatment, String observations) {
    this.id = id;
    this.date = date;
    this.patient = patient;
    this.doctor = doctor;
    this.diagnosis = diagnosis;
    this.treatment = treatment;
    this.observations = observations;
  }

  // Getters and Setters
  public int getId() {
    return id;
  }

  public LocalDate getDate() {
    return date;
  }

  public Patient getPatient() {
    return patient;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public String getObservations() {
    return observations;
  }

  public String getTreatment() {
    return treatment;
  }
}
