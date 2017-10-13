<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--360浏览器优先以webkit内核解析-->

    <title> - 主页示例</title>

    <link rel="shortcut icon" href="<%=basePath%>favicon.ico">
    <link href="<%=basePath%>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="wrapper wrapper-content">
    <div class="row">
        <div class="col-sm-10">
            <div class="row">
                <div class="col-sm-12">
                    <div class="row row-sm text-center">
                        <div class="col-xs-6">
                            <div class="panel padder-v item">
                                <div class="h1 text-info font-thin h1">user</div>
                                <span class="text-muted text-xs">昵称</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                        <div class="col-xs-6">
                            <div class="panel padder-v item bg-info">
                                <div class="h1 text-fff font-thin h1">13</div>
                                <span class="text-muted text-xs">微博总数</span>
                                <div class="top text-right w-full">
                                    <i class="fa fa-caret-down text-warning m-r-sm"></i>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- 全局js -->
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>js/plugins/layer/layer.min.js"></script>
<!-- Flot -->
<script src="<%=basePath%>js/plugins/flot/jquery.flot.js"></script>
<script src="<%=basePath%>js/plugins/flot/jquery.flot.tooltip.min.js"></script>
<script src="<%=basePath%>js/plugins/flot/jquery.flot.resize.js"></script>
<script src="<%=basePath%>js/plugins/flot/jquery.flot.pie.js"></script>
<!-- 自定义js -->
<script src="<%=basePath%>js/content.js"></script>
</body>

</html>
