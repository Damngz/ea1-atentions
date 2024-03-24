package com.ea1.atentions;

public class Doctor {
  private int id;
  private String rut;
  private String name;
  private String specialization;
  private String email;
  private String address;
  private int phone;

  public Doctor(int id, String rut, String name, String specialization, String email, String address, int phone) {
    this.id = id;
    this.rut = rut;
    this.name = name;
    this.specialization = specialization;
    this.email = email;
    this.address = address;
    this.phone = phone;
  }

  public int getId() {
    return id;
  }

  public String getRut() {
    return rut;
  }

  public String getName() {
    return name;
  }

  public String getSpecialization() {
    return specialization;
  }

  public String getEmail() {
    return email;
  }

  public String getAddress() {
    return address;
  }

  public int getPhone() {
    return phone;
  }
}
