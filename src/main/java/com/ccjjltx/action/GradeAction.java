package com.ccjjltx.action;

import com.ccjjltx.dao.ActivityDao;
import com.ccjjltx.dao.GradeDao;
import com.ccjjltx.dao.UserDao;
import com.ccjjltx.domain.Activity;
import com.ccjjltx.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * Grade表对应的Action相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class GradeAction extends ActionSupport {
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;
    @Resource(name = "userDao")
    private UserDao userDao;
    @Resource(name = "activityDao")
    private ActivityDao activityDao;
    private JSONArray result;//返回json数据
    private int aid;//项目主键
    private List<String> attendUsers;//接受前台传输过来的参与人员名单

    public JSONArray getResult() {
        return result;
    }

    public void setResult(JSONArray result) {
        this.result = result;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public List<String> getAttendUsers() {
        return attendUsers;
    }

    public void setAttendUsers(List<String> attendUsers) {
        this.attendUsers = attendUsers;
    }

    /**
     * 得到所有参与人员的名字
     *
     * @return json数据
     */
    public String getAttendUser() {
        List<User> list = userDao.attendUser(gradeDao.attendUser(getAid()));
        if (list == null) {
            result = null;
            return SUCCESS;
        }
        result = new JSONArray();
        for (User user : list) {
            JSONObject js = new JSONObject();
            js.put("id", user.getId());
            js.put("name", user.getName());
            result.add(js);
        }
        return SUCCESS;
    }

    /**
     * 获得未参与项目的人员
     *
     * @return json数据
     */
    public String getNoAttendUser() {
        List<User> list = userDao.noAttendUser(gradeDao.attendUser(getAid()));
        if (list == null) {
            result = null;
            return SUCCESS;
        }
        result = new JSONArray();
        for (User user : list) {
            JSONObject js = new JSONObject();
            js.put("name", user.getName());
            js.put("id", user.getId());
            result.add(js);
        }
        return SUCCESS;
    }

    /**
     * 保存更新
     *
     * @return Success
     */
    public String saveUpdate() {
        //先删除aid的所有数据
        gradeDao.deleteAid(getAid());
        if (getAttendUsers() == null) {//如果没有数据，表示全部清空，不用执行下面的方法体
            return SUCCESS;
        }
        gradeDao.saveUpdate(getAttendUsers(), 2);
        result = new JSONArray();
        result.add("1");
        return SUCCESS;
    }

}
