package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Aspect
public class MyDemoLoggingAspect {

	@Pointcut("execution(* *(..))")
	public void pointCut01(){}


//	@Before("pointCut01()")
//	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
//
//
//
//	}

    // Add the pointcut for returning the list of Accounts
	@Pointcut("execution(* com.luv2code.aopdemo.MainDemoApp.*(..))")
    public void pointcutReturnListAccounts(){

    }

    @AfterReturning(pointcut = "pointcutReturnListAccounts()", returning = "result")
    public void afterReturningListAccounts(JoinPoint theJoinPoint, List<Account> result){
	    System.out.println("===>AfterReturning name: afterReturningListAccounts");
        System.out.println("JontPoint: " + theJoinPoint.getArgs());
        System.out.println("Reuslt: " + result);
        System.out.println("===>AfterReturning END");

    }



}
