package com.proajax.chapt7.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PerformanceLoggingInterceptor implements MethodInterceptor{

    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // record the start and end time of the method
        long start = System.currentTimeMillis();
        Object returnValue = methodInvocation.proceed();
        long end = System.currentTimeMillis();
        
        
        // create the performance information string
        String className = 
                methodInvocation.getMethod().getDeclaringClass().getName();
        StringBuffer buf = new StringBuffer("\n\n")
            .append("Method ")
            .append(className)
            .append(".")
            .append(methodInvocation.getMethod().getName())
            .append(" executed in ")
            .append(end - start)
            .append(" milliseconds");

        // log to the console for now
        System.out.println(buf.toString());
        
        return returnValue;
    }
}
