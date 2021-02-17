package com.calculator.controller;


import com.calculator.service.IServiceCalculator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/calculator")
public class ControllerCalculator {

    private final IServiceCalculator serviceCalculator;

    public ControllerCalculator(IServiceCalculator serviceCalculator) {
        this.serviceCalculator = serviceCalculator;
    }

    @GetMapping(value = "/calculate")
    public ResponseEntity<Double> calculate(@RequestParam(name="firstNumber") BigDecimal firstNumber,
                             @RequestParam(name="secondNumber") BigDecimal secondNumber,
                             @RequestParam(name="operator") String operator){
            double result = this.serviceCalculator.calculate(firstNumber, secondNumber, operator);
            return new ResponseEntity<>(result, HttpStatus.OK);
    }

    
}
