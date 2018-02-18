package com.ccjjltx.action;

import com.ccjjltx.dao.ActivityDao;
import com.ccjjltx.domain.Activity;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * 活动信息相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class ActivityAction extends ActionSupport {
    //得到UserDAO类
    @Resource(name = "activityDao")
    private ActivityDao activityDao;

    private List<Activity> result;//存放所有数据

    public List<Activity> getResult() {
        return result;
    }

    public void setResult(List<Activity> result) {
        this.result = result;
    }

    /**
     * 得到所有的数据
     *
     * @return List数据
     */
    public String getAll() {
        //得到所有数据
        setResult(activityDao.getAll());
        return SUCCESS;
    }


}
