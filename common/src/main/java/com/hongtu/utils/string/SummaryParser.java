package com.hongtu.utils.string;

/**
 * 摘要
 */
public class SummaryParser {
	
	private static final int SUMMARY_LENGTH = 256;
	
	/**
     * 去除info里content 所有html字符
     *  截取字符串长度256
     * @param sourceStr
     * @return
     */
    public static String getSummary(String sourceStr) {
        if(StringUtils.isBlank(sourceStr)){
            return "";
        }
        sourceStr= removeHTML(sourceStr);
        sourceStr = sourceStr.trim().replaceAll("\t", " ").replaceAll("\n", " ").replaceAll("\r", " ").replaceAll("&nbsp;", " ").replaceAll("\\s{1,}", " ");
        if(sourceStr.length() > SUMMARY_LENGTH) {
            sourceStr = sourceStr.substring(0, SUMMARY_LENGTH);
        }
        return sourceStr;
    }

    /**
     * 除去所有html tag
     *
     * @param source
     * @return
     */
    public static String removeHTML(String source) {
        if (source == null || source.length() == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        Character IN = '<', OUT = '>';
        Character currentState = OUT;
        int currentIndex = 0, nextIndex = -1;

        for (Character c : source.toCharArray()) {
            currentIndex++;
            if (currentIndex >= nextIndex)
                nextIndex = -1;
            if (currentState == OUT && c != OUT && c != IN && c != '\"') {
                if (c == '&') {
                    nextIndex = checkInHTMLCode(source, currentIndex);
                    if (nextIndex > -1)
                        nextIndex = currentIndex + nextIndex;
                }
                if (nextIndex == -1)
                    sb.append(c);
            }
            if (c == OUT)
                currentState = OUT;
            if (c == IN)
                currentState = IN;
        }
        return sb.toString();
    }


    /**
     * RemoveHTML的辅助方法，用于检测是否遇到HTML转义符，如:&nbsp;
     *
     * @param source
     * @param start
     * @return
     */
    private static int checkInHTMLCode(String source, int start) {
        int MAX_HTMLCODE_LEN = 10;
        int index = 0;
        String substr;
        if ((source.length() - start - 1) < MAX_HTMLCODE_LEN)
            substr = source.substring(start);
        else {
            substr = source.substring(start, start + MAX_HTMLCODE_LEN);
        }
        for (Character c : substr.toCharArray()) {
            index++;
            if (index > 1 && c == ';')
                return index + 1;
            if (c > 'z' || c < 'a')
                return -1;
        }
        return -1;
    }
}
