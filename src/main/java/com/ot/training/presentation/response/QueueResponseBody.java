package com.ot.training.presentation.response;

import java.util.List;
import java.util.stream.Collectors;
import com.ot.training.application.response.QueueResponseDtos;
import lombok.Getter;

@Getter
public class QueueResponseBody {

  private List<QueueResponse> dtos;

  /**
   * コンストラクタ
   * @param dtos
   */
  public QueueResponseBody(QueueResponseDtos dtos) {
    this.dtos = dtos.getDto().stream().map(QueueResponse::new).collect(Collectors.toList());
  }

}
