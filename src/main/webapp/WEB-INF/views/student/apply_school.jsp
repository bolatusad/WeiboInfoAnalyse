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
    <link href="<%=basePath%>css/plugins/sweetalert/sweetalert.css" rel="stylesheet">

    <title>申请学校账户</title>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>申请学校账户</h5>
                    <div class="ibox-tools">
                    </div>
                </div>
                <div class="ibox-content" id="weibo_info" style="display: none">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">微博地址</label>

                            <div class="col-sm-8">
                                <p class="form-control-static" id="weibo_address"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">微博昵称</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="weibo_nickname"></p>
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
<script type="text/javascript">
    $(function () {
       //绑定事件
        $("#submitWeiboId").on("click",function () {
            submitWeiboId();
        });

        //初始化页面
        initPage();
    });

    /**
     * 用于初始化展示页面，用户已经绑定微博的显示微博绑定结果，若用户未绑定，则提示用户绑定微博，并展示绑定微博的界面
     */
    function initPage() {
        $.ajax({
            url:"/student/getWeiboUserInfo",
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data.data == null){
                    $("#edit_weibo_info").show();
                    $("#weibo_info").hide();
                }else {
                    $("#weibo_address").html("http://weibo.com/u/"+data.data.weiboId);
                    $("#weibo_nickname").html(data.data.nickname);
                    $("#edit_weibo_info").hide();
                    $("#weibo_info").show();
                }
            }
        });
    }

    /**
     * 提交微博Id并验证
     */
    function submitWeiboId() {
        var weiboId = $("#weiboId").val();
        if(weiboId == null || weiboId == ""){
            return;
        }
        verifyWeiboId(weiboId);

    }

    /**
     * 验证微博
     */
    function verifyWeiboId(weiboId) {
        var weiboUser = {
            weiboId:weiboId
        }
        $.ajax({
            url:"/student/verifyWeiboId",
            type:"get",
            dataType:"json",
            data:{
                weiboId:weiboId
            },
            success:function (data) {
                console.log(data.nickname);
                weiboUser.nickname = data.nickname;
                swal({
                    title: data.nickname+"\n这是您的微博昵称么？",
                    text: "请谨慎核对您的昵称！",
                    type: "info",
                    showCancelButton: true,
                    cancelButtonText: "不是",
                    confirmButtonText: "是的",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function (isConfirm) {
                    if(isConfirm){
                        $.ajax({
                            url:"/student/bindWeibo",
                            type:"post",
                            dataType:"json",
                            contentType:"application/json",
                            data:JSON.stringify(weiboUser),
                            success:function (data) {
                                if(data.code == "001"){
                                    swal("绑定成功！", "您已经成功绑定微博", "success");
                                    initPage();
                                }
                            }
                        });
                    }else {
                        swal("提示", "请再次核对您的微博ID或查看绑定微博教程", "warning");
                    }

                });
            }
        })
    }
</script>
</body>
</html>