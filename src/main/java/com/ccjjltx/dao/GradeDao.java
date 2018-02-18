package com.ccjjltx.dao;

import com.ccjjltx.domain.Activity;
import com.ccjjltx.domain.Grade;
import com.ccjjltx.util.ToString;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;

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
    @Resource(name = "userDao")
    private UserDao userDao;

    /**
     * 得到所有参加人员的id
     *
     * @param aid 项目id
     * @return 返回String类型
     */
    public String attendUser(int aid) {
        Session session = factory.getCurrentSession();
        String hql = "select id from grade where aid=" + aid;
        Query query = session.createSQLQuery(hql);
        List<Integer> list = (List<Integer>) query.list();
        return ToString.parse(list);
    }

    /**
     * 删除aid的所有数据
     *
     * @param aid Activity主键
     */
    public void deleteAid(int aid) {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String URL = properties.getProperty("url").trim();
            String USER = properties.getProperty("user").trim();
            String PASSWORD = properties.getProperty("password").trim();
            Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "DELETE FROM grade WHERE aid=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, aid);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 保存修改
     *
     * @param attendUsers 用户id
     * @param aid         活动项目id
     */
    public void saveUpdate(List<String> attendUsers, int aid) {
        for (String user : attendUsers) {
            save(Integer.parseInt(user), aid);
        }
    }

    /**
     * 增加，保存
     *
     * @param id
     * @param aid
     */
    private void save(int id, int aid) {
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(inputStream);
            String URL = properties.getProperty("url").trim();
            String USER = properties.getProperty("user").trim();
            String PASSWORD = properties.getProperty("password").trim();
            Class.forName("com.mysql.jdbc.Driver");//1.加载驱动程序
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = "INSERT INTO grade (id, aid) VALUES (?, ?);";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, aid);
            ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据Activity，得到同一活动的所有人员以及分数
     *
     * @param activity 需要查询的实例化
     * @return List数据
     */
    public List<Grade> getThisActivity(Activity activity) {
        Session session = factory.getCurrentSession();
        String hql = "from Grade grade where grade.activity=:activity";
        Query query = session.createQuery(hql).setParameter("activity", activity);
        return (List<Grade>) query.list();
    }

    /**
     * 根据主键得到实例化
     *
     * @param gid 主键
     * @return 实例化
     */
    public Grade search(int gid) {
        Session session = factory.getCurrentSession();
        return (Grade) session.get(Grade.class, gid);
    }

    /**
     * 更新
     *
     * @param grade 需要更新的实例化
     */
    public void update(Grade grade) {
        Session session = factory.getCurrentSession();
        session.update(grade);
    }
}
