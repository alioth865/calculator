package com.atsistemas.calculator.delegate;

import static com.atsistemas.calculator.mother.DataMother.ONE;
import static com.atsistemas.calculator.mother.DataMother.THREE;
import static com.atsistemas.calculator.mother.DataMother.TWO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.atsistemas.calculator.api.AddApiDelegate;
import com.atsistemas.calculator.api.SubtractApiDelegate;
import com.atsistemas.calculator.model.OperationResult;
import com.atsistemas.calculator.service.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class SubtractDelegateTest {

  @MockBean
  private OperationService service;

  private SubtractApiDelegate delegate;

  @BeforeEach
  void setUp() {
    delegate = new SubtractDelegate(service);
  }

  @Test
  void shouldSubtract() {
    // given
    given(service.subtract(THREE, TWO)).willReturn(ONE);

    // when
    var actual = delegate.subtract(THREE, TWO);

    // then
    assertEquals(ResponseEntity.ok(new OperationResult().result(ONE)), actual);
  }

}