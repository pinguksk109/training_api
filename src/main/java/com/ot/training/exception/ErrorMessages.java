package com.ot.training.exception;

import java.util.List;
import lombok.Data;

@Data
public class ErrorMessages {

  private List<ErrorMessage> errors;
  
  public void add(ErrorMessage error) {
    this.getErrors().add(error);
  }
}
