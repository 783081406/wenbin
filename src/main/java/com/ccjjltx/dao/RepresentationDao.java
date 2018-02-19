package com.ccjjltx.dao;

import com.ccjjltx.domain.Representation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

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


}
