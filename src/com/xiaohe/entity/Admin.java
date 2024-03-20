package com.xiaohe.entity;

public class Admin {
    private Integer id;
    private String gzh;
    private String gpwd;
    private String gname;

    public Admin(Integer id, String gzh, String gpwd, String gname) {
        this.id = id;
        this.gzh = gzh;
        this.gpwd = gpwd;
        this.gname = gname;
    }

    public Admin() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGzh() {
        return gzh;
    }

    public void setGzh(String gzh) {
        this.gzh = gzh;
    }

    public String getGpwd() {
        return gpwd;
    }

    public void setGpwd(String gpwd) {
        this.gpwd = gpwd;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }
}
