package com.steven.nagie.bootstrap;

import com.steven.nagie.api.impl.UserEndpoint;
import com.steven.nagie.domain.impl.users.ConwayGameServiceImpl;
import org.springframework.test.context.TestPropertySource;
import org.testng.annotations.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.testng.Assert.*;

@ContextConfiguration(classes = ITConfig.class)
@TestPropertySource("classpath:test-application.properties")
@WebAppConfiguration
public class PathInterviewTestIT extends AbstractTestNGSpringContextTests {
  
  @Autowired
  private ConwayGameServiceImpl service;
  
  @Test
  public void testConwayGameScenario1() {
    boolean[][] input = new boolean[][]{
        new boolean[]{true, false, true, false},
        new boolean[]{false, false, false, true},
        new boolean[]{true, true, true, false}
    };
    boolean[][] expected = new boolean[][]{
        new boolean[]{false, false, false, false},
        new boolean[]{true, false, false, true},
        new boolean[]{false, true, true, false}
    };
    
    boolean[][] response = service.gameStart(input);
    assertTrue(response[1][0]);
    assertTrue(response[2][1]);
    assertFalse(response[0][0]);
    assertTrue(Arrays.deepEquals(response, expected));
  }
}
