package com.ot.training.application.response;

import java.util.List;
import com.ot.training.infrastructure.response.KeywordResponse;
import lombok.Getter;

@Getter
public class KeywordDto {

  private List<String> keywords;
  
  /**
   * コンストラクタ
   * @param response
   */
  public KeywordDto(KeywordResponse response) {
    this.keywords = response.getKeywords();
  }
  
}
