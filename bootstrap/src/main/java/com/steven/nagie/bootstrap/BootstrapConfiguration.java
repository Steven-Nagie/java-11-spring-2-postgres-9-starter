package com.steven.nagie.bootstrap;

import com.steven.nagie.api.ApiConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ApiConfiguration.class})
public class BootstrapConfiguration {
  
  public static void main(String[] args) {
    SpringApplication.run(BootstrapConfiguration.class, args);
  }
  
}
