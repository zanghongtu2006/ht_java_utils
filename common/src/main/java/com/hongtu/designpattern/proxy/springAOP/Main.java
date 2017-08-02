package com.hongtu.designpattern.proxy.springAOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hongtu on 2016/11/24.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(App.class.getClassLoader().getResource(""));
        ApplicationContext context = new ClassPathXmlApplicationContext(App.class.getClassLoader().getResource("") + "designpattern/proxy/springAOP/spring.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.say("Hongtu4");
    }
}
