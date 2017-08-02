package com.hongtu.designpattern.proxy.springAOP;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by hongtu on 2016/11/24.
 */
public class GreetingBeforeAdvise implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before");
    }
}
