<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>
    <link href="<%=basePath%>css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/toastr/toastr.min.css" rel="stylesheet">

    <title>微博情感分析</title>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">

    <!--自己的图表开始-->
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>修改密码</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="graph_flot.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="graph_flot.html#">选项1</a>
                            </li>
                            <li><a href="graph_flot.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal" method="post">
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">原密码</label>
                                        <div class="col-sm-8">
                                            <input type="password" id="oldPassword" name="oldPassword" placeholder="请输入旧密码" required class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-sm-3 control-label">新密码</label>
                                        <div class="col-sm-8">
                                            <input type="password" id="newPassword" name="newPassword" placeholder="请输入新密码" required class="form-control">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-3 col-sm-8">
                                            <button class="btn btn-sm btn-info" id="submit" type="button">提交</button>
                                        </div>
                                    </div>
                            </form>
                        </div>
                </div>
            </div>
        </div>
    </div>
    <!--自己的图表结束-->
</div>


<!-- 自定义js -->
<script src="<%=basePath%>js/content.js?v=1.0.0"></script>
<!-- Toastr script -->
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>

<script type="text/javascript">

    $("#submit").on("click",function () {
        editPassword();
    });

    function editPassword() {
        var oldPassword = $("#oldPassword").val();
        var newPassword = $("#newPassword").val();
        if(oldPassword != null && oldPassword != '' && newPassword != null && newPassword != ''){
            $.ajax({
                url:"/account/editPassword",
                type:"post",
                data:{
                    oldPassword:oldPassword,
                    newPassword:newPassword
                },
                success:function (data) {
                    if(!data.data){
                        toastr.warning('原密码错误', '提示');
                    }else {
                        toastr.success('密码修改成功', '成功');
                    }
                }
            });
        }
    }
</script>

</body>

</html>