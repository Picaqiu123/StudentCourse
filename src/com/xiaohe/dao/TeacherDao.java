package com.xiaohe.dao;

import com.xiaohe.entity.Teacher;
import com.xiaohe.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

//数据库操作对象
//使用DBUtils工具类
public class TeacherDao {
    public void add(Teacher teacher) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "insert into teacher(tname,tpwd,tzh) values(?, ?, ?)";
        queryRunner.update(sql,teacher.getTname(),teacher.getTpwd(),teacher.getTzh());
    }
    public void delete(Integer tid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "delete from teacher where tid = ?";
        queryRunner.update(sql,tid);

    }
    public void update(Teacher teacher) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "update teacher set tname = ?, tpwd = ? where tid = ?";
        queryRunner.update(sql,teacher.getTname(),teacher.getTpwd(),teacher.getTid());
    }
    public List<Teacher> list(Teacher teacher) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from teacher";
        List<Teacher> list = queryRunner.query(conn,sql,new BeanListHandler<>(Teacher.class));
        return list;
    }
    public Teacher findById(Integer tid) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from teacher where tid = ?";
        Teacher teacher = queryRunner.query(conn,sql, new BeanHandler<>(Teacher.class),tid);
        return teacher;
    }
    public Teacher login(String tzh,String tpwd) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from teacher where tzh = ? and tpwd = ?";
        Teacher te = queryRunner.query(conn,sql,new BeanHandler<>(Teacher.class),tzh,tpwd);
        return te;
    }

}
