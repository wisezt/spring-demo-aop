package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {

	@Pointcut("execution(* *(..))")
	public void pointCut01(){}



	// this where add all of our related advices for logging
	
	// let's start with an @Before advice
	
	//@Before("execution(public * add*(com.luv2code.aopdemo.Account))")
	
	// wildcard cannot represent '.' (dot)
	@Before("pointCut01()")
	public void beforeAddAccountAdvice(){
		
		System.out.println("\n=======>>> Executing @Before advice on method() Which the return type is boolean");
	}


//	@Before("execution(* *(..))")
//	public  void beforeAddAccountAdvice2(){
//		System.out.println("\n=======>>> This is the beforeAddAccountAdvice2!!! ");
//
//
//	}
//
//    	@Before("execution(void *(..))")
//	public  void beforeAddAccountAdviceReturnVoid(){
//		System.out.println("\n=======>>> This is the beforeAddAccountAdviceReturnVoid!!! ");
//	}

}
