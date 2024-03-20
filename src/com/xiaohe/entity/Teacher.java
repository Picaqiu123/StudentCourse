package com.xiaohe.entity;

public class Teacher {
    private String tname;
    private Integer tid;
    private String tpwd;
    private String tzh;

    public Teacher(String tname, Integer tid, String tpwd, String tzh) {
        this.tname = tname;
        this.tid = tid;
        this.tpwd = tpwd;
        this.tzh = tzh;
    }

    public Teacher() {
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTpwd() {
        return tpwd;
    }

    public void setTpwd(String tpwd) {
        this.tpwd = tpwd;
    }

    public String getTzh() {
        return tzh;
    }

    public void setTzh(String tzh) {
        this.tzh = tzh;
    }

}
