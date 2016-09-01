package com.hongtu.utils.desensitization.des;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by hongtu_zang on 2016/9/1.
 */
public class DES {
    //KeyGenerator 提供对称密钥生成器的功能，支持各种算法
    private static KeyGenerator keygen;
    //Cipher负责完成加密或解密工作
    private static Cipher cipher;
    //该字节数组负责保存加密的结果
    private static byte[] cipherByte;
    //secrete key
    private static SecretKey deskey;

    public DES(String secretKeyPath) {
        Security.addProvider(new com.sun.crypto.provider.SunJCE());
        try {
            //实例化支持DES算法的密钥生成器(算法名称命名需按规定，否则抛出异常)
            keygen = KeyGenerator.getInstance("AES");
            keygen.generateKey();
            //生成Cipher对象,指定其支持的DES算法
            cipher = Cipher.getInstance("AES");

            deskey = loadSymmetricAESKey(secretKeyPath);
            if(deskey == null) {
                System.exit(0);
            }
            cipher.init(Cipher.ENCRYPT_MODE, deskey);
        } catch (NoSuchAlgorithmException e) {
            System.exit(0);
        } catch (NoSuchPaddingException e) {
            System.exit(0);
        } catch (InvalidKeyException e) {
            System.exit(0);
        } catch (InvalidKeySpecException e) {
            System.exit(0);
        } catch (IOException e) {
            System.exit(0);
        }
    }

    public static String Encryt(String str) throws IllegalBlockSizeException, BadPaddingException {
        byte[] finalbytes = cipher.doFinal(str.getBytes());
        return encodeBASE64(finalbytes);
    }

    /**
     * 对字符串解密
     *
     * @param buff
     * @return
     * @throws InvalidKeyException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public static byte[] Decrypt(byte[] buff) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException {
        // 根据密钥，对Cipher对象进行初始化，DECRYPT_MODE表示加密模式
        cipher.init(Cipher.DECRYPT_MODE, deskey);
        cipherByte = cipher.doFinal(buff);
        return cipherByte;
    }

    public static SecretKey loadSymmetricAESKey(String path)
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException{
        //Read private key from file.
        File keyFile = new File(path);
        FileInputStream keyfis = new FileInputStream(keyFile);
        byte[] encodedPrivateKey = new byte[(int)keyFile.length()];
        keyfis.read(encodedPrivateKey);
        keyfis.close();

        //Generate secret key.
        return new SecretKeySpec(encodedPrivateKey, "AES");
    }

    public static String encodeBASE64(byte[] bytes) {
        BASE64Encoder b64 = new BASE64Encoder();
        return b64.encode(bytes);
    }

    public static byte[] decodeBASE64(String text) throws IOException {
        BASE64Decoder b64=new BASE64Decoder();
        return b64.decodeBuffer(text);
    }

    /**
     * @param args
     * @throws NoSuchPaddingException
     * @throws NoSuchAlgorithmException
     * @throws BadPaddingException
     * @throws IllegalBlockSizeException
     * @throws InvalidKeyException
     */
    public static void main(String[] args) throws Exception {
        String msg ="abc@163.com";

        //加密
//        SecretKey key = loadSymmetricAESKey(Constant.SECRET_KEY_PATH);
        String encontent = DES.Encryt(msg);
        //解密
        byte[] decontent = DES.Decrypt(decodeBASE64(encontent));
        System.out.println("明文是:" + msg + "   " + msg.length());
        System.out.println("加密后:" + encontent + "   " + encontent.length());
        System.out.println("解密后:" + new String(decontent));
    }

}
