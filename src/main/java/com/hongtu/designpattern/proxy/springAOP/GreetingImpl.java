package com.hongtu.designpattern.proxy.springAOP;

/**
 * If we want to do sth. before or after the function say
 * We always use [Proxy]
 * Created by hongtu on 16-11-21.
 */
public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("Greeting! " + name);
    }
}
