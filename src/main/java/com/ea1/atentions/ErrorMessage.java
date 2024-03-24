package com.ea1.atentions;

public class ErrorMessage {
  private int status;
  private String message;

  public ErrorMessage(int status, String message) {
    this.status = status;
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
