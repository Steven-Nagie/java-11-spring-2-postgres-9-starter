package com.steven.nagie.bootstrap;

import com.steven.nagie.api.impl.UserEndpoint;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;

import static org.testng.Assert.assertEquals;

@ContextConfiguration(classes = ITConfig.class)
@TestPropertySource("classpath:test-application.properties")
@WebAppConfiguration
public class BroccoliTinderTestIt extends AbstractTestNGSpringContextTests {
  
  @Autowired
  private UserEndpoint userEndpoint;
  
  @Test
  public void testMultiplicationEndpoint() {
    BigDecimal response = userEndpoint.multiplyByTen(BigDecimal.TEN);
    assertEquals(response, new BigDecimal("100"));
  }
}
