package com.ot.training.presentation;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.ot.training.application.coordinator.KeywordCoordinator;
import com.ot.training.application.response.QueueResponseDtos;
import com.ot.training.exception.ApiResponseException;
import com.ot.training.presentation.response.QueueResponseBody;

@Controller
public class KeywordController {

  @Autowired
  private KeywordCoordinator keywordCoordinator;
  
  @PostMapping("/keyword/queue")
  public ResponseEntity<?> sendKeywordMessage() throws IOException, ApiResponseException {
    
    List<QueueResponseDtos> dtosList = keywordCoordinator.sendMessage();
    
    List<QueueResponseBody> responseBodyList = dtosList.stream().map(QueueResponseBody::new).collect(Collectors.toList());
    
    return ResponseEntity.ok().body(responseBodyList);
  }
}
