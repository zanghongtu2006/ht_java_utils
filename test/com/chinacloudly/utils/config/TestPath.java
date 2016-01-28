package com.chinacloudly.utils.config;

import org.junit.Test;


public class TestPath {
	
	@Test
	public void TestgetCurrentPath() {
		System.out.println(Path.getCurrentPath());
	}
	
	@Test
	public void testGetCurrentPath() {
		System.out.println(Path.getCurrentPath(this.getClass()));
	}
}
