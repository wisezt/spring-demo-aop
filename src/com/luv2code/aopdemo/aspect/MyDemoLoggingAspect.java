package com.luv2code.aopdemo.aspect;

import com.luv2code.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
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
	@Pointcut("execution(* com.luv2code.aopdemo.dao.AccountDAO.*(..))")
    public void pointcutReturnListAccounts(){

    }

    @AfterReturning(pointcut = "pointcutReturnListAccounts()", returning = "result")
    public void afterReturningfindAccounts(JoinPoint theJoinPoint, List<Account> result){
	    System.out.println("===>AfterReturning name: afterReturningListAccounts");
        System.out.println("JointPoint: " + theJoinPoint.getArgs());
        System.out.println("Before Modify Result: " + result);

        Account temp1 = result.get(0);
        temp1.setLevel("10");
        temp1.setName("Ting");

        System.out.println("After Modify Result: " + result);

        System.out.println("===>AfterReturning END");

    }

    @AfterThrowing(pointcut = "pointcutReturnListAccounts()", throwing = "theExc")
    public void afterThrowingfindAccounts(JoinPoint theJoinPoint, Throwable theExc){
        System.out.println("===>@AfterThrowing: " + theExc.getMessage());
        System.out.println("===>@AfterThrowing, the exception: " + theExc);
    }


    @After("execution(* com.luv2code.aopdemo.dao.AccountDAO.*(..))")
    public void afterfindAccounts(JoinPoint theJoinPoint){

        System.out.println("===> @After: " + theJoinPoint.getSignature());
    }


}
