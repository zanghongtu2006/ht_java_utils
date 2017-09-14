package com.hongtu.code.generator;

import java.util.HashMap;
import java.util.Map;

public class JPAJavaClassMapping {
    static Map<String, String> map = new HashMap<>();

    static {
        map.put("VARCHAR", "String");
        map.put("CHAR", "String");
        map.put("INT", "Integer");
        map.put("TINYINT", "Integer");
        map.put("DATETIME", "Date");
        map.put("BIGINT", "Long");
    }
}
