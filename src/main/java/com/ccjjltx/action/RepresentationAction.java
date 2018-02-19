package com.ccjjltx.action;

import com.ccjjltx.dao.GradeDao;
import com.ccjjltx.dao.RepresentationDao;
import com.ccjjltx.domain.Grade;
import com.ccjjltx.domain.Representation;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ccjjltx on 2018/2/19.
 * 对分数异常的相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Controller
@Scope("prototype")
public class RepresentationAction extends ActionSupport {
    @Resource(name = "representationDao")
    private RepresentationDao representationDao;
    @Resource(name = "gradeDao")
    private GradeDao gradeDao;
    private int gid;

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    /**
     * 增加申述
     * @return Success
     */
    public String addRepresentation() {
        Grade db_grade = gradeDao.search(getGid());
        //插入数据
        Representation representation = new Representation();
        representation.setGrade(db_grade);
        representation.setDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        //执行保存
        representationDao.save(representation);
        return SUCCESS;
    }
}
