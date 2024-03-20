<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: heqin
  Date: 2022/12/27
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //jsp获取项目路径(绝对路径)
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
    <title>列表查询</title>
    <link rel="stylesheet" href="<%=basePath%>static/css/style.css" />
    <link rel="stylesheet" href="<%=basePath%>static/css/font-awesome-4.7.0/css/font-awesome.min.css" />
    <script src="<%=basePath%>static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function(){
            $('.remove').click(function(){
                if(confirm("确定删除吗？")){
                    window.location.href="${basePath}student?method=delete&id="+$(this).attr("key");
                }
            })
        })
    </script>
</head>
<body>
<div class="condition">
    用户名： <input type="text">
    账号：   <input type="text">
    <button>
        <i class="fa fa-search"></i>
        查询
    </button>
    <button onclick="window.location.href='page/student/add.jsp'">
        <i class="fa fa-plus"></i>
        新增
    </button>
</div>
<div class="tableContent">
<table class="tableList">
    <thead>
    <tr>
        <th>学生ID</th>
        <th>学号</th>
        <th>姓名</th>
        <th >操作列</th>
    </tr>
    </thead>
    <tbody style=" overflow: auto;">
    <c:forEach items="${list}" var="student">
    <tr>
        <td>${student.sid}</td>
        <td>${student.sno}</td>
        <td>${student.sname}</td>
        <td>
            <button class="edit" type="button" onclick="window.location.href='<%=basePath%>student?method=edit&sid=${student.sid}'">
                <i class="fa fa-edit"></i>
                修改
            </button>
            <button class="remove" type="button" key="${student.sid}">
                <i class="fa fa-remove"></i>
                删除
            </button>
        </td>
    </tr>
    </c:forEach>

    <table class="page">
        <td style="text-align: center;">
            <button>首页</button>
            <button>上一页</button>
            <button>下一页</button>
            <button>尾页</button>
            <input type="text" class="page-no" name="pageNo" />
            <button>跳转</button>
        </td>
        </tbody>
    </table>
</table>
</div>
</body>
</html>
