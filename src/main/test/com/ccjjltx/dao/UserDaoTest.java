package com.ccjjltx.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by ccjjltx on 2018/2/18.
 * 对UserDao进行测试
 *
 * @author ccj
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class UserDaoTest {
    @Resource(name = "userDao")
    private UserDao userDao;

    @Test
    @Transactional
    public void testAttendUser() {
        int result = userDao.attendUser("1,2").size();
        Assert.assertEquals(2, result);
    }
}
