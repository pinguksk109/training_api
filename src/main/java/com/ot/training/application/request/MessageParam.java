package com.ot.training.application.request;

import java.util.List;
import lombok.Value;

@Value
public class MessageParam {

  private List<String> keywords;
  
}
