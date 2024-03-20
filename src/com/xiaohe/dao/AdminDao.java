package com.xiaohe.dao;

import com.xiaohe.entity.Admin;
import com.xiaohe.entity.Student;
import com.xiaohe.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import sun.rmi.log.LogInputStream;

import javax.management.Query;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//数据库操作对象
//使用DBUtils工具类
public class AdminDao {
    public void add(Admin admin) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "insert into admin(gzh,gpwd,gname) values(?, ?, ?)";
        queryRunner.update(sql,admin.getGzh(),admin.getGpwd(),admin.getGname());
    }
    public void delete(Integer id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "delete from admin where id = ?";
        queryRunner.update(sql,id);

    }
    public void update(Admin admin) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "update admin set gname = ?,gpwd = ? where id = ?";
        queryRunner.update(sql,admin.getGname(),admin.getGpwd(),admin.getId());
    }
    public List<Admin> list(Admin admin) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from admin";
        List<Admin> list = queryRunner.query(conn,sql,new BeanListHandler<>(Admin.class));
        return list;
    }
    public Admin login(Admin admin) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from admin where gzh = ? and gpwd = ?";
        Admin ad =  queryRunner.query(conn,sql,new BeanHandler<>(Admin.class),admin.getGzh(),admin.getGpwd());
        return ad;
    }

}
