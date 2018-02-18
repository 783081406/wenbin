package com.ccjjltx.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by ccjjltx on 2018/2/18.
 * 活动信息表
 *
 * @author ccj
 * @version 1.0
 */
@Entity
@Table
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    private String place;
    private Date stime;
    private Date etime;
    private String pdfpath;

    public Activity() {
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getStime() {
        return stime;
    }

    public void setStime(Date stime) {
        this.stime = stime;
    }

    public Date getEtime() {
        return etime;
    }

    public void setEtime(Date etime) {
        this.etime = etime;
    }

    public String getPdfpath() {
        return pdfpath;
    }

    public void setPdfpath(String pdfpath) {
        this.pdfpath = pdfpath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (aid != activity.aid) return false;
        if (name != null ? !name.equals(activity.name) : activity.name != null) return false;
        if (place != null ? !place.equals(activity.place) : activity.place != null) return false;
        if (stime != null ? !stime.equals(activity.stime) : activity.stime != null) return false;
        if (etime != null ? !etime.equals(activity.etime) : activity.etime != null) return false;
        return pdfpath != null ? pdfpath.equals(activity.pdfpath) : activity.pdfpath == null;
    }

    @Override
    public int hashCode() {
        int result = aid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (place != null ? place.hashCode() : 0);
        result = 31 * result + (stime != null ? stime.hashCode() : 0);
        result = 31 * result + (etime != null ? etime.hashCode() : 0);
        result = 31 * result + (pdfpath != null ? pdfpath.hashCode() : 0);
        return result;
    }
}
