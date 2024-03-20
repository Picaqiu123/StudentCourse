package com.xiaohe.entity;

public class Student {
    private Integer sid;
    private String sno;
    private String sname;
    private String spwd;

    public Student(Integer sid, String sno, String sname, String spwd) {
        this.sid = sid;
        this.sno = sno;
        this.sname = sname;
        this.spwd = spwd;
    }

    public Student() {
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSpwd() {
        return spwd;
    }

    public void setSpwd(String spwd) {
        this.spwd = spwd;
    }
}
