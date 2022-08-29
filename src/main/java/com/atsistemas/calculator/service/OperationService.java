package com.atsistemas.calculator.service;

import java.math.BigDecimal;

public interface OperationService {

  BigDecimal add(BigDecimal firstTerm, BigDecimal secondTerm);

  BigDecimal subtract(BigDecimal firstTerm, BigDecimal secondTerm);

}
