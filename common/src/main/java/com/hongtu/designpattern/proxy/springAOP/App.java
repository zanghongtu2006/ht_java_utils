package com.hongtu.designpattern.proxy.springAOP;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hongtu on 2016/11/24.
 */
public class App {
    public static void main(String[] args) {
//        ProxyFactory proxyFactory = new ProxyFactory();
//        proxyFactory.setTarget(new HelloImpl());
//        proxyFactory.addAdvice(new GreetingBeforeAdvise());
//        proxyFactory.addAdvice(new GreetingAfterAdvice());
//        Hello hello = (Hello) proxyFactory.getProxy();
//        hello.say("Hongtu1");
//
//        ProxyFactory proxyFactory2 = new ProxyFactory();
//        proxyFactory2.setTarget(new HelloImpl());
//        proxyFactory2.addAdvice(new GreetingsBeforeAndAfterAdvice());
//        Hello hello2 = (Hello) proxyFactory2.getProxy();
//        hello2.say("Hongtu2");
//
//        ProxyFactory proxyFactory3 = new ProxyFactory();
//        proxyFactory3.setTarget(new HelloImpl());
//        proxyFactory3.addAdvice(new GreetingAroundAdvice());
//        Hello hello3 = (Hello) proxyFactory3.getProxy();
//        hello3.say("Hongtu3");

        String sprinXMLFile = App.class.getClassLoader().getResource("") + "designpattern/proxy/springAOP/spring.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(sprinXMLFile);
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.say("Hongtu4");

        Greeting greeting2 = (Greeting) context.getBean("greetingProxy2");
        greeting.say("Hongtu4");
        Apology apology = (Apology) greeting2;
        apology.saySorry("Hongtu4");
    }
}
