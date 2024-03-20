package com.xiaohe.dao;

import com.xiaohe.entity.Course;
import com.xiaohe.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

//数据库操作对象
//使用DBUtils工具类
public class CourseDao {
    public void add(Course course) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "insert into course(cname,tid) values( ?, ?)";
        queryRunner.update(sql,course.getCname(),course.getTid());
    }
    public void delete(Integer cid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "delete from course where cid = ?";
        queryRunner.update(sql,cid);

    }
    public void update(Course course) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "update course set cname = ?, tid = ? where cid = ?";
        queryRunner.update(sql,course.getCname(),course.getTid(),course.getCid());
    }
    public List<Course> list(Course course) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from course";
        List<Course> list = queryRunner.query(sql,new BeanListHandler<>(Course.class));
        return list;
    }
    public Course findById(Integer cid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from course where cid = ?";
        Course course = queryRunner.query(sql, new BeanHandler<>(Course.class),cid);
        return course;
    }

}
