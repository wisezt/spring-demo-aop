package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MyDemoLoggingAspect {

	@Pointcut("execution(* *(..))")
	public void pointCut01(){}


	@Before("pointCut01()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
		

		// display the method signature
		MethodSignature theSig = (MethodSignature) theJoinPoint.getSignature();

		System.out.println("===> Signature:" + theSig);

		// display method arguments
		for (Object obj : theJoinPoint.getArgs()){
			System.out.println("===> this is the argument: " + obj);
		}




	}


}
