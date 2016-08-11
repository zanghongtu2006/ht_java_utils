package com.hongtu.utils.md5;

import java.security.MessageDigest;

public class MD5Util {
	
	/**
	 * md5 a string 
	 * Usage: saltMD5(sourceString)
	 * @param s sourceString
	 * @return MD5 String with salt
	 */
	public final static String MD5(String s) {
		char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
		try {
			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	/**
	 * md5 a string with salt
	 * md5(s + salt)
	 * Usage: saltMD5(sourceString, saltString)
	 * @param s sourceString
	 * @param salt saltString
	 * @return MD5 String with salt
	 */
	public final static String saltMD5(String s, String salt) {
		return MD5(s + salt);
	}
}
