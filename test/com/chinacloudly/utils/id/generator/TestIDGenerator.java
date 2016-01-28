package com.chinacloudly.utils.id.generator;

import java.util.Date;

import org.junit.Test;

import com.chinacloudly.utils.id.generator.IDGenerator;

public class TestIDGenerator {

	@Test
	public void testIDGenerator() throws Exception {
		System.out.println(IDGenerator.generateId(1));
	}
	
	@Test
	public void testGetTimeById() throws Exception {
		long id = IDGenerator.generateId(1);
		long time = IDGenerator.getTimeByID(id);
		System.out.println(time);
		System.out.println(new Date(time));
	}
	
	@Test
	public void testGetServerIdByID() throws Exception {
		long id = IDGenerator.generateId(12);
		int serverID = IDGenerator.getServerIdByID(id);
		System.out.println(serverID);
	}
}
