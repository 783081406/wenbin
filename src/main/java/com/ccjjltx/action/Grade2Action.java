package com.ccjjltx.action;

import com.ccjjltx.dao.GradeDao;
import com.ccjjltx.dao.UserDao;
import com.ccjjltx.domain.Grade;
import com.ccjjltx.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/19.
 * 活动汇总
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class Grade2Action extends ActionSupport {
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;
    @Resource(name = "userDao")
    private UserDao userDao;

    private List<Grade> result;//存储数据

    public List<Grade> getResult() {
        return result;
    }

    public void setResult(List<Grade> result) {
        this.result = result;
    }

    /**
     * 得到自己参与的项目以及评分
     *
     * @return List列表
     */
    public String getMeGrade() {
        //得到用户名
        String userName = (String) ActionContext.getContext().getSession().get("userName");
        User db_user = userDao.searchUser(userName);//得到实例化
        //得到相关的数据
        List<Grade> list = gradeDao.getMeGrade(db_user);
        setResult(list);
        return SUCCESS;
    }

}
