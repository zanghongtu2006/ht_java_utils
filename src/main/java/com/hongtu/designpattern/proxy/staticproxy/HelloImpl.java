package com.hongtu.designpattern.proxy.staticproxy;

/**
 * If we want to do sth. before or after the function say
 * We always use [Proxy]
 * Created by hongtu on 16-11-21.
 */
public class HelloImpl implements Hello {
    @Override
    public void say(String name) {
        System.out.println("Hello! " + name);
    }
}
