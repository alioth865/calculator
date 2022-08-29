package com.atsistemas.calculator.service.impl;

import static com.atsistemas.calculator.mother.DataMother.ONE;
import static com.atsistemas.calculator.mother.DataMother.THREE;
import static com.atsistemas.calculator.mother.DataMother.TWO;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.atsistemas.calculator.service.OperationService;
import io.corp.calculator.TracerAPI;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class OperationTracerTest {

  private OperationService operationService;

  @Spy
  private TracerAPI tracerAPI = new Sl4jTracer();

  @BeforeEach
  void setUp() {
    operationService = new OperationTracer(tracerAPI);
  }

  @Test
  void shouldAddAndTrace() {
    // when
    var actual = operationService.add(ONE, TWO);

    // then
    assertAll(() -> assertEquals(THREE, actual),
        () -> Mockito.verify(tracerAPI).trace(THREE));
  }

  @Test
  void shouldSubtractAndTrace() {
    // when
    var actual = operationService.subtract(THREE, TWO);

    // then
    assertAll(() -> assertEquals(ONE, actual),
        () -> Mockito.verify(tracerAPI).trace(ONE));
  }
}