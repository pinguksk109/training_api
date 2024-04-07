package com.ot.training.infrastructure.repository;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.ot.training.exception.ApiResponseException;
import com.ot.training.infrastructure.response.KeywordResponse;

@Repository
public class KeywordRepository {

  /**
   * キーワードを取得
   * @return
   * @throws IOException
   * @throws ApiResponseException
   */
  public KeywordResponse getKeywords() throws IOException, ApiResponseException {
    
    HttpRequestFactory factory = (new NetHttpTransport()).createRequestFactory();
    
    // TODO: APIないため、いったんjson-serverからレスポンス受け取っている
    GenericUrl genericUrl = new GenericUrl("http://localhost:3000/keyword");
    
    HttpRequest request = factory.buildGetRequest(genericUrl);
    
    request.setThrowExceptionOnExecuteError(false);
    
    request.setConnectTimeout(0);
    
    request.setReadTimeout(0);
    
    HttpResponse response = request.execute();
    String responseBody = response.parseAsString();
    response.disconnect();
    
    if(!HttpStatus.valueOf(response.getStatusCode()).is2xxSuccessful()) {
      throw new ApiResponseException();
    }
    
    return KeywordResponse.parse(responseBody);
  }
}
