package com.xiaohe.dao;

import com.xiaohe.entity.Admin;
import com.xiaohe.entity.Student;
import com.xiaohe.entity.Student;
import com.xiaohe.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

//数据库操作对象
//使用DBUtils工具类
public class StudentDao {

    public void add(Student student) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "insert into student(sno,sname,spwd) values(?, ?, ?)";
        queryRunner.update(conn,sql,student.getSno(),student.getSname(),student.getSpwd());
    }
    public void delete(Integer sid) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "delete from student where sid = ?";
        queryRunner.update(conn,sql,sid);

    }
    public void update(Student student) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "update student set sname = ?, sno = ? where sid = ?";
        queryRunner.update(conn,sql,student.getSname(),student.getSno(),student.getSid());
    }
    public List<Student> list(Student student) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from student";
        List<Student> list = queryRunner.query(conn,sql,new BeanListHandler<>(Student.class));
        return list;
    }
    public Student findById(Integer sid) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from student where sid = ?";
        Student student = queryRunner.query(conn,sql, new BeanHandler<>(Student.class),sid);
        return student;
    }
    public Student login(String sno,String pwd) throws Exception {
        Connection conn = PropertiesUtils.getConnection();
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from student where sno = ? and spwd = ?";
        Student stu = queryRunner.query(conn,sql,new BeanHandler<>(Student.class),sno,pwd);
        return stu;
    }


}
