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

    /**
     * 根据aid搜索
     *
     * @param aid 主键
     * @return 实例化
     */
    public Activity search(int aid) {
        Session session = factory.getCurrentSession();
        return (Activity) session.get(Activity.class, aid);

    }

    /**
     * 根据项目名得到List数据
     *
     * @param name 项目名
     * @return List数据
     */
    public List<Activity> search(String name) {
        Session session = factory.getCurrentSession();
        String hql = "From Activity activity where activity.name like :name";
        Query query = session.createQuery(hql).setParameter("name", "%" + name + "%");
        return (List<Activity>) query.list();
    }

    /**
     * 更新
     *
     * @param activity Activity修改实例化
     */
    public void update(Activity activity) {
        Session session = factory.getCurrentSession();
        session.update(activity);
    }

    /**
     * 保存数据
     *
     * @param activity 需要保存的实例化
     */
    public void saveAdd(Activity activity) {
        Session session = factory.getCurrentSession();
        session.save(activity);
    }

}
