// TODO: rename the package and the project once this project has an actual official name
package com.steven.nagie.api;

import com.steven.nagie.domain.DomainConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(DomainConfiguration.class)
@ComponentScan(basePackages = {
    "com.steven.nagie.api"
})
public class ApiConfiguration {
  
  public static void main(String[] args) {
    SpringApplication.run(ApiConfiguration.class, args);
  }
  
}
