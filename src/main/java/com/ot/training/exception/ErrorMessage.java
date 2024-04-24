package com.ot.training.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@AllArgsConstructor
public class ErrorMessage {

  private Integer status;
  private String code;
  private String message;
  
}
