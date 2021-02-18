package com.calculator.utilities;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public enum Operation {
    SUM("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return this.sign;
    }
}
