package com.xiaohe.dao;

import com.xiaohe.entity.Sc;
import com.xiaohe.utils.PropertiesUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

//数据库操作对象
//使用DBUtils工具类
public class ScDao {
    public void add(Sc sc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "insert into sc(sid,cid,grade) values(?, ?, ?)";
        queryRunner.update(sql,sc.getSid(),sc.getCid(),sc.getGrade());
    }
    public void delete(Integer scid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "delete from sc where scid = ?";
        queryRunner.update(sql,scid);

    }
    public void update(Sc sc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "update sc set grade = ? where scid = ?";
        queryRunner.update(sql,sc.getGrade(),sc.getScid());
    }
    public List<Sc> list(Sc sc) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from sc";
        List<Sc> list = queryRunner.query(sql,new BeanListHandler<>(Sc.class));
        return list;
    }
    public Sc findById(Integer scid) throws Exception {
        QueryRunner queryRunner = new QueryRunner(PropertiesUtils.getDataSourse());
        String sql = "select * from sc where scid = ?";
        Sc sc = queryRunner.query(sql, new BeanHandler<>(Sc.class),scid);
        return sc;
    }

}
