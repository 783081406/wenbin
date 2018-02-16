package com.ccjjltx.action;

import com.ccjjltx.dao.UserDao;
import com.ccjjltx.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/16.
 * 干部录入
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class CadreEntryAction extends ActionSupport {
    //得到UserDAO类
    @Resource(name = "userDao")
    private UserDao userDao;
    private List<User> result;//存放所有数据

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    /**
     * 得到所有数据
     *
     * @return List数据
     */
    public String getAllUser() {
        //得到所有数据
        setResult(userDao.getAllUser());
        System.out.println(getResult());
        return SUCCESS;
    }


}
