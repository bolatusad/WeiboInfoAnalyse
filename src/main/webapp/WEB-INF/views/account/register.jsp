<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <%@include file="/public/header.jspf" %>

    <title> 微博舆情分析系统- </title>

    <title> - 注册</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>

            <%--<h3 class="logo-name">Welcome</h3>--%>

        </div>
        <h3>欢迎注册 舆情分析系统</h3>
        <p>创建一个 舆情分析系统普通账户</p>
            <div >
                <form class="form-horizontal m-t" id="signupForm" method="post" action="<%=basePath%>account/signup">
                    <div class="form-group">
                            <input id="email" name="email" class="form-control" placeholder="请输入邮箱" type="email">
                    </div>
                    <div class="form-group">
                            <input id="password" name="password" class="form-control" placeholder="请输入密码" type="password">
                    </div>
                    <div class="form-group">
                            <input id="confirm_password" name="confirm_password" class="form-control" placeholder="请再次输入密码" type="password">
                    </div>
                    <button type="submit" class="btn btn-primary block full-width m-b">注 册</button>

                    <p class="text-muted text-center"><small>已经有账户了？</small><a href="<%=basePath%>account/toLoginPage">点此登录</a>
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>



<!-- jQuery Validation plugin javascript-->
<script src="<%=basePath%>js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=basePath%>js/plugins/validate/messages_zh.min.js"></script>

<!-- 自定义 js -->
<script src="<%=basePath%>js/account/signup.js"></script>

<!-- iCheck -->
<script src="<%=basePath%>js/plugins/iCheck/icheck.min.js"></script>
<script>
    $(document).ready(function () {
        $('.i-checks').iCheck({
            checkboxClass: 'icheckbox_square-green',
            radioClass: 'iradio_square-green',
        });
    });
</script>




</body>

</html>
