package com.hongtu.utils.string;

import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void test2Camel() {
        System.out.println(StringUtils.underScode2Camel("hello_world_war_"));
    }

    @Test
    public void test2Hungary() {
        System.out.println(StringUtils.underScode2Hungary("hello_world_war_"));
    }
}
