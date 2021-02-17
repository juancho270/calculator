package com.calculator.service;

import java.math.BigDecimal;

public interface IServiceCalculator {
    double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operator);
}
