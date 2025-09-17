package com.example.junit_demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.junit_demo.service.CalculatorService;

@SpringBootTest
class JunitDemoApplicationTests {
 	@Autowired
    private CalculatorService calculatorService;
	@Test
	void contextLoads() {
	}
	@Test
    void calculatorServiceAddTest() {
        assertEquals(8, calculatorService.add(5, 3));
    }

    @Test
    void calculatorServiceSubtractTest() {
        assertEquals(6, calculatorService.subtract(10, 4));
    }

    @Test
    void calculatorServiceAddWithNegativeNumbers() {
        assertEquals(-2, calculatorService.add(5, -7));
    }

    @Test
    void calculatorServiceSubtractWithNegativeResult() {
        assertEquals(-5, calculatorService.subtract(5, 10));
    }


}
