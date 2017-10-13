<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>

    <title>微博详情</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>微博详情</h5>
                </div>
                <div class="ibox-content" id="display_school_info">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">微博ID:</label>

                            <div class="col-sm-8">
                                <p class="form-control-static" id="weiboId"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">用户:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="userId"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">微博内容:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="weiboContent"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">是否为转发微博:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="isForward"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">转发理由:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="reasonOfForward"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">转发数:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="forwardNum"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">点赞数:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="praiseNum"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">评论数:</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="commentNum"></p>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript">

    $(function () {
        getWeboInfo();
    });

    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }

    /**
     * 用于信息的展示
     */
    function getWeboInfo() {
        var weiboId = getUrlParam("weiboId");
        $.ajax({
            url:"/school/getWeiboInfoById?id="+weiboId,
            type:"get",
            dataType:"json",
            success:function (data) {
                if(data.code = "001"){
                    var weiboInfo = data.data;
                    $("#weiboId").html(weiboInfo.id);
                    $("#userId").html(weiboInfo.userId);
                    $("#weiboContent").html(weiboInfo.weiboContent);
                    var temp = weiboInfo.isForward != null && weiboInfo.isForward != '' ? '是':'否';
                    $("#isForward").html(temp);
                    $("#reasonOfForward").html(weiboInfo.reasonOfForward);
                    $("#forwardNum").html(weiboInfo.forwardNum);
                    $("#praiseNum").html(weiboInfo.praiseNum);
                    $("#commentNum").html(weiboInfo.commentNum);
                }
            }
        });
    }

</script>
</body>
</html>