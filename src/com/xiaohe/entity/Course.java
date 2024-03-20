package com.xiaohe.entity;

public class Course {
    private String cname;
    private Integer tid;
    private Integer cid;

    public Course(String cname, Integer tid, Integer cid) {
        this.cname = cname;
        this.tid = tid;
        this.cid = cid;
    }

    public Course() {
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }
}
