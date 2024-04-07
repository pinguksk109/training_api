package com.ot.training.infrastructure.repository;

import org.springframework.stereotype.Repository;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;

@Repository
public class S3Repository {
  
//  private AmazonSQS sqs;

  public void sendMessage(QueueMessageRequest request) {
//    AmazonSQS sqs = AmazonSQSClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:53218", "ap-northeast-1")).build(); // リージョンを指定.build();
    
    String endpoint = "http://localhost:53218";
    
    AmazonSQS sqs = AmazonSQSClientBuilder.standard()
        .withCredentials(new DefaultAWSCredentialsProviderChain())
        .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(endpoint, "us-west-2")) // リージョンを指定
        .build();
    
    String queueUrl = "http://localhost:9324/000000000000/test-queue";
    SendMessageRequest sendMessage = new SendMessageRequest().withQueueUrl(queueUrl)
        .withMessageBody(request.toJson()).withDelaySeconds(5);
    sqs.sendMessage(sendMessage);

  }
}
