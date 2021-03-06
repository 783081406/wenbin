package com.ccjjltx.action;

import com.ccjjltx.dao.GradeDao;
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
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;
    private List<User> result;//存放所有数据
    private int id;
    private String name;
    private String username;
    private String password;
    private String type;

    public List<User> getResult() {
        return result;
    }

    public void setResult(List<User> result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    /**
     * 得到所有数据
     *
     * @return List数据
     */
    public String getAllUser() {
        //得到所有数据
        setResult(userDao.getAllUser());
        return SUCCESS;
    }

    /**
     * 搜索框相关功能
     *
     * @return List数据
     */
    public String searchUser() {
        //根据搜索框传输过来的名字，从DAO层得到所有相关的数据,之后充填数据到前端
        setResult(userDao.searchUser2(getName()));
        return SUCCESS;
    }

    /**
     * 更新User
     *
     * @return SUCCESS或Error
     */
    public String updateUser() {
        return SUCCESS;
    }

    /**
     * 保存更新
     *
     * @return SUCCESS
     */
    public String saveUpdate() {
        try {
            int type_temp = Integer.parseInt(getType());//类型只能是1或者2
            if (type_temp == 1 || type_temp == 2) {
                User db_user = userDao.searchUser(getId());//取User实例化数据
                //更新数据
                db_user.setName(getName());
                db_user.setUsername(getUsername());
                db_user.setPassword(getPassword());
                db_user.setType(type_temp);
                //执行更新
                userDao.update(db_user);
            } else {
                return ERROR;
            }
        } catch (NumberFormatException e) {
            return ERROR;
        }
        return SUCCESS;
    }

    /**
     * 增加信息页面
     *
     * @return SUCCESS
     */
    public String addUser() {
        return SUCCESS;
    }

    /**
     * 增加操作
     *
     * @return Success或Error
     */
    public String saveAdd() {
        try {
            int type_temp = Integer.parseInt(getType());//类型只能是1或者2
            if (type_temp == 1 || type_temp == 2) {
                User user = new User(getName(), getUsername(), getPassword(), type_temp);
                if (userDao.addUser(user) == 2) {
                    return SUCCESS;
                }
            }
        } catch (NumberFormatException e) {
            return ERROR;
        }
        return ERROR;
    }

    /**
     * 删除操作
     *
     * @return delete
     */
    public String deleteUser() {
        //先删除关联的grade的数据
        gradeDao.deleteId(getId());
        //执行删除操作
        userDao.deleteUser(getId());
        return SUCCESS;
    }

}
