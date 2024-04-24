package com.ot.training.application.coordinator;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ot.training.application.request.MessageParam;
import com.ot.training.application.response.KeywordDto;
import com.ot.training.application.response.QueueResponseDtos;
import com.ot.training.application.service.KeywordService;
import com.ot.training.application.service.MessageService;
import com.ot.training.application.service.response.QueueResponseDto;
import com.ot.training.exception.ApiResponseException;

@Service
public class KeywordCoordinator {

  @Autowired
  MessageService messageService;

  @Autowired
  KeywordService keywordService;

  /**
   * メッセージを送信する
   * @return
   * @throws IOException
   * @throws ApiResponseException
   */
  public List<QueueResponseDtos> sendMessage() throws IOException, ApiResponseException {

    KeywordDto keywordDto = keywordService.getKeyword();

    List<QueueResponseDtos> dtos = keywordDto.getKeywords().stream().map(e -> {
      MessageParam param = new MessageParam(e);
      List<QueueResponseDto> dto = messageService.sendMessage(param);
      return new QueueResponseDtos(dto);
    }).collect(Collectors.toList());

    return dtos;
  }
}
