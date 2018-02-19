package com.ccjjltx.action;

import com.ccjjltx.dao.UserDao;
import com.ccjjltx.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by ccjjltx on 2018/2/19.
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport {
    @Resource(name = "userDao")
    private UserDao userDao;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 更新页面
     *
     * @return Success
     */
    public String update() {
        return SUCCESS;
    }

    /**
     * 更新操作
     *
     * @return Success
     */
    public String saveUpdate() {
        String userName = (String) ActionContext.getContext().getSession().get("userName");//得到用户名
        User db_user = userDao.searchUser(userName);//得到实例化
        db_user.setPassword(getPassword());
        userDao.update(db_user);//更新操作
        return SUCCESS;
    }
}
