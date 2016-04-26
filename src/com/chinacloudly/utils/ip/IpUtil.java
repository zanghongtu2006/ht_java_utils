package com.chinacloudly.utils.ip;


public class IpUtil {
		
	private static long str2Ip(String ip) {
		long result = 0;
		try {
			String[] strs = ip.split("\\.");		
			long a, b, c, d;
			a = Long.parseLong(strs[0]);
			b = Long.parseLong(strs[1]);
			c = Long.parseLong(strs[2]);
			d = Long.parseLong(strs[3]);
			result = (a << 24) | (b << 16) | (c << 8) | d;
		} catch (NumberFormatException e) {
			result = 0;
		}
		return result;
	}

	public static long Ip2Int(String ip) {
		long ipNum = str2Ip(ip);
		return ipNum;
	}

	public static String Int2Ip(long ip) {
		long[] b = new long[4];
		b[0] = (long) ( (ip >> 24) & 0xff);
		b[1] = (long) ( (ip >> 16) & 0xff);
		b[2] = (long) ( (ip >> 8) & 0xff);
		b[3] = (long) (ip & 0xff);

		return  b[0] + "." + b[1] + "." + b[2] +"." + b[3];
	}
	
}
