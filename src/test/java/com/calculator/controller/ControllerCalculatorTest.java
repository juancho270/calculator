package com.calculator.controller;

import com.calculator.CalculatorApplication;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CalculatorApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerCalculatorTest {
    @LocalServerPort
    int randomServerPort;

    private ResponseEntity<Double> calculate(double firstNumber, double secondNumber, String operator) throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();

        final String baseUrl = "http://localhost:" + randomServerPort +
                "/calculator/calculate?firstNumber=" + firstNumber +
                "&secondNumber=" + secondNumber + "&operator=" + operator;
        URI uri = new URI(baseUrl);

        ResponseEntity<Double> result = restTemplate.getForEntity(uri, Double.class);
        return result;
    }

    @Test
    public void testSumWithSuccess() throws URISyntaxException {
        ResponseEntity<Double> result = calculate(4, 6, "sum");

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(10.0d, result.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testSubtractionWithSuccess() throws URISyntaxException {
        ResponseEntity<Double> result = calculate(4, 6, "subtraction");

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(-2.0d, result.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testMultiplicationWithSuccess() throws URISyntaxException {
        ResponseEntity<Double> result = calculate(4, 6, "multiplication");

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(24.0d, result.getBody().doubleValue(), 0.001d);
    }

    @Test
    public void testDivisionWithSuccess() throws URISyntaxException {
        ResponseEntity<Double> result = calculate(4, 4, "division");

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(1.0d, result.getBody().doubleValue(), 0.001d);
    }

}