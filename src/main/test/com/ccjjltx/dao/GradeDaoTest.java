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
 * 对GradeDao进行测试
 *
 * @author ccj
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:beans.xml")
public class GradeDaoTest {
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;

    @Test
    @Transactional
    public void testAttendUser() {
        //得到项目id为1的参与人员，测试的时候的数据参与人员为1,2
        String result = gradeDao.attendUser(1);
        Assert.assertEquals("1,2", result);
    }
}
