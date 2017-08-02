package com.hongtu.utils.id.generator;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

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
		int origServerID = 12;
		long id = IDGenerator.generateId(origServerID);
		int serverID = IDGenerator.getServerIdByID(id);
		assertEquals(origServerID, serverID);
	}
}
