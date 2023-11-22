package src.test;

import static org.junit.Assume.assumeTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import src.main.Calculator;

class CalculatorTest {
    Calculator calc;

    @BeforeEach
    void init() {
        calc = new Calculator();
    }

    @AfterAll
    static void close() {
        System.out.println("Os testes terminaram!");
    }

    @BeforeAll
    static void start() {
        System.out.println("Os testes iniciaram!");
    }

    @Test
    @DisplayName("add test")
    void addTest() {
        assertEquals(0, calc.add(0, 0));
        assertEquals(2, calc.add(1, 1));
        assertEquals(1, calc.add(1, 0));
        assertEquals(1, calc.add(0, 1));

        assertEquals(0, calc.add(1, -1));
        assertEquals(-2, calc.add(-1, -1));
        assertEquals(-1, calc.add(0, -1));
        assertEquals(-1, calc.add(-1, 0));
    }

    @Test
    @DisplayName("div test")
    void divideTest() {
        assertEquals(1, calc.divide(1, 1));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(-1, calc.divide(-1, 1));
        //assumeTrue(Double.compare());
        assertEquals(1, calc.divide(3, 2));
        assertEquals(0, calc.divide(1, 2));
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();

        test.start();

        test.init();
        test.addTest();

        test.init();
        test.divideTest();

        test.close();
    }
}
