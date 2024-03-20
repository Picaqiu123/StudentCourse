<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

    <title>学生选课系统主页</title>
    <script type="text/javascript">
        $(function(){
            $('.menux p').click(function(){
                $(this).siblings('ul').slideUp(200);
                $(this).next('ul').slideToggle(200);
            });
            $('.menux ul a').click(function(){
                $('iframe').attr("src",$(this).attr("url"));
                $('.menu_title').html($(this).attr('title'));
            });

            $('.logout').click(function(){
                if(confirm("确定要退出吗？")) {
                    window.location.href = 'logout';
                }
            });
        })
    </script>
</head>
<body>
    <div class="header">
        <div class="logo">学生在线选课系统</div>

        <div class="user">
            <i class="fa fa-caret-down point"></i>
            <i class="fa fa-user"></i>
             管理员
             <ul>
                <li><a href="javascript:void(0)">修改密码</a></li>
                <li><a href="javascript:void(0)">个人信息</a></li>
                <li><a href="javascript:void(0)" class="logout">退出登录</a></li>
             </ul>
        </div>
    </div>
    <div class="left">
        <div class="title">
            <i class="fa fa-home"></i>
            系统功能
        </div>
        <div class="menux">
            <c:if test="${type == 2}">
            <p>
                <i class="fa fa-info-circle"></i>
                管理员权限
                <i class="fa fa-angle-right point"></i>
            </p>
            <ul>
                <li>

                <a href="javascript:void(0);" url="<%=basePath%>student?method=list" title="学生列表">
                    <i class="fa fa-caret-right"></i>
                    学生管理
                </a>
                </li>
                <li>
                    <a href="javascript:void(0);" url="<%=basePath%>student?method=add" title="添加学生">
                        <i class="fa fa-caret-right"></i>
                        老师管理
                    </a>
                </li>
                <li>
                    <a href="javascript:void(0);" url="3.html" title="功能3">
                        <i class="fa fa-caret-right"></i>
                        课程管理
                    </a>
                </li>
            </ul>
            </c:if>
            <c:if test="${type == 1}">
            <p>
                <i class="fa fa-info-circle"></i>
                老师权限
                <i class="fa fa-angle-right point"></i>
            </p>
            <ul>
                <li>
                    <a href="javascript:void(0);" url="1.html">
                        <i class="fa fa-caret-right"></i>
                        查询统计
                    </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" url="2.html">
                            <i class="fa fa-caret-right"></i>
                            评分管理
                        </a>
                    </li>

            </ul>
            </c:if>
            <c:if test="${type == 0}">
            <p>
                <i class="fa fa-info-circle"></i>
                学生权限
                <i class="fa fa-angle-right point"></i>
            </p>
            <ul>
                <li>
                    <a href="javascript:void(0);" url="1.html">
                        <i class="fa fa-caret-right"></i>
                        查询课程
                    </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" url="2.html">
                            <i class="fa fa-caret-right"></i>
                            修改课程
                        </a>
                    </li>
                    <li>
                        <a href="javascript:void(0);" url="3.html">
                            <i class="fa fa-caret-right"></i>
                            修改个人信息
                        </a>
                    </li>
            </ul>
            </c:if>
        </div>
        <div ></div>
    </div>
    <div class="main">
        <div class="location">
            <i class="fa fa-home"></i>
            <span class="menu_title">用户管理</span>
        </div>
        <iframe src="<%=basePath%>student?method=list" width="100%" height="98%" frameborder="0px"></iframe>
    </div>
</body>
</html>