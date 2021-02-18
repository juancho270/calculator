package com.calculator.exceptions;

import com.calculator.utilities.Utilities;

public class NullOperationException extends RuntimeException{
    public NullOperationException(String operator) {
        super(String.format(Utilities.getValueByKey("nullOpExcp"), operator));
    }
}
