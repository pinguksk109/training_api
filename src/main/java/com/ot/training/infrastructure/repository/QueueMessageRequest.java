package com.ot.training.infrastructure.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Value;

@Value
public class QueueMessageRequest {

  private String keyword;
  private String from;
  private String to;


  private static final ObjectMapper MAPPER = new ObjectMapper();

  /**
   * Jsonに変換して返却する
   * @return
   */
  public String toJson() {
    try {
      return MAPPER.writeValueAsString(this);
    } catch (JsonProcessingException e) {
      throw new IllegalStateException("キーワードのデータを受け取るためのキューの内容をJSON形式に変換に失敗しました");
    }
  }
}
