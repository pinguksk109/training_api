package com.ot.training.exception;

import lombok.Getter;

@Getter
public class ApiResponseException extends Exception {

  private String responseMessage;
  
  public ApiResponseException() {
    super();
  }
  
  public ApiResponseException(String message) {
    super(message);
  }
}
