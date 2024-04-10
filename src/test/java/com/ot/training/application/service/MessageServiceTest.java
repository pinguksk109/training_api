package com.ot.training.application.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest extends MessageService {

  @InjectMocks
  MessageService sut;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  void test() {
    sut.sendMessage(null);
  }

}
