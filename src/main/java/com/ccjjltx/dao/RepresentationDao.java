package com.ccjjltx.dao;

import com.ccjjltx.domain.Representation;
import com.ccjjltx.domain.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/19.
 * 对表Representation进行相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Service
@Transactional
public class RepresentationDao {
    @Resource(name = "sessionFactory")
    private SessionFactory factory;

    /**
     * 保存操作
     *
     * @param representation 需要保存的实例化
     */
    public void save(Representation representation) {
        Session session = factory.getCurrentSession();
        session.save(representation);
    }

    /**
     * 得到本人提交的所有的数据记录
     *
     * @param user User实例化
     * @return List实例化
     */
    public List<Representation> getAll(User user) {
        Session session = factory.getCurrentSession();
        String hql = "from Representation representation where representation.grade.user=:user";
        Query query = session.createQuery(hql).setParameter("user", user);
        return (List<Representation>) query.list();
    }



}
