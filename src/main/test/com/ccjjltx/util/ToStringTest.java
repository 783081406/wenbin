package com.ccjjltx.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * 测试ToString
 *
 * @author ccj
 * @version 1.0
 */
public class ToStringTest {
    /**
     * 验证：输入为null的时候是否输出为null
     */
    @Test
    public void testParse1() {
        String result = ToString.parse(null);
        Assert.assertNull(result);
    }

    /**
     * 验证：是否能准确数据
     */
    @Test
    public void testParse2() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        Assert.assertEquals("1,2",ToString.parse(list));
    }

}
