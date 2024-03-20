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
    <script src="<%=basePath%>static/js/jquery-1.12.4.min.js" type="text/javascript"></script>
    <script src="<%=basePath%>static/js/jquery-validation-1.14.0/jquery.validate.js" type="text/javascript"></script>
    <script type="text/javascript">
        function check(){
            var addForm = $("#addForm").val();
            if(name == null || name == '') {
                $('name').html("学生姓名不能为空！");
                return false;
            }
            if(sno == null || sno == ''){
                $('sno').html("学号不能为空！");
                return false;
            }
            return true;
        }
    </script>
    <title>添加页面</title>
</head>
<body>
<div class="add"></div>
<form id="addForm" action="<%=basePath%>student?method=add" method="post" οnsubmit="return check()">
<table class="tableAdd" >
    <tr>
        <td>学号：</td>
        <td><input type="text" name="sno" required></td>
    </tr>
    <tr>
        <td>姓名：</td>
        <td><input type="text" name="sname" required></td>
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
<FORM id=form1 name=form1
      action="${pageContext.request.contextPath }/memberAction_findMemberInfo.action"
      method=post οnsubmit="return check()">
</form>
</body>
</html>
