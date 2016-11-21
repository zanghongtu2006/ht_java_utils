package com.hongtu.utils.ip;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class IpUtil {

	/**
	 * 根据网卡取本机配置的IP
	 * 取第一个网卡
	 * @return
	 * @throws SocketException
	 * @throws UnknownHostException
	 */
	public static String getStrLocalIP() throws SocketException, UnknownHostException {
		String ip = null;
		Enumeration<NetworkInterface> enuNI = NetworkInterface.getNetworkInterfaces();
		begin: while(enuNI.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface)enuNI.nextElement();
			Enumeration<InetAddress> enuAddress = ni.getInetAddresses();
			while(enuAddress.hasMoreElements()) {
				InetAddress address = enuAddress.nextElement();
				if(!address.isSiteLocalAddress()
						&& !address.isLoopbackAddress()
						&& address.getHostAddress().indexOf(":") == -1) {
					ip = address.getHostAddress();
					break begin;
				}
			}
		}

		if(ip == null) {
			InetAddress addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress();
		}
		return ip;
	}
		
	private static long str2Ip(String ip) throws Exception {
		if(ip != null) {
			String[] aryIP = ip.split("\\.");
			byte[] buffer = new byte[4];
			if(aryIP.length == 4) {
				for(int i=0; i<4; i++) {
					short item = Short.parseShort(aryIP[i]);
					buffer[i] = (byte)item;
				}

				return Endianness.toInt32(buffer);
			}
		}

		throw new Exception("can't get local ip");
	}

	public static long Ip2Int(String ip) throws Exception {
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
