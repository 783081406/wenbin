package com.ccjjltx.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ccjjltx on 2018/2/19.
 * 表Representation
 *
 * @author ccj
 * @version 1.0
 */
@Entity
@Table
public class Representation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    @OneToOne(targetEntity = Grade.class)
    @JoinColumn(name = "gid")
    private Grade grade;
    private String mark;
    private String date;
    private int sign;

    public Representation() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Representation that = (Representation) o;

        if (rid != that.rid) return false;
        if (sign != that.sign) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (mark != null ? !mark.equals(that.mark) : that.mark != null) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = rid;
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (mark != null ? mark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + sign;
        return result;
    }
}