package com.steven.nagie.domain.impl.users;

import com.steven.nagie.domain.api.users.UserService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GameServiceImpl implements UserService {
  @Override
  public BigDecimal multiplyByTen(BigDecimal startNumber) {
    return null;
  }
}
