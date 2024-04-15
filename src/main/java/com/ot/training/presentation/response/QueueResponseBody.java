package com.ot.training.presentation.response;

import java.util.List;
import com.ot.training.application.response.QueueResponseDtos;

public class QueueResponseBody {

  private List<QueueResponse> dtos;

  /**
   * コンストラクタ
   * @param dtos
   */
  public QueueResponseBody(QueueResponseDtos dtos) {
    dtos.getDto().stream().map(QueueResponse::new).forEach(this.dtos::add);
  }

}
