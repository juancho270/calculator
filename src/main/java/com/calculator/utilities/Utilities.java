package com.calculator.utilities;

import com.calculator.exceptions.OperationException;
import com.calculator.service.ServiceCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class Utilities {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceCalculator.class);

    public static String getValueByKey(String key) {
        String value = "";
        try {
            InputStream input = new FileInputStream("src/main/resources/messages.properties");
            Properties prop = new Properties();
            prop.load(input);
            value = prop.getProperty(key);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return value;
    }

    public static Operation getOperatorFromValue(String value) throws RuntimeException {
        return Arrays.asList(Operation.values()).stream().filter(operation -> {
            if (value.equalsIgnoreCase(operation.name()) ||
                    value.equalsIgnoreCase(operation.getSign())) {
                return true;
            }
            return false;
        }).findAny().orElseThrow(() -> {
            return new OperationException(value);
        });
    }
}
