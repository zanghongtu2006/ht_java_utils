package com.hongtu.designpattern.proxy.cglibProxy;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法级别的拦截器
 * Created by hongtu on 16-11-21.
 */
public class CGLibProxy implements MethodInterceptor {
    private static CGLibProxy instance = new CGLibProxy();
    private CGLibProxy() {
    }
    public static CGLibProxy getInstance() {
        if (instance == null) {
            synchronized (CGLibProxy.class) {
                if (instance != null) {
                    return instance;
                }
                instance = new CGLibProxy();
            }
        }
        return instance;
    }

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        before();
        Object result = methodProxy.invokeSuper(o, objects);
        after();
        return result;
    }

    private void after() {
        System.out.println("After");
    }

    private void before() {
        System.out.println("Before");
    }
}
