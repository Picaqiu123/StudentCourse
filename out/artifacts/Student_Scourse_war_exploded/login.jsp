<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./static/css/login.css" />
    <title>学生在线选课系统-登录</title>
</head>
<body>
    <div class="login">
        <div class="title">
            学生在线选课系统
        </div>
        <form action="login" method="post">

        <div class="u">
            <input type="text" name="username" class="uname">
        </div>
        <div class="p">
            
            <input type="password" name="password" class="pwd">
        </div>
        <div class="s">
            <select name="type">
                <option value="">请选择登录类型</option>
                <option value="0">学生</option>
                <option value="1">老师</option>
                <option value="2">管理员</option>
            </select>
        </div>
        <div class="l">

            <button type="submit">登录</button>
        </div>
        <div class="tips" >
            ${erro}
        </div>
    </form>
    <div>
</body>
</html>