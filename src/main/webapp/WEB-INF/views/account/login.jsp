<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <%@include file="/public/header.jspf" %>
    <title> 客流量监测系统- 登录</title>


    <title> - 登录</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html"/>
    <![endif]-->
    <script>if (window.top !== window.self) {
        window.top.location = window.location;
    }</script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <div>

            <%--<h3 class="logo-name">Welcome</h3>--%>

        </div>
        <h3>欢迎使用 微博舆情分析系统</h3>

        <form class="m-t" role="form" action="<%=basePath%>account/login" method="post">
            <div class="form-group">
                <span style="color: red;">${message_login}</span>
            </div>
            <div class="form-group">
                <input id="email" type="email" class="form-control" placeholder="请输入邮箱" name="email" required=""
                       aria-required="true">
            </div>
            <div class="form-group">
                <input id="password" name="password" minlength="2" type="password" placeholder="请输入密码"
                       class="form-control" required="" aria-required="true">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>


            <p class="text-muted text-center">
                <a href="<%=basePath%>account/toForgetPasswordPage">
                    <small>忘记密码了？</small>
                </a> |
                <a href="<%=basePath%>account/toSignupPage">
                    <small>注册一个新账号</small>
                </a>
            </p>

        </form>
    </div>
</div>

<%--<!-- 全局js -->--%>
<%--<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>--%>
<%--<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>--%>


</body>

</html>
