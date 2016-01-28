package com.chinacloudly.utils.id.generator;


public class IDGenerator {
	
	private static long ID_FLAG = 1260000000000L;
	private static long SERVER_ID = 1L;
	
	/**
	 * Generate auto added id with current time, can distribute on AT MOST 128 machines
	 * @return long id
	 * @throws Exception
	 */
	public final static long generateId() throws Exception {
		if (SERVER_ID <= 0)
			throw new Exception("server id is error, please check!");

		long infoid = System.currentTimeMillis() - ID_FLAG;
		infoid = (infoid << 7) | SERVER_ID;
		Thread.sleep(1);
		return infoid;
	}
	
	/**
	 * Get time by id
	 * @param id
	 * @return long timeMilis
	 */
	public final static long getTimeByID(long id) {
		long timeMilis = (id >> 7) + ID_FLAG;
		return timeMilis;
	}
}
