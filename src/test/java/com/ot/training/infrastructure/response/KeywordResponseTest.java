package com.ot.training.infrastructure.response;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class KeywordResponseTest extends KeywordResponse {

  @Test
  void parse_パースできること() {
    KeywordResponse actual = KeywordResponse.parse(""
        + "{\n"
        + "  \"keywords\": [\n"
        + "    \"サウナ\",\n"
        + "    \"フィットネス\",\n"
        + "    \"ヨガ\"\n"
        + "  ]\n"
        + "}"
        + "");
    
    assertEquals("サウナ", actual.getKeywords().get(0));
    assertEquals("フィットネス", actual.getKeywords().get(1));
    assertEquals("ヨガ", actual.getKeywords().get(2));
  }
}
