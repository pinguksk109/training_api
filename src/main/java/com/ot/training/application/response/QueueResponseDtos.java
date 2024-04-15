package com.ot.training.application.response;

import java.util.List;
import com.ot.training.application.service.response.QueueResponseDto;
import lombok.Value;

@Value
public class QueueResponseDtos {

  private List<QueueResponseDto> dto;
  
}
