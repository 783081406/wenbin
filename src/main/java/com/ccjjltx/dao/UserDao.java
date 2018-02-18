package com.ccjjltx.dao;

import com.ccjjltx.domain.User;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ccjjltx on 2018/2/15.
 * 对User表的增删改查
 *
 * @author ccj
 * @version 1.0
 */
@Service
@Transactional
public class UserDao {
    @Resource(name = "sessionFactory")
    private SessionFactory factory;

    /**
     * 根据用户名得到User
     *
     * @param username 要查询的用户名
     * @return User实例化
     */
    public User searchUser(String username) {
        Session session = factory.getCurrentSession();
        String hql = "from User user where username=:username";
        Query query = session.createQuery(hql).setParameter("username", username);
        return (User) query.uniqueResult();
    }

    /**
     * 根据id得到User
     *
     * @param id 要查询的id号
     * @return User实例化
     */
    public User searchUser(int id) {
        Session session = factory.getCurrentSession();
        return (User) session.get(User.class, id);
    }

    /**
     * 根据用户名搜索用户（支持模糊搜索）
     *
     * @param name 用户名
     * @return List列表
     */
    public List<User> searchUser2(String name) {
        Session session = factory.getCurrentSession();
        String hql = "from User user where user.name like :name";
        Query query = session.createQuery(hql).setParameter("name", "%" + name + "%");
        return (List<User>) query.list();
    }

    /**
     * 验证用户名密码正确与否
     *
     * @param username User实例
     * @param password User实例
     * @return 返回1表示用户名错误，2表示密码错误，3表示正确
     */
    public int checkUser(String username, String password) {
        //得到Session
        User db_user = searchUser(username);
        if (db_user == null) {
            return 1;
        } else if (!db_user.getPassword().equals(password)) {
            return 2;
        }
        return 3;
    }

    /**
     * 得到所有的User
     *
     * @return 返回所有的User
     */
    public List<User> getAllUser() {
        Session session = factory.getCurrentSession();
        String hql = "from User user";
        Query query = session.createQuery(hql);
        return (List<User>) query.list();
    }

    /**
     * 更新信息
     *
     * @param user 需要更新的User
     * @return boolean
     */
    public boolean update(User user) {
        Session session = factory.getCurrentSession();
        boolean result = true;
        try {
            session.update(user);
        } catch (HibernateException e) {
            result = false;
        }
        return result;
    }


}
