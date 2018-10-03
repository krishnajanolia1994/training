package com.spring.DemoSpring.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@EnableAspectJAutoProxy
@Aspect
public class AopDemo {
	@After("execution(public void show())")
	public void log()
	{
		System.out.println("aspect is called");
	}
	
	

}
