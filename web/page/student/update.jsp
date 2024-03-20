<%--
  Created by IntelliJ IDEA.
  User: heqin
  Date: 2022/12/27
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //    jsp获取项目路径(绝对路径)
    String path = request.getContextPath();
    String basePath = request.getScheme()
            + "://" + request.getServerName()
            + ":"
            + request.getServerPort()
            + path
            + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%=basePath%>static/css/style.css" />
    <link rel="stylesheet" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <title>更新页面</title>
</head>
<body>
<div class="add"></div>
<form id="editForm" action="<%=basePath%>student?method=editSubmit" method="post">
    <input type="hidden" name="sid" value="${student.sid}">
    <table class="tableAdd" >
        <tr>
            <td>学号：</td>
            <td><input type="text" name="sno" value="${student.sno}" required></td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="sname" value="${student.sname}" required></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="spwd" value="123456">
            </td>
            <td style="font-size: smaller">学生初始密码为123456</td>
        </tr>

        <tr >
            <td colspan="2" align="center">
                <button type="button" class="edit" onclick="window.location.reload()">
                    <i class="fa fa-refresh"></i>
                    重置
                </button>
                <button class="remove" type="submit" class="submit">
                    <i class="fa fa-save"></i>
                    提交
                </button>
                <button type="button" class="edit" onclick="history.back()">
                    <i class="fa fa-angle-left"></i>
                    返回
                </button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
