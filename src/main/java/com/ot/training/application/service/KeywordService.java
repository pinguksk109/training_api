package com.ot.training.application.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ot.training.application.response.KeywordDto;
import com.ot.training.exception.ApiResponseException;
import com.ot.training.infrastructure.repository.KeywordRepository;
import com.ot.training.infrastructure.response.KeywordResponse;

@Service
public class KeywordService {

  @Autowired
  private KeywordRepository keywordRepository;
  
  // TODO: Loggerを適用したい
//    private static final Logger LOGGER = LoggerFactory.getLogger(KeywordService.class);
  
  public KeywordDto getKeyword() throws IOException, ApiResponseException {
    try {
      KeywordResponse response = keywordRepository.getKeywords();
      return new KeywordDto(response);
    } catch (ApiResponseException e) {
      throw new ApiResponseException("対象キーワード取得でエラーが発生しました");
    }
  }
}
