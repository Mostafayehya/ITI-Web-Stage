/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mostafayehya.AOP.day2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author moust
 */
@Aspect
public class CalculatorAspect {

    @Pointcut("execution(* com.mostafayehya.AOP..add(..))")
    public void addOperation() {
    }

    @AfterReturning(returning = "result", pointcut = "addOperation()")
    public void after(JoinPoint joinPoint, Object result) {

        System.out.println("***************************");
        System.out.println("this is the after() pointcut defined in CalculatorAspect  using the reusable pointcut definition");
        System.out.println("***************************");

    }

    @Before("addOperation()")
    public void before(JoinPoint joinPoint) {

        System.out.println("***************************");
        System.out.println("this is the Before() pointcut defined in CalculatorAspect  using the reusable pointcut definition");
        System.out.println("***************************");
    }

//    ====================INTRODUCTION SETTINGS=================================
    @DeclareParents(defaultImpl = MaxCalculatorImpl.class, value = "com.mostafayehya.AOP.day2.CalculatorImpl")
    public MaxCalculator maxCalculator;

    @DeclareParents(defaultImpl = MinCalculatorImpl.class, value = "com.mostafayehya.AOP.day2.CalculatorImpl")
    public MinCalculator minCalculator;

    
    
    
    //    ====================ADVANCED POINTCUT Expressions==================
    
    
    @Pointcut("execution(* main(..))")
    public void mainPointCut(){}
    
    @Pointcut("execution(* get(..))")
    public void allGetMethodsPointCut(){}
    
    @Pointcut("execution(double get(..))")
    public void gettersThatReturnDoublePointcut(){}
    
    @Pointcut("execution(* set(*))")
    public void settersWithSingleParameterPointcut(){}
    
    @Pointcut("execution(* set(*,*))")
    public void settersWithTwoParameterPointcut(){}
    
    @Pointcut("execution(MinCalculator+.new(..))")
    public void minCalculatorConstructorPointcut(){}
    
    @Pointcut("execution(CalculatorImpl.new(..))")
    public void calcultorImplConstructorPointcut(){}
    
    
    @After("execution(* main(..))")
    public void beforeMain() {

        System.out.println("***************************");
        System.out.println("Before main using advanced pointcuts");
        System.out.println("***************************");
    }
    
    @After("allGetMethodsPointCut()")
    public void beforeAllGetterMethods() {

        System.out.println("***************************");
        System.out.println("Before beforeAllGetterMethods using advanced pointcuts");
        System.out.println("***************************");
    }
    
    @After("settersWithTwoParameterPointcut()")
    public void beforeAllSetterMethodsWithTwoParamters() {

        System.out.println("***************************");
        System.out.println("Before beforeAllSetterMethodsWithTwoParamters using advanced pointcuts");
        System.out.println("***************************");
    }
    
    @After("minCalculatorConstructorPointcut()")
    public void beforeMinCalculatorConstructor() {

        System.out.println("***************************");
        System.out.println("Before MinCalculatorConstructor( using advanced pointcuts");
        System.out.println("***************************");
    }
    
    @After("calcultorImplConstructorPointcut()")
    public void beforeCalcultorImplConstructor() {

        System.out.println("***************************");
        System.out.println("Before CalcultorImplConstructor using advanced pointcuts");
        System.out.println("***************************");
    }
    
    
    
    
    
    
}
