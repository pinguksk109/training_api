package com.ot.training.infrastructure.response;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeywordResponse {

  private List<String> keywords;
  
  static ObjectMapper mapper = new ObjectMapper();
  
  /**
   * パースする
   * @param jsonStr
   * @return
   */
  public static KeywordResponse parse(String jsonStr) {
    try {
      return mapper.readValue(jsonStr, KeywordResponse.class);
    } catch (IOException e) {
      throw new IllegalArgumentException("パースに失敗" + jsonStr, e);
    }
  }
}
