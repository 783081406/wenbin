package com.ccjjltx.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ccjjltx on 2018/2/18.
 * 评分表
 *
 * @author ccj
 * @version 1.0
 */
@Entity
@Table
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gid;

    @ManyToOne(targetEntity = Activity.class)
    @JoinColumn(name = "aid")
    private Activity activity;
    @OneToOne(targetEntity = User.class)
    @JoinColumn(name = "id")
    private User user;
    private String score;

    public Grade() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (gid != grade.gid) return false;
        if (activity != null ? !activity.equals(grade.activity) : grade.activity != null) return false;
        if (user != null ? !user.equals(grade.user) : grade.user != null) return false;
        return score != null ? score.equals(grade.score) : grade.score == null;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (score != null ? score.hashCode() : 0);
        return result;
    }
}
