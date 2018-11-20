package com.jfmlc.demo.common.utils;

import org.springframework.util.DigestUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author fumei
 * @date 2018-11-20 10:25
 */
public class Md5Util {
    /***
     * MD5加码 生成32位md5码
     */
    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }
    /**
     * 唯一订单id
     * @return
     */
    public static String orderuuidnumber(){
        String date = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String seconds = new SimpleDateFormat("HHmmss").format(new Date());
        return "51"+date+"00001000"+getTwo()+"00"+seconds+getTwo();
    }
    /**
     * 生成末尾随机数
     * @return
     */
    private static String getTwo(){
        Random rad=new Random();

        String result  = rad.nextInt(100) +"";

        if(result.length()==1){
            result = "0" + result;
        }
        return result;
    }

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            System.out.println(orderuuidnumber());
        }

    }


}
