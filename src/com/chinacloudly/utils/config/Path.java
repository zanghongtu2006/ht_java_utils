package com.chinacloudly.utils.config;

import java.io.File;


public class Path {
	
	public final static String getCurrentPath() {
		String path = System.getProperty("serviceframe.config.path");
		if (path == null || path.equalsIgnoreCase("")) {
			Class<?> caller = getCaller();
			if (caller == null) {
				caller = Path.class;
			}
			path = getCurrentPath(caller);
		}
		return path;
	}
	
	private static Class<?> getCaller() {
		StackTraceElement stack[] = (new Throwable()).getStackTrace();
		if(stack.length < 3) {
			return Path.class;
		}
		String className = stack[2].getClassName();
		try {
			return Class.forName(className);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getCurrentPath(Class<?> cls) {
		String path = cls.getProtectionDomain().getCodeSource().getLocation().getPath();
		path = path.replaceFirst("file:/", "");
		path = path.replaceAll("!/", "");
		if(path.lastIndexOf(File.separator) >= 0){
			path = path.substring(0, path.lastIndexOf(File.separator));
		}
		if(path.substring(0,1).equalsIgnoreCase("/")){
			String osName = System.getProperty("os.name").toLowerCase();
			if(osName.indexOf("window") >= 0){
				path = path.substring(1);
			}
		}
		return path;
	}
}
