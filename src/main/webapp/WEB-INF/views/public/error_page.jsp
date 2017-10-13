<%@ page language="java" contentType="text/html; charset=utf-8"
   pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>

    <title> - 链接错误</title>
    <meta name="keywords" content="">
    <meta name="description" content="">


</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h1>错误</h1>
        <h3 class="font-bold">链接出现错误</h3>

        <div class="error-desc">
            链接出错了...
            <br/>您可以重新重新操作
            <br/><a href="<%=basePath%>/account/toLoginPage" class="btn btn-primary m-t">登录</a>
        </div>
    </div>


    
    

</body>

</html>
