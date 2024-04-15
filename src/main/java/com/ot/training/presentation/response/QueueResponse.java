package com.ot.training.presentation.response;

import com.ot.training.application.service.response.QueueResponseDto;
import lombok.Value;

@Value
public class QueueResponse {

  private String keyword;
  private String from;
  private String to;

  /**
   * コンストラクタ
   * 
   * @param dto
   */
  public QueueResponse(QueueResponseDto dto) {
    this.keyword = dto.getKeyword();
    this.from = dto.getFrom();
    this.to = dto.getTo();
  }

}
