package com.hongtu.designpattern.proxy.springAOP.component;

import com.hongtu.designpattern.proxy.springAOP.Greeting;
import org.springframework.stereotype.Component;

/**
 * If we want to do sth. before or after the function say
 * We always use [Proxy]
 * Created by hongtu on 16-11-21.
 */
@Component
public class GreetingImpl implements Greeting {
    @Override
    public void say(String name) {
        System.out.println("Greeting! " + name);
    }
}
