<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>

    <title>用户基本信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <link href="<%=basePath%>css/plugins/sweetalert/sweetalert.css" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>用户基本信息</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-edit" id="edit"></i>
                        </a>
                        <a class="dropdown-toggle" data-toggle="dropdown" href="form_basic.html#">
                            <i class="fa fa-wrench"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="form_basic.html#">选项1</a>
                            </li>
                            <li><a href="form_basic.html#">选项2</a>
                            </li>
                        </ul>
                        <a class="close-link">
                            <i class="fa fa-times"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">邮箱(用户名）</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="email_show"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">昵称</label>
                            <div class="col-sm-8">
                                <div class="show" id="nickname_show"></div>
                                <input type="text" id="nickname" class="form-control edit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">手机号</label>
                            <div class="col-sm-8">
                                <div class="show" id="phone_show"></div>
                                <input type="text" id="phone" class="form-control edit">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">创建时间</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="createTime_show"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校</label>
                            <div class="col-sm-8">
                                <div class="show" id="school_show"></div>
                                <input type="text" id="school" class="form-control edit">
                            </div>
                        </div>
                        <div class="form-group edit">
                            <div class="col-sm-offset-3 col-sm-8">
                                <button class="btn btn-sm btn-info" id="submitUserInfo" type="button">提交</button>
                                <button class="btn btn-sm btn-info" id="cancelEdit" type="button">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Sweet alert -->
<script src="<%=basePath%>js/plugins/sweetalert/sweetalert.min.js"></script>
<!-- Toastr script -->
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>
<script type="text/javascript">

    $(function () {
        initPage();

        bindAction();
    });

    // 对Date的扩展，将 Date 转化为指定格式的String
    // 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，
    // 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
    // 例子：
    // (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
    // (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18
    Date.prototype.Format = function(fmt)
    { //author: meizz
        var o = {
            "M+" : this.getMonth()+1,                 //月份
            "d+" : this.getDate(),                    //日
            "H+" : this.getHours(),                   //小时
            "m+" : this.getMinutes(),                 //分
            "s+" : this.getSeconds(),                 //秒
            "q+" : Math.floor((this.getMonth()+3)/3), //季度
            "S"  : this.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    }

    /**
     * 绑定动作
     */
    function bindAction() {
        //绑定修改个人信息事件
        $("#edit").on("click",function () {
            showEdit();
        });

        //绑定取消事件
        $("#cancelEdit").on("click",function () {
            initPage();
        })

        //绑定提交表单事件
        $("#submitUserInfo").on("click",function () {
            submitUserInfo();
        });


    }

    /**
     * 提交表单信息
     */
    function submitUserInfo() {
        var nickname = $("#nickname").val();
        var phone = $("#phone").val();
        var school = $("#school").val();
        var user = {
            nickname:nickname,
            phone:phone,
            school:school
        }
        swal({
            title: "提示",
            text: "确认修改用户信息么？",
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "取消",
            confirmButtonText: "修改"
        }, function (isConfirm) {
            if(isConfirm) {
                $.ajax({
                    url:"/account/editUserInfo",
                    type:"post",
                    dataType:"json",
                    contentType:"application/json",
                    data:JSON.stringify(user),
                    success:function (data) {
                        if(data.code == "001"){
                            toastr.success('修改成功！', '成功');
                            initPage();
                        }else{
                            toastr.error('修改失败！', '失败');
                        }
                    }
                });
            }

        });

    }

    /**
     * 初始化页面
     */
    function initPage() {
        $.ajax({
            url:"/account/getCurrentUser",
            type:"get",
            dataType:"json",
            success:function (data) {
                console.log(data);
                $("#email_show").text(data.data.email);
                $("#nickname_show").text(data.data.nickname);
                $("#phone_show").text(data.data.phone);
                $("#createTime_show").text(new Date(data.data.createTime).Format("yyyy-MM-dd HH:mm:ss"));
                $.ajax({
                    url:"/school/getSchoolById/"+data.data.school,
                    type:"get",
                    dataType:"json",
                    success:function (dataSchool) {
                        var school = dataSchool.data;
                        $("#school_show").text(school.schoolName);
                    }
                });

            }
        });
        $(".edit").hide();
        $(".show").show();
    }

    /**
     * 展示修改界面
     */
    function showEdit() {
        $.ajax({
            url:"/account/getCurrentUser",
            type:"get",
            dataType:"json",
            success:function (data) {
                $("#email_show").text(data.data.email);
                $("#nickname").val(data.data.nickname);
                $("#phone").val(data.data.phone);
                var createTime = new Date(data.data.createTime).Format("yyyy-MM-dd HH:mm:ss");
                $("#createTime_show").text(createTime);
                $("#school").val(data.data.school);
            }
        });
        $(".edit").show();
        $("#nickname_show").text("");
        $("#phone_show").text("");
        $("#school_show").text("");
        $(".show").hide();
    }

</script>
</body>
</html>