package com.calculator.utilities;

import java.math.BigDecimal;

public class Results {
    private final BigDecimal firstNumber;
    private final BigDecimal secondNumber;
    private final double total;
    private final String operator;
    private final String error;

    public Results(BigDecimal firstNumber, BigDecimal secondNumber, double total, String operator, String error){
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.total = total;
        this.operator = operator;
        this.error = error;
    }

    public BigDecimal getFirstNumber(){
        return firstNumber;
    }

    public BigDecimal getSecondNumber(){
        return secondNumber;
    }

    public double getTotal() {
        return total;
    }

    public String getOperator() {
        return operator;
    }

    public String getError() {
        return error;
    }
}
