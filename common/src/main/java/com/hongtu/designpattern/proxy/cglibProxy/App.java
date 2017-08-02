package com.hongtu.designpattern.proxy.cglibProxy;

import com.hongtu.designpattern.proxy.dynamicproxy.DynamicProxy;
import com.hongtu.designpattern.proxy.dynamicproxy.Hello;
import com.hongtu.designpattern.proxy.dynamicproxy.HelloImpl;

/**
 * Created by hongtu on 16-11-21.
 */
public class App {
    public static void main(String[] args) {
        Hello helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);
        helloProxy.say("Hongtu");
    }
}
