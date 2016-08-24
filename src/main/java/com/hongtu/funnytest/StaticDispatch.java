package com.hongtu.funnytest;

/**
 * Created by hongtu_zang on 2016/8/24.
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello guy");
    }

    public void sayHello(Man guy) {
        System.out.println("hello man");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }
}
