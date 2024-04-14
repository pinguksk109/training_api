package com.ot.training.application.service.response;

import com.ot.training.infrastructure.repository.QueueMessageRequest;
import lombok.Value;

@Value
public class QueueResponseDto {

  private String keyword;
  private String from;
  private String to;

  /**
   * コンストラクタ
   * @param request
   */
  public QueueResponseDto(QueueMessageRequest request) {
    this.keyword = request.getKeyword();
    this.from = request.getFrom();
    this.to = request.getTo();
  }
}
