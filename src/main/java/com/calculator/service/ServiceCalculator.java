package com.calculator.service;


import com.calculator.utilities.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ServiceCalculator implements IServiceCalculator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceCalculator.class);

    @Override
    public double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operator) {
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Calculating result for : {} {} {}", firstNumber, secondNumber, operator);
        }

        Operation operation= Operation.fromValue(operator);

        if(operation == null){
            throw new RuntimeException("Operation impossible to process" + operator);
        }

        switch(operation){
            case SUM:
                return firstNumber.add(secondNumber).doubleValue();
            case SUBTRACTION:
                return firstNumber.subtract(secondNumber).doubleValue();
            case MULTIPLICATION:
                return firstNumber.multiply(secondNumber).doubleValue();
            case DIVISION:
                return firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP).doubleValue();
            default:
                if(LOGGER.isErrorEnabled()){
                    LOGGER.error("operation not supported to be calculated: {} ", operation);
                }
                throw new RuntimeException("operation not supported to be calculated: " + operation.toString());
        }

    }
}
