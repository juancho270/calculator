package com.calculator.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Results {
    private final BigDecimal firstNumber;
    private final BigDecimal secondNumber;
    private final double total;
    private final String operator;
    private final String error;
}
