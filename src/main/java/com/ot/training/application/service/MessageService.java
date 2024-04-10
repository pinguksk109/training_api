package com.ot.training.application.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ot.training.application.request.MessageParam;
import com.ot.training.infrastructure.repository.SqsRepository;

@Service
public class MessageService {

  @Autowired
  private SqsRepository sqsRepository;
  
  private final int TARGET_MONTH = 16;
  
  public void sendMessage(MessageParam param) {
    
    // メッセージから過去16か月のキーワードを作る
    ZonedDateTime now = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
    
    List<String> dateList = new ArrayList<>();
    dateList.add(formatter.format(formatter));
    
    for(int i = 0; i < TARGET_MONTH; i++) {
      dateList.add(formatter.format(formatter));
    }
    
    // 過去16か月分のメッセージを送る
    
    // 送ったメッセージの内容を返却する
    
  }
  
}
