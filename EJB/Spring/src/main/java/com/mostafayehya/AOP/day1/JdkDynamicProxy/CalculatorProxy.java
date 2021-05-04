/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day1.JdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 *
 * @author moust
 */
public class CalculatorProxy implements InvocationHandler {

    Calculator target;
    CalculatorAdvice advice;

    public CalculatorProxy(Calculator target, CalculatorAdvice advice) {
        this.target = target;
        this.advice = advice;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        double result = 0.0;
        double arg0 = (Double) args[0];
        double arg1 = (Double) args[1];

        switch (method.getName()) {

            case "add":
                try {
                advice.before(arg0, " + ", arg1);

                // Using reflection class method instance 
               // result = (double) method.invoke(target, args);

                // Using Custom instance 
              result = target.add(arg0, arg1);
            
            advice.after(result);

            } catch (Exception exception) {
                advice.afterThrowing(exception);
            }
                break;
        }

        return result;
    }
    
  
}
