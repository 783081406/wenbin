package com.ccjjltx.util;

import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * 单例模式
 *
 * @author ccj
 * @version 1.0
 */
public class ToString {
    private ToString() {
    }

    /**
     * 解析整数
     *
     * @param list list集合
     * @return String
     */
    public static String parse(List<Integer> list) {
        if (list == null) {
            return null;
        }
        String temp = "";
        for (Integer value : list) {
            temp = temp + value.toString() + ",";
        }
        if (temp != "") {
            //分隔最后一个逗号
            return temp.substring(0, temp.lastIndexOf(","));
        }
        return null;
    }

}
