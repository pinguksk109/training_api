package com.ot.training.application.service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ot.training.application.request.MessageParam;
import com.ot.training.application.service.response.QueueResponseDto;
import com.ot.training.infrastructure.repository.QueueMessageRequest;
import com.ot.training.infrastructure.repository.SqsRepository;

@Service
public class MessageService {

  @Autowired
  private SqsRepository sqsRepository;

  private final int TARGET_MONTH = 16;

  /**
   * メッセージをSQSに送信する
   * 
   * @param param
   * @return
   */
  public List<QueueResponseDto> sendMessage(MessageParam param) {

    // メッセージから過去16か月のキーワードを作る
    ZonedDateTime now = ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    List<String> firstDateList = new ArrayList<>();
    List<String> lastDateList = new ArrayList<>();

    for (int i = 0; i < TARGET_MONTH; i++) {
      ZonedDateTime firstDayOfMonth = now.minusMonths(i).withDayOfMonth(1);
      firstDateList.add(firstDayOfMonth.format(formatter));

      ZonedDateTime lastDayOfMonth =
          now.minusMonths(i).withDayOfMonth(now.minusMonths(i).toLocalDate().lengthOfMonth());
      lastDateList.add(lastDayOfMonth.format(formatter));
    }

    // 過去16か月分のメッセージを送る
    List<QueueResponseDto> dto = new ArrayList<>();
    for (int i = 0; i < TARGET_MONTH; i++) {
      QueueMessageRequest request =
          new QueueMessageRequest(param.getKeywords(), firstDateList.get(i), lastDateList.get(i));
      // TODO: AmazonSQSExceptionをキャッチする例外処理を実装したい 何をスローするか検討
      sqsRepository.sendMessage(request);
      dto.add(new QueueResponseDto(request));
    }

    return dto;
  }
}
