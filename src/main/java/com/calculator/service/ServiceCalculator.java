package com.calculator.service;


import com.calculator.exceptions.NullOperationException;
import com.calculator.exceptions.OperationException;
import com.calculator.utilities.Operation;
import com.calculator.utilities.Utilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class ServiceCalculator implements IServiceCalculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceCalculator.class);

    @Override
    public double calculate(BigDecimal firstNumber, BigDecimal secondNumber, String operator) throws NullOperationException {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Calculating result for : {} {} {}", firstNumber, secondNumber, operator);
        }

        Operation operation = Utilities.getOperatorFromValue(operator);

        if (Objects.isNull(operation)) {
            throw new NullOperationException(operator);
        }

        switch (operation) {
            case SUM:
                return firstNumber.add(secondNumber).doubleValue();
            case SUBTRACTION:
                return firstNumber.subtract(secondNumber).doubleValue();
            case MULTIPLICATION:
                return firstNumber.multiply(secondNumber).doubleValue();
            case DIVISION:
                return firstNumber.divide(secondNumber, 2, RoundingMode.HALF_UP).doubleValue();
            default:
                if (LOGGER.isErrorEnabled()) {
                    LOGGER.error(Utilities.getValueByKey("opExcp"), operation);
                }
                throw new OperationException(operation.toString());
        }
    }
}
