/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hongtu.utils.ip;


/**
 *
 * @author Administrator
 */
public class Endianness {

    public static short toInt16(byte[] buffer) throws Exception {
        if (buffer.length < 2) {
            throw new Exception("buffer size less than 2");
        }
        short int16 = 0;
        int16 = (short) (buffer[0] & 0xff);
        int16 |= ((short) buffer[1] << 8) & 0xff00;
        return int16;
    }

    public static int toInt32(byte[] buffer) throws Exception {
        if (buffer.length < 4) {
            throw new Exception("buffer size less than 4");
        }
        int int32 = 0;
        int32 = buffer[0] & 0xff;
        int32 |= ((int) buffer[1] << 8) & 0xff00;
        int32 |= ((int) buffer[2] << 16) & 0xff0000;
        int32 |= ((int) buffer[3] << 24) & 0xff000000;
        return int32;
    }

    public static long toInt64(byte[] buffer) throws Exception {
        if (buffer.length < 8) {
            throw new Exception("buffer size less than 8");
        }
        long int64 = 0;
        int64 = buffer[0] & 0xffL;
        int64 |= ((long) buffer[1] << 8) & 0xff00L;
        int64 |= ((long) buffer[2] << 16) & 0xff0000L;
        int64 |= ((long) buffer[3] << 24) & 0xff000000L;
        int64 |= ((long) buffer[4] << 32) & 0xff00000000L;
        int64 |= ((long) buffer[5] << 40) & 0xff0000000000L;
        int64 |= ((long) buffer[6] << 48) & 0xff000000000000L;
        int64 |= ((long) buffer[7] << 56);
        return int64;
    }
    
    public static boolean toBoolean(byte b) {
    	return b == 1 ? true : false;
    }
    
    
    public static short toInt16(int index, byte[] buffer) throws Exception {
        if (buffer.length < (index + 2)) {
            throw new Exception("buffer size less than " + (index + 2));
        }
        short int16 = 0;
        int16 = (short) (buffer[index] & 0xff);
        int16 |= ((short) buffer[index + 1] << 8) & 0xff00;
        return int16;
    }

    public static int toInt32(int index, byte[] buffer) throws Exception {
        if (buffer.length < (index + 4)) {
            throw new Exception("buffer size less than " + (index + 4));
        }
        int int32 = 0;
        int32 = buffer[index] & 0xff;
        int32 |= ((int) buffer[index + 1] << 8) & 0xff00;
        int32 |= ((int) buffer[index + 2] << 16) & 0xff0000;
        int32 |= ((int) buffer[index + 3] << 24) & 0xff000000;
        return int32;
    }

    public static long toInt64(int index, byte[] buffer) throws Exception {
        if (buffer.length < (index + 8)) {
            throw new Exception("buffer size less than " + (index + 8));
        }
        long int64 = 0;
        int64 = buffer[index] & 0xffL;
        int64 |= ((long) buffer[index + 1] << 8) & 0xff00L;
        int64 |= ((long) buffer[index + 2] << 16) & 0xff0000L;
        int64 |= ((long) buffer[index + 3] << 24) & 0xff000000L;
        int64 |= ((long) buffer[index + 4] << 32) & 0xff00000000L;
        int64 |= ((long) buffer[index + 5] << 40) & 0xff0000000000L;
        int64 |= ((long) buffer[index + 6] << 48) & 0xff000000000000L;
        int64 |= ((long) buffer[index + 7] << 56);
        return int64;
    }
    
    public static boolean toBoolean(int index, byte[] buffer) throws Exception {
    	if (buffer.length < (index + 1)) {
            throw new Exception("buffer size less than " + (index + 1));
        }
    	return buffer[index] == 1 ? true : false;
    }
    

    public static byte[] fromInt16(short value) {
        byte[] buffer = new byte[2];
        buffer[0] = (byte) value;
        buffer[1] = (byte) (value >> 8);
        return buffer;
    }

    public static byte[] fromInt32(int value) {
        byte[] buffer = new byte[4];
        for (int i = 0; i < 4; i++) {
            buffer[i] = (byte) (value >> (8 * i));
        }
        return buffer;
    }

    public static byte[] fromInt64(long value) {
        byte[] buffer = new byte[8];
        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (value >> (8 * i));
        }
        return buffer;
    }
    
    public static byte fromBoolean(boolean value) {
        return value? (byte)1 : (byte)0;
    }
}