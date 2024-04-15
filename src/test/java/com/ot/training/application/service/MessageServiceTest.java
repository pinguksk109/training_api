package com.ot.training.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ot.training.application.request.MessageParam;
import com.ot.training.application.service.response.QueueResponseDto;
import com.ot.training.infrastructure.repository.SqsRepository;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest extends MessageService {

  @InjectMocks
  MessageService sut;

  @Mock
  SqsRepository sqsRepository;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  // 実行月によって結果が変わるためIgnoreしておきます
  @Disabled
  void メッセージをSQSに送信した場合_送ったメッセージを返却すること() {

    doNothing().when(sqsRepository).sendMessage(any());

    MessageParam param = new MessageParam("カメラ");
    List<QueueResponseDto> actual = sut.sendMessage(param);

    assertEquals(16, actual.size());
    assertEquals("2024-04-01", actual.get(0).getFrom());
    assertEquals("2024-04-30", actual.get(0).getTo());
    assertEquals("カメラ", actual.get(0).getKeyword());

    assertEquals("2024-03-01", actual.get(1).getFrom());
    assertEquals("2024-03-31", actual.get(1).getTo());
    assertEquals("カメラ", actual.get(1).getKeyword());

    assertEquals("2024-02-01", actual.get(2).getFrom());
    assertEquals("2024-02-29", actual.get(2).getTo());
    assertEquals("カメラ", actual.get(2).getKeyword());

    assertEquals("2024-01-01", actual.get(3).getFrom());
    assertEquals("2024-01-31", actual.get(3).getTo());
    assertEquals("カメラ", actual.get(3).getKeyword());

    assertEquals("2023-12-01", actual.get(4).getFrom());
    assertEquals("2023-12-31", actual.get(4).getTo());
    assertEquals("カメラ", actual.get(4).getKeyword());

    assertEquals("2023-11-01", actual.get(5).getFrom());
    assertEquals("2023-11-30", actual.get(5).getTo());
    assertEquals("カメラ", actual.get(5).getKeyword());

    assertEquals("2023-10-01", actual.get(6).getFrom());
    assertEquals("2023-10-31", actual.get(6).getTo());
    assertEquals("カメラ", actual.get(6).getKeyword());

    assertEquals("2023-09-01", actual.get(7).getFrom());
    assertEquals("2023-09-30", actual.get(7).getTo());
    assertEquals("カメラ", actual.get(7).getKeyword());

    assertEquals("2023-08-01", actual.get(8).getFrom());
    assertEquals("2023-08-31", actual.get(8).getTo());
    assertEquals("カメラ", actual.get(8).getKeyword());

    assertEquals("2023-07-01", actual.get(9).getFrom());
    assertEquals("2023-07-31", actual.get(9).getTo());
    assertEquals("カメラ", actual.get(9).getKeyword());

    assertEquals("2023-06-01", actual.get(10).getFrom());
    assertEquals("2023-06-30", actual.get(10).getTo());
    assertEquals("カメラ", actual.get(10).getKeyword());

    assertEquals("2023-05-01", actual.get(11).getFrom());
    assertEquals("2023-05-31", actual.get(11).getTo());
    assertEquals("カメラ", actual.get(11).getKeyword());

    assertEquals("2023-04-01", actual.get(12).getFrom());
    assertEquals("2023-04-30", actual.get(12).getTo());
    assertEquals("カメラ", actual.get(12).getKeyword());

    assertEquals("2023-03-01", actual.get(13).getFrom());
    assertEquals("2023-03-31", actual.get(13).getTo());
    assertEquals("カメラ", actual.get(13).getKeyword());

    assertEquals("2023-02-01", actual.get(14).getFrom());
    assertEquals("2023-02-28", actual.get(14).getTo());
    assertEquals("カメラ", actual.get(14).getKeyword());

    assertEquals("2023-01-01", actual.get(15).getFrom());
    assertEquals("2023-01-31", actual.get(15).getTo());
    assertEquals("カメラ", actual.get(15).getKeyword());
  }
}
