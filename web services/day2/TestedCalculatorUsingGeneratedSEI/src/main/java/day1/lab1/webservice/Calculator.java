package day1.lab1.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface Calculator {

    @WebMethod
    public int add(int num1, int num2) ;

    @WebMethod
    public int sub(int num1, int num2) ;

    @WebMethod
    public int mul(int num1, int num2) ;

    @WebMethod
    public int div(int num1, int num2) ;

}
