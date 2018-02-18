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

    /**
     * 增加User
     *
     * @param user User用户
     * @return 1或者2, 1表示失败,2表示成功
     */
    public int addUser(User user) {
        Session session = factory.getCurrentSession();
        //得到唯一结果，如果结果是null，表示没有相同的用户名，否则表示有相同的用户名返回false
        User db_user = searchUser(user.getUsername());
        if (db_user == null) {//不允许存在相同的用户名
            //持久化user1实例
            session.save(user);
            return 2;
        }
        return 1;
    }

    /**
     * 根据id，得到User，进而删除User
     *
     * @param id User的id号，使用get方法根据主键得到User
     * @return 删除成功得到true，失败返回false
     */
    public boolean deleteUser(int id) {
        Session session = factory.getCurrentSession();
        User db_user = (User) session.get(User.class, id);
        boolean result = true;
        try {
            //删除操作
            session.delete(db_user);
        } catch (HibernateException e) {
            result = false;
        }
        return result;
    }

    /**
     * 参与的项目人员
     *
     * @param attend 参与项目的人员
     * @return List 参与人员
     */
    public List<User> attendUser(String attend) {
        Session session = factory.getCurrentSession();
        String hql = "From User user where id in(" + attend + ")";
        Query query = session.createQuery(hql);
        return (List<User>) query.list();
    }

    /**
     * 未参与的项目人员
     *
     * @param attend 参与项目的人员
     * @return List 未参与人员
     */
    public List<User> noAttendUser(String attend) {
        Session session = factory.getCurrentSession();
        String hql = "From User user where id not in(" + attend + ")";
        Query query = session.createQuery(hql);
        return (List<User>) query.list();
    }
}
