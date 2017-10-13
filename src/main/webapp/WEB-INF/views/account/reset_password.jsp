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

            <div >
                <form class="form-horizontal m-t" id="signupForm" >
                    <p>重置密码</p>
                    <div class="form-group">
                            <input id="password" name="password" class="form-control" placeholder="请输入新密码" type="password">
                    </div>
                    <div class="form-group">
                            <input id="confirm_password" name="confirm_password" class="form-control" placeholder="请再次输入新密码" type="password">
                    </div>
                    <button type="button" id="edit" class="btn btn-primary block full-width m-b">修改</button>

                    <p class="text-muted text-center"><small>还记得密码？</small><a href="<%=basePath%>account/toLoginPage">点此登录</a>
                    </p>
                </form>

                <div id="success_display" style="display: none;">
                    <h3 style="color: #1c84c6;">重置密码成功，请登录！</h3>
                    <p style="font-size: 15px;"><a href="<%=basePath%>account/toLoginPage">去登陆></a></p>
            </div>
        </div>
    </div>
</div>



<!-- jQuery Validation plugin javascript-->
<script src="<%=basePath%>js/plugins/validate/jquery.validate.min.js"></script>
<script src="<%=basePath%>js/plugins/validate/messages_zh.min.js"></script>

<script>
    $(document).ready(function () {
        $("#edit").on("click",function () {
            resetPassword();
        })
    });

    /**
     * 获取URL参数
     * @param name
     * @returns {null}
     * @constructor
     */
    function getURLParam(name) {
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  unescape(r[2]); return null;
    }

    function resetPassword() {
        var user = {};
        user.email = getURLParam("email");
        var code = getURLParam("code");
        user.password = $("#password").val();
        console.log(user);
        $.ajax({
            url:"/account/resetPassword/"+code,
            type:"post",
            dataType:"json",
            contentType:"application/json",
            data:JSON.stringify(user),
            success:function (data) {
                if(data.code == "001"){
                    $("form").hide();
                    $("#success_display").show();
                }
            }
        })
    }
</script>




</body>

</html>
