package com.calculator.utilities;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum Operation {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private static final Operation[] values = new Operation[]{SUM, SUBTRACTION, MULTIPLICATION, DIVISION};

    private String sign;

    Operation(String sign) { this.sign = sign; }

    private String getSign() { return this.sign; }

    @JsonCreator
    public static Operation fromValue(String value){
        for (int i = 0; i < values.length; i++ ){
            Operation operatorCurrent = values[i];
            if (value.equalsIgnoreCase(operatorCurrent.name()) ||
            value.equalsIgnoreCase(operatorCurrent.getSign())){
                return operatorCurrent;
            }
        }

        throw new RuntimeException("Operation not supported" + value);
    }

}
