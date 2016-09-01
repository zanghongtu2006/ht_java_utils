package com.hongtu.utils.desensitization.md5;

import org.junit.Test;

public class TestMD5Util {
	
	@Test
	public void TestMD5() {
		String source = "hello world!";
		System.out.println(MD5Util.MD5(source));
	}
	
	@Test
	public void saltMD5() {
		String source = "hello world!";
		System.out.println(MD5Util.saltMD5(source, "1234"));
	}
}
