package com.atsistemas.calculator.service.impl;

import io.corp.calculator.TracerAPI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Sl4jTracer implements TracerAPI {

  @Override
  public <T> void trace(T t) {
    log.info("Tracing result :: {}", t.toString());
  }
}
