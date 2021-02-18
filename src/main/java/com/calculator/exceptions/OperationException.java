package com.calculator.exceptions;

import com.calculator.utilities.Utilities;

public class OperationException extends RuntimeException{
    public OperationException(String operation) {
        super(String.format(Utilities.getValueByKey("opExcp"), operation));
    }
}
