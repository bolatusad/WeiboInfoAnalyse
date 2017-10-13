<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">

    <%@include file="/public/header.jspf" %>
    <title> 客流量监测系统- 忘记密码</title>


    <title> - 忘记密码</title>
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


        <form class="m-t" role="form" method="post">
            <h3>找回密码</h3>
            <div class="form-group">
                <p style="color: red;" id="message"></p>
            </div>
            <div class="form-group">
                <input id="email" type="email" class="form-control" placeholder="请输入注册邮箱" name="email"/>
            </div>
            <button type="button" id="submit" class="btn btn-primary block full-width m-b">提交</button>
            <p class="text-muted text-center">
                <a href="<%=basePath%>account/toLoginPage">
                    <small>还记得密码? 登录</small>
                </a> |
                <a href="<%=basePath%>account/toSignupPage">
                    <small>注册一个新账号</small>
                </a>
            </p>

        </form>
        <div id="success_display" style="display: none;">
            <h3 style="color: #1c84c6;">提交成功，请登录邮箱查看！</h3>
            <p style="font-size: 15px;"><a href="<%=basePath%>account/toLoginPage">返回></a></p>
        </div>
    </div>

</div>

<%--<!-- 全局js -->--%>
<%--<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>--%>
<%--<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>--%>
<script type="text/javascript">
    $(function () {
        bindAction();
    });

    /**
     * 绑定动作
     */
    function bindAction() {
        $("#submit").on("click",function () {
            submitEmail();
        })
    }

    /**
     * 提交邮箱地址，获取邮件
     */
    function submitEmail() {
        var email = $("#email").val();
        if(email == null || email == ""){
            $("#message").html("请输入注册邮箱！");
            return;
        }
        $.ajax({
            url:"/account/isEmailExist",
            type:"post",
            data:{
                email:email
            },
            success:function (data) {
                if(data){
                    $("#message").html("此邮箱未注册")
                }else {
                    $.ajax({
                        url:"/account/forgetPassword",
                        type:"post",
                        data:{
                            email:email
                        },
                        success:function (data) {
                            if(data.code == "001"){
                                $("form").hide();
                                $("#success_display").show();
                            }
                        }
                    });
                }
            }
        });

    }
</script>

</body>

</html>
