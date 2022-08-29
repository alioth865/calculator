package com.atsistemas.calculator.delegate;

import com.atsistemas.calculator.api.AddApiDelegate;
import com.atsistemas.calculator.model.OperationResult;
import com.atsistemas.calculator.service.OperationService;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddDelegate implements AddApiDelegate {

  private final OperationService service;

  public AddDelegate(OperationService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<OperationResult> add(BigDecimal firstTerm, BigDecimal secondTerm) {
    return ResponseEntity.ok(new OperationResult().result(service.add(firstTerm, secondTerm)));
  }
}
