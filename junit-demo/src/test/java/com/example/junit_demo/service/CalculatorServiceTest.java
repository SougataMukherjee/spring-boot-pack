package com.example.junit_demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CalculatorServiceTest {

    @Autowired
    private CalculatorService calculatorService;

    @Test
    void testAdd() {
        // Arrange
        int a = 5;
        int b = 3;
        int expectedResult = 8;

        // Act
        int actualResult = calculatorService.add(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "The add method should return the correct sum.");
    }

    @Test
    void testSubtract() {
        // Arrange
        int a = 10;
        int b = 4;
        int expectedResult = 6;

        // Act
        int actualResult = calculatorService.subtract(a, b);

        // Assert
        assertEquals(expectedResult, actualResult, "The subtract method should return the correct difference.");
    }
}
