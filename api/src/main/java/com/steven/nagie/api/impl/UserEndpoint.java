package com.steven.nagie.api.impl;

import com.steven.nagie.domain.api.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/users")
public class UserEndpoint {

  @Autowired
  private UserService service;

  @GetMapping("/multiply")
  public BigDecimal multiplyByTen(@RequestParam("start") BigDecimal startNumber) {
    return service.multiplyByTen(startNumber);
  }
}
