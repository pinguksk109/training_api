package com.ot.training.presentation.response;

import java.util.List;
import com.ot.training.application.response.KeywordDto;
import lombok.Getter;

@Getter
public class KeywordResponse {

  private List<String> keywords;
  
  /**
   * コンストラクタ
   * @param dto
   */
  public KeywordResponse(KeywordDto dto) {
    this.keywords = dto.getKeywords();
  }
  
}
