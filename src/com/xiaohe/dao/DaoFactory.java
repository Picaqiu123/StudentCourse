package com.xiaohe.dao;

import com.xiaohe.entity.Admin;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//单例模式 + 工厂模式
public class DaoFactory {
    public static DaoFactory factory = new DaoFactory();
    private Map<String,Object> map = new ConcurrentHashMap<>();

    public static DaoFactory getInstance(){
        return factory;
    }
    public AdminDao getAdminDao(){
        AdminDao dao = (AdminDao) map.get("AdminDao");
        if(dao != null){
            return dao;
        }else{
            dao = new AdminDao();
            map.put("Admin",dao);
        }
        return dao;
    }
    public StudentDao getStudentDao(){
        StudentDao dao = (StudentDao) map.get("StudentDao");
        if(dao != null){
            return dao;
        }else{
            dao = new StudentDao();
            map.put("Student",dao);
        }
        return dao;
    }
    public TeacherDao getTeacherDao(){
        TeacherDao dao = (TeacherDao) map.get("TeacherDao");
        if(dao != null){
            return dao;
        }else{
            dao = new TeacherDao();
            map.put("Teacher",dao);
        }
        return dao;
    }
    public CourseDao getCourseDao(){
        CourseDao dao = (CourseDao) map.get("CourseDao");
        if(dao != null){
            return dao;
        }else{
            dao = new CourseDao();
            map.put("Course",dao);
        }
        return dao;
    }
    public ScDao getScDao(){
        ScDao dao = (ScDao) map.get("ScDao");
        if(dao != null){
            return dao;
        }else{
            dao = new ScDao();
            map.put("Sc",dao);
        }
        return dao;
    }

}
