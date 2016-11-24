package com.hongtu.designpattern.proxy.springAOP.component;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by hongtu on 2016/11/24.
 */
@Component
public class GreetingAroundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        before();
        Object result = methodInvocation.proceed();
        after();
        return result;
    }

    private void after() {
        System.out.println("After Greeting");
    }

    private void before() {
        System.out.println("Before Greeting");
    }
}
