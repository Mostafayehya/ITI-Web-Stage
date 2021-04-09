package day1.lab1.webservice;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.Use;
@WebService(name = "This is my cool calculator web services",serviceName = "BigCalculator", targetNamespace = "bigCalculatorNameSpace")
@SOAPBinding(style = Style.RPC,use = Use.ENCODED,parameterStyle = ParameterStyle.WRAPPED)
public interface Calculator {

    @WebMethod(operationName = "MyBigAdd")
    public int add(@WebParam(name  = "firstIntegerInAdd") int num1, int num2) ;

    @WebMethod
    public int sub(int num1, int num2) ;

    @WebMethod
    public int mul(int num1, int num2) ;

    
    @WebMethod(exclude = true)
    public int div(int num1, int num2) ;

}
