package com.ea1.atentions;

public class Patient {
  private int id;
  private String rut;
  private String name;
  private String address;
  private String email;
  private int phone;

  public Patient(int id, String rut, String name, String address, String email, int phone) {
    this.id = id;
    this.rut = rut;
    this.name = name;
    this.address = address;
    this.email = email;
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

  public String getAddress() {
    return address;
  }

  public String getEmail() {
    return email;
  }

  public int getPhone() {
    return phone;
  }
}
