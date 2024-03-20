package com.xiaohe.servlet;

import com.xiaohe.dao.DaoFactory;
import com.xiaohe.entity.Student;
import com.xiaohe.utils.MD5_Encoding;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String method = req.getParameter("method");
        if ("list".equals(method)) {
            //列表查询
            try {
                this.list(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("add".equals(method)) {
            try {
                this.add(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("edit".equals(method)) {
            try {
                this.findById(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("editSubmit".equals(method)) {
            try {
                this.editSubmit(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if ("delet".equals(method)) {
            try {
                this.delete(req, resp);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        sname = new String(sname.getBytes("iso8859-1"), "utf-8");
        String spwd = req.getParameter("spwd");
//        对密码进行加密
//        MD5_Encoding md5_encoding = new MD5_Encoding();
//        String spwd2 = md5_encoding.getMD5ofStr(spwd);
        Student student = new Student();
        student.setSno(sno);
        student.setSname(sname);
        student.setSpwd(spwd);
        DaoFactory.getInstance().getStudentDao().add(student);
        //重定向到列表页面
        resp.sendRedirect("<%=basePath%>student?method=list");

    }

    private void list(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        List<Student> list = DaoFactory.getInstance().getStudentDao().list(null);
        req.setAttribute("list", list);
        req.getRequestDispatcher("page/student/list.jsp").forward(req, resp);
    }

    private void findById(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String sid = req.getParameter("sid");
        Student student = DaoFactory.getInstance().getStudentDao().findById(Integer.parseInt(sid));
        req.setAttribute("student", student);
        req.getRequestDispatcher("page/student/update.jsp").forward(req, resp);
    }

    private void editSubmit(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        String sno = req.getParameter("sno");
        String sname = req.getParameter("sname");
        Student student = new Student();
        student.setSno(sno);
        student.setSname(sname);
        student.setSid(sid);
        DaoFactory.getInstance().getStudentDao().update(student);
        resp.sendRedirect("<%=basePath%>student?method=list");

    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String sid = req.getParameter("sid");
        DaoFactory.getInstance().getStudentDao().delete(Integer.parseInt(sid));
        //重定向到列表页面
        resp.sendRedirect("<%=basePath%>student?method=list");
    }
}
