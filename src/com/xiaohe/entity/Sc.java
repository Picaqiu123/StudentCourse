package com.xiaohe.entity;

public class Sc {
    private Integer scid;
    private String cid;
    private Integer sid;
    private Integer grade;

    public Sc(Integer scid, String cid, Integer sid,  Integer grade) {
        this.scid = scid;
        this.cid = cid;
        this.sid = sid;
        this.grade = grade;
    }

    public Sc() {
    }

    public Integer getScid() {
        return scid;
    }

    public void setScid(Integer scid) {
        this.scid = scid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
