package day1.lab1.webservice;

import jakarta.jws.WebService;


@WebService(endpointInterface = "day1.lab1.webservice.Calculator")
public class CalculatorImpl implements Calculator{

    @Override
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    @Override
    public int sub(int num1, int num2) {
        return num1 - num2;
    }

    @Override
    public int mul(int num1, int num2) {
        return num1 * num2;
    }

    @Override
    public int div(int num1, int num2) {
        return num1 / num2;
    }



    
    
}
