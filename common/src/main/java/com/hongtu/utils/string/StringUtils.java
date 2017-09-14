package com.hongtu.utils.string;

import java.util.Locale;

public class StringUtils {

    public static String notNullString(final String valueString) {
        return (null == valueString) ? "" : valueString;
    }

    /**
     * 检查字符串是否为<code>null</code>或空字符串<code>""</code>。
     * <p>
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空, 则返回<code>true</code>
     */
    public static boolean isEmpty(final String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    /**
     * 检查字符串是否是空白：<code>null</code>、空字符串<code>""</code>或只有空白字符。
     * <p>
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param str 要检查的字符串
     * @return 如果为空白, 则返回<code>true</code>
     */
    public static boolean isBlank(final String str) {
        int length;

        if (str == null || (length = str.length()) == 0) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    /**
     * 下划线命名法转换为驼峰命名法
     *
     * @param name 变量名或方法名
     * @return 驼峰命名法的变量名或方法名
     */
    public static String underScode2Camel(String name) {
        int idx = name.indexOf("_");
        if (idx < 0) {
            return name;
        } else if (idx == name.length() - 1) {
            return name.substring(0, name.length() - 1);
        } else {
            name = name.replaceFirst("_" + name.charAt(idx + 1), ("" + name.charAt(idx + 1)).toUpperCase());
            return underScode2Camel(name);
        }
    }

    public static String underScode2Hungary(String name) {
        String camelName = underScode2Camel(name);
        return camelName.replaceFirst("" + name.charAt(0), ("" + name.charAt(0)).toUpperCase());
    }
}
