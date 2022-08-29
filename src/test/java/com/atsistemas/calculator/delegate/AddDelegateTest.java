package com.atsistemas.calculator.delegate;

import static com.atsistemas.calculator.mother.DataMother.ONE;
import static com.atsistemas.calculator.mother.DataMother.THREE;
import static com.atsistemas.calculator.mother.DataMother.TWO;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

import com.atsistemas.calculator.api.AddApiDelegate;
import com.atsistemas.calculator.model.OperationResult;
import com.atsistemas.calculator.mother.DataMother;
import com.atsistemas.calculator.service.OperationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
class AddDelegateTest {

  @MockBean
  private OperationService service;

  private AddApiDelegate  delegate;

  @BeforeEach
  void setUp() {
    delegate = new AddDelegate(service);
  }

  @Test
  void shouldAdd() {
    // given
    given(service.add(ONE, TWO)).willReturn(THREE);

    // when
    var actual = delegate.add(ONE, TWO);

    // then
    assertEquals(ResponseEntity.ok(new OperationResult().result(THREE)), actual);
  }


}