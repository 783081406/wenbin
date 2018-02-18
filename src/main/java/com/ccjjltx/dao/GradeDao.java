package com.ccjjltx.dao;

import com.ccjjltx.util.ToString;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/18.
 * 对Grade表的相关操作
 *
 * @author ccj
 * @version 1.0
 */
@Service
@Transactional
public class GradeDao {
    @Resource(name = "sessionFactory")
    private SessionFactory factory;

    /**
     * 得到所有参加人员的id
     *
     * @param aid 项目id
     * @return 返回String类型
     */
    public String attendUser(int aid) {
        Session session = factory.getCurrentSession();
        String hql = "select gid from grade where aid=" + aid;
        Query query = session.createSQLQuery(hql);
        List<Integer> list = (List<Integer>) query.list();
        return ToString.parse(list);
    }

}
