package com.ot.training.presentation;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.ot.training.application.response.KeywordDto;
import com.ot.training.application.service.KeywordService;
import com.ot.training.exception.ApiResponseException;
import com.ot.training.presentation.response.KeywordResponse;

@Controller
public class KeywordController {

  @Autowired
  private KeywordService keywordService;
  
  @PostMapping("/keyword/queue")
  public ResponseEntity<?> sendKeywordMessage() throws IOException, ApiResponseException {
    KeywordDto dto = keywordService.getKeyword();
    return ResponseEntity.ok().body(new KeywordResponse(dto));
  }
}
