package com.proajax.chapt7.aop;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import uk.ltd.getahead.dwr.WebContext;
import uk.ltd.getahead.dwr.WebContextFactory;

public class RoleLoggingInterceptor implements MethodInterceptor {
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        
        // get the WebContext from DWR to get the HttpServletRequest
        WebContext context = WebContextFactory.get();
        HttpServletRequest request = context.getHttpServletRequest();
        
        // log actions performed by "trainee-role" role
        if(request.isUserInRole("trainee-role")) {
            StringBuffer buf = new StringBuffer();
            buf.append("\nUser ")
            .append(request.getUserPrincipal().getName())
            .append(" is accessing ")
            .append(methodInvocation.getMethod()
                                                .getDeclaringClass().getName())
            .append(".")
            .append(methodInvocation.getMethod().getName())
            .append( " at ")
            .append(new Date().toString());
            
            System.out.println(buf.toString());
        }
        
        // continue by allowing the method to execute
        Object obj = methodInvocation.proceed();
        
        // return any return values from the method
        return obj;
    }
}
