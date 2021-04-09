import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import day1.lab1.webservice.sei.Calculator;
import day1.lab1.webservice.sei.CalculatorImplService;

public class CalculatorTest {

    static CalculatorImplService calculatorImplService;
    static Calculator calculator;

    @BeforeAll
    public static void Init() {

        calculatorImplService = new CalculatorImplService();
        calculator = calculatorImplService.getPort(Calculator.class);
    }

    @Test
    public void addTest() {

        assertEquals(calculator.add(1, 1), 2);
    }

    @Test
    public void subTest() {

        assertEquals(calculator.sub(5, 0),5);
    }

    @Test
    public void mulTest() {

        assertEquals(calculator.mul(5, 5), 25);
    }

    @Test
    public void divTest() {

        assertEquals(calculator.div(5, 5), 1);
    }


}
