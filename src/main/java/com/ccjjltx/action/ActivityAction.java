package com.ccjjltx.action;

import com.ccjjltx.dao.ActivityDao;
import com.ccjjltx.dao.GradeDao;
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
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;
    private List<Activity> result;//存放所有数据
    private int aid;
    private String name;//搜索框提交过来的名字
    private String place;
    private String stime;
    private String etime;
    private String pdfpath;

    public List<Activity> getResult() {
        return result;
    }

    public void setResult(List<Activity> result) {
        this.result = result;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getStime() {
        return stime;
    }

    public void setStime(String stime) {
        this.stime = stime;
    }

    public String getEtime() {
        return etime;
    }

    public void setEtime(String etime) {
        this.etime = etime;
    }

    public String getPdfpath() {
        return pdfpath;
    }

    public void setPdfpath(String pdfpath) {
        this.pdfpath = pdfpath;
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

    /**
     * 搜索数据
     *
     * @return List数据
     */
    public String search() {
        setResult(activityDao.search(getName()));
        return SUCCESS;
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
        Activity db_activity = activityDao.search(getAid());
        //修改数据
        db_activity.setName(getName());
        db_activity.setPlace(getPlace());
        db_activity.setStime(getStime());
        db_activity.setEtime(getEtime());
        //执行更新操作
        activityDao.update(db_activity);
        return SUCCESS;
    }

    /**
     * 增加
     *
     * @return Success
     */
    public String add() {
        return SUCCESS;
    }

    /**
     * 增加  保存
     *
     * @return Success
     */
    public String saveAdd() {
        Activity activity = new Activity();
        //获取前端过来的数据
        activity.setName(getName());
        activity.setPlace(getPlace());
        activity.setStime(getStime());
        activity.setEtime(getEtime());
        activity.setPdfpath(getEtime());
        //执行保存操作
        activityDao.saveAdd(activity);
        return SUCCESS;
    }

    /**
     * 删除操作
     *
     * @return Success
     */
    public String delete() {
        //得到需要删除的实例化
        Activity db_activity = activityDao.search(getAid());
        //先删除关联的grade表的数据
        gradeDao.deleteAid(getAid());
        //执行删除操作
        activityDao.delete(db_activity);
        return SUCCESS;
    }
}
