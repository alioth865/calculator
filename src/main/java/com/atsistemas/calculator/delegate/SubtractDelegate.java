package com.atsistemas.calculator.delegate;

import com.atsistemas.calculator.api.SubtractApi;
import com.atsistemas.calculator.api.SubtractApiDelegate;
import com.atsistemas.calculator.model.OperationResult;
import com.atsistemas.calculator.service.OperationService;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubtractDelegate implements SubtractApiDelegate {

  private final OperationService service;

  public SubtractDelegate(OperationService service) {
    this.service = service;
  }

  @Override
  public ResponseEntity<OperationResult> subtract(BigDecimal firstTerm, BigDecimal secondTerm) {
    return ResponseEntity.ok(new OperationResult().result(service.subtract(firstTerm, secondTerm)));
  }
}
