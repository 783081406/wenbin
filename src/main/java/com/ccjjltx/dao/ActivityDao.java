package com.ccjjltx.dao;

import com.ccjjltx.domain.Activity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * Activity表的相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Service
@Transactional
public class ActivityDao {
    @Resource(name = "sessionFactory")
    private SessionFactory factory;

    /**
     * 得到所有活动信息数据
     *
     * @return List列表
     */
    public List<Activity> getAll() {
        Session session = factory.getCurrentSession();
        String hql = "from Activity activity";
        Query query = session.createQuery(hql);
        return (List<Activity>) query.list();
    }


}
