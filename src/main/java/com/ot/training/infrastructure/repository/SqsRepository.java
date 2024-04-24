package com.ot.training.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.AmazonSQSException;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Repository
public class SqsRepository {
  
//  @Value("${sqs.endpoint}")
//  private String queueUrl;
  
  public void sendMessage(QueueMessageRequest request) {
    
    String queueUrl = "http://localhost:53218/000000000000/test-queue";
    
    AmazonSQS sqs = AmazonSQSClientBuilder.standard()
        .withCredentials(new DefaultAWSCredentialsProviderChain())
        .build();
    
    SendMessageRequest sendMessage = new SendMessageRequest().withQueueUrl(queueUrl)
        .withMessageBody(request.toJson()).withDelaySeconds(5);

    try {
      sqs.sendMessage(sendMessage);
    } catch(AmazonSQSException e) {
      throw new AmazonSQSException("SQSにメッセージを送る処理でエラーが発生しました");
    }
  }
}
