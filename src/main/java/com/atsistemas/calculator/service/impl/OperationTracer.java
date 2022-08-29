package com.atsistemas.calculator.service.impl;

import com.atsistemas.calculator.service.OperationService;
import io.corp.calculator.TracerAPI;
import java.math.BigDecimal;
import org.springframework.stereotype.Service;

@Service
public class OperationTracer implements OperationService {

  private final TracerAPI tracer;

  public OperationTracer(TracerAPI tracer) {
    this.tracer = tracer;
  }

  @Override
  public BigDecimal add(BigDecimal firstTerm, BigDecimal secondTerm) {
    var add = firstTerm.add(secondTerm);
    tracer.trace(add);
    return add;
  }

  @Override
  public BigDecimal subtract(BigDecimal firstTerm, BigDecimal secondTerm) {
    var subtract = firstTerm.subtract(secondTerm);
    tracer.trace(subtract);
    return subtract;
  }
}
