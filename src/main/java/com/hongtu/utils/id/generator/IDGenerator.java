package com.hongtu.utils.id.generator;


public class IDGenerator {
	
	private static long ID_FLAG = 1260000000000L;
	private static int SERVER_ID = 1;
	
	/**
	 * Generate auto added id with current time, can distribute on AT MOST 128 machines
	 * @return long id
	 * @throws Exception
	 */
	
	/**
	 * Generate auto added id with current time, can distribute on AT MOST 128 machines
	 * @param serverID every server allocate its uniq serverID, 0 < serverID < 127
	 * @return long id
	 * @throws Exception
	 */
	public final static long generateId(int serverID) throws Exception {
		if (SERVER_ID <= 0)
			throw new Exception("server id is error, please check!");

		long infoid = System.currentTimeMillis() - ID_FLAG;
		infoid = (infoid << 7) | serverID;
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
	
	/**
	 * Get serverID by id
	 * @param id
	 * @return serverID
	 */
	public final static int getServerIdByID(long id) {
		byte serverId = (byte)(id & 0x7F);
		return (int)serverId;
	}
}
