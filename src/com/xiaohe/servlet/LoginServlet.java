package com.xiaohe.servlet;

import com.xiaohe.dao.AdminDao;
import com.xiaohe.dao.DaoFactory;
import com.xiaohe.dao.StudentDao;
import com.xiaohe.dao.TeacherDao;
import com.xiaohe.entity.Admin;
import com.xiaohe.entity.Student;
import com.xiaohe.entity.Teacher;
import com.xiaohe.utils.MD5_Encoding;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
//Servlet来登录页面
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        HttpSession session = req.getSession();

        if(StringUtils.isBlank(userName) || StringUtils.isBlank(password)|| StringUtils.isBlank(type)){
            req.setAttribute("erro","用户名或密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        if(StringUtils.isBlank(type)){
            req.setAttribute("erro","用户名或密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        if(StringUtils.isNotBlank(type)) {
            if ("0".equals(type)) {
                //学生验证
                try {
                    Student stu = DaoFactory.getInstance().getStudentDao().login(userName,password);

                    if(stu != null){
                        //输入账号进入系统
                        session.setAttribute("username",stu);
                        session.setAttribute("type",type);
                        resp.sendRedirect("index.jsp");

                    }else{
                        //用户名或密码错误
                        req.setAttribute("erro","用户名或密码或错误");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if ("1".equals(type)) {
                //老师验证
                try {
                    Teacher te = DaoFactory.getInstance().getTeacherDao().login(userName,password);
                    if(te == null)
                        System.out.println("kong");
                    if(te != null){
                        //输入账号进入系统
                        session.setAttribute("username",te);
                        session.setAttribute("type",type);
                        resp.sendRedirect("index.jsp");

                    }else{
                        //用户名或密码错误
                        req.setAttribute("erro","用户名或密码或错误");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                //管理员验证
                Admin admin = new Admin();
                admin.setGzh(userName);
                admin.setGpwd(password);
                try {
                    Admin admin1 = DaoFactory.getInstance().getAdminDao().login(admin);
                    if(admin1 == null)
                        System.out.println("kong");
                    if(admin1 != null){
                        //输入账号进入系统
                        session.setAttribute("username",admin1);
                        session.setAttribute("type",type);
                        resp.sendRedirect("index.jsp");

                    }else{
                        //用户名或密码错误
                        req.setAttribute("erro","用户名或密码或错误");
                        req.getRequestDispatcher("login.jsp").forward(req,resp);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
