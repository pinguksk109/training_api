package com.ot.training.coordinator;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import com.ot.training.application.KeywordService;
import com.ot.training.application.response.KeywordDto;
import com.ot.training.exception.ApiResponseException;

public class KeywordCoordinator {

  @Autowired
  private KeywordService keywordService;
  
  public KeywordDto sendKeywordMessage() throws IOException, ApiResponseException {
    
    // TODO 後で作り変える いったんそのまま返す
    return keywordService.getKeyword();
    
    // 取得したキーワードのメッセージを送る
    // まとめてキーワードをServiceに送る
    
    // 送信したキーワードの一覧と期間をControllerに返却する
    
  }
}
