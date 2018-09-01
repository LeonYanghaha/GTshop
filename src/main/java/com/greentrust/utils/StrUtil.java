package com.greentrust.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @description:字符串操作的工具类
 * @author:Yangk.
 * @create:2018-04-08 13:54
 */

public class StrUtil {

    /*   
     * @description:获取传入字符串的MD5
     * @author Yangk. 
     * @date 2018/4/8 13:55
     * @param   
     * @return   
     */
    public static String strToMD5(String str){

        if(str==null || str.equals("")){
            return "" ;
        }

        return  strCommonUtil(str,"MD5");

    }

    /*   
     * @description:将字符串按照传入的方式加密
     * @author Yangk. 
     * @date 2018/4/8 13:57
     * @param   string    明文     algorithm 算法名
     * @return   按照指定的方式加密的结果
     */
    public static String strCommonUtil(String string, String algorithm){
        if (string.isEmpty()) {
            return "";
        }
        MessageDigest hash = null;
        try {
            hash = MessageDigest.getInstance(algorithm);
            byte[] bytes = hash.digest(string.getBytes("UTF-8"));
            String result = "";
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
