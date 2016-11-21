package com.hongtu.utils.file;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * Created by hongtu on 2016/11/21.
 */
public class FileUtils {
    /**
     * 写入文件
     *
     * @param filename
     *            文件名
     * @param text
     *            写入内容
     * @param offset
     *            写入内容的起始位置
     * @param length
     *            写入内容的长度
     * @param charset
     *            字符集
     * @param append
     *            是否追加
     * @return boolean 写入结果
     */
    public static boolean writerFile(String filename, String text, int offset, int length, String charset,
                                     boolean append) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    if (!file.getParentFile().mkdirs()) {
                        return false;
                    }
                }
                if (!file.createNewFile()) {
                    return false;
                }
            }
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(file, append), charset);
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(text, offset, length);
            bw.flush();
            bw.close();
            osw.close();
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 写入文件
     *
     * @param filename
     *            文件名
     * @param text
     *            写入内容
     * @param charset
     *            字符集
     * @param append
     *            是否追加
     * @return boolean 写入结果
     */
    public static boolean writerFile(String filename, String text, String charset, boolean append) {
        return writerFile(filename, text, 0, text.length(), charset, append);
    }

    /**
     * 写入文件
     *
     * @param filename
     *            文件名
     * @param text
     *            写入内容
     * @param append
     *            是否追加
     * @return boolean 写入结果
     */
    public static boolean writerFile(String filename, String text, boolean append) {
        return writerFile(filename, text, 0, text.length(), "GBK", append);
    }
}
