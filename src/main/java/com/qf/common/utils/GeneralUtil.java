package com.qf.common.utils;

/**
 * @author : sin
 * @date : 2023/11/28 20:44
 * @Description : 通用工具类
 */
public class GeneralUtil {
    public static boolean contains(String str,String ...args){
        for (String arg : args) {
            if(str.contains(arg)){
                return true;
            }
        }
        return false;
    }
}