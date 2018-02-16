package com.ccjjltx.action;

import com.ccjjltx.dao.UserDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ccjjltx on 2018/2/15.
 * 登录,注销
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class LoginAction extends ActionSupport {
    //登录的用户名
    private String username;
    //登录的密码
    private String password;
    //验证的结果信息如果错误将会返回给首页
    private String result;
    //得到UserDAO类
    @Resource(name = "userDao")
    private UserDao userDao;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 验证用户登录
     *
     * @return 返回success或者error，分别打包成json和redict
     */
    public String checkForntLogin() {
        if (getUsername() != null && getPassword() != null) {
            int iResult = userDao.checkUser(getUsername(), getPassword());
            switch (iResult) {
                case 1:
                    setError("用户名错误！");
                    return ERROR;
                case 2:
                    setError("密码错误！");
                    return ERROR;
                default:
                    setSession();
                    return SUCCESS;
            }
        }
        return "first";
    }

    /**
     * 设置错误信息
     *
     * @param message 错误信息
     */
    public void setError(String message) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", message);
        JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
        result = json.toString();//给result赋值，传递给页面
    }

    //验证通过的时候设置Session
    public void setSession() {
        ActionContext.getContext().getSession().put("userName", getUsername());
    }

    //退出登录删除Session
    public void removeSession() {
        ActionContext.getContext().getSession().remove("userName");
    }
}
