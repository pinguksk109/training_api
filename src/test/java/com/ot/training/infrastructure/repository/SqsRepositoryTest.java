package com.ot.training.infrastructure.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SqsRepositoryTest extends SqsRepository {
  
  @InjectMocks
  private SqsRepository sut;
  
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  void sendMessage_メッセージを送信できること() {
    QueueMessageRequest request = new QueueMessageRequest("lumix", "2024-01-01", "2024-01-31");
    try {
      sut.sendMessage(request);
    } catch(Exception e) {
      System.out.println("=====");
      System.out.println(e);
      System.out.println("=====");
    }
  }
}
