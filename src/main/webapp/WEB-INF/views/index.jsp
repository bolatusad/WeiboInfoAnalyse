<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">



    <title> 微博舆情分析系统- 主页-学校</title>

    <meta name="keywords" content="">
    <meta name="description" content="">

    <!--[if lt IE 9]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="<%=basePath%>favicon.ico"> <link href="<%=basePath%>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">

</head>
<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">微博舆情分析系统</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">舆情
                    </div>
                </li>
                <!-- 自己的菜单开始-->
                <li class="line dk"></li>
                <li class="hidden-folded padder m-t m-b-sm text-muted text-xs">
                    <span class="ng-scope">分类</span>
                </li>
                <li>
                    <a class="J_menuItem" href="<%=basePath%>school/getIndexContent">
                        <i class="fa fa-home"></i>
                        <span class="nav-label">主页</span>
                    </a>
                </li>
                <li>
                    <a href="#">
                        <i class="fa fa fa-bar-chart-o"></i>
                        <span class="nav-label">统计分析</span>
                        <span class="fa arrow"></span>
                    </a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>school/toStudentListPage">学生列表</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>school/toStudentEmotionPage">学生微博情感分析</a>
                        </li>
                        <li>
                            <a class="J_menuItem" href="<%=basePath%>school/toPage?page=school/student_sensitive">敏感词分析结果</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="mailbox.html"><i class="fa fa-envelope"></i> <span class="nav-label">基本配置</span><span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li><a class="J_menuItem" href="<%=basePath%>school/toSchoolInfoPage">学校基本信息</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>school/toEditPasswordPage">修改密码</a>
                        </li>
                        <li><a class="J_menuItem" href="<%=basePath%>student/toPage?page=account/user_info">账户基本信息</a>
                        </li>
                    </ul>
                </li>
                <li class="line dk"></li>
            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>
                    <%--<form role="search" class="navbar-form-custom" method="post" action="search_results.html">--%>
                        <%--<div class="form-group">--%>
                            <%--<input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">--%>
                        <%--</div>--%>
                    <%--</form>--%>
                </div>
                <ul class="nav navbar-top-links navbar-right">

                    <li class="dropdown">
                        <a class="dropdown-toggle count-info" data-toggle="dropdown" href="#">
                            <i class="fa fa-user"></i>
                        </a>
                        <ul class="dropdown-menu dropdown-alerts">
                            <li>
                                <a href="<%=basePath%>student/toPage?page=account/user_info">
                                    <div>
                                        <i class="fa fa-list fa-fw"></i> 个人信息
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="<%=basePath%>account/logout">
                                    <div>
                                        <i class="fa fa-sign-out fa-fw"></i> 退出
                                    </div>
                                </a>
                            </li>
                            <li class="divider"></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
        <div class="row J_mainContent" id="content-main">
            <iframe id="J_iframe" width="100%" height="100%" src="<%=basePath%>school/getIndexContent" frameborder="0" data-id="index_v1.html" seamless></iframe>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->
<!-- 全局js -->
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="<%=basePath%>js/hAdmin.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=basePath%>js/index.js"></script>

<!-- 第三方插件 -->
<script src="<%=basePath%>js/plugins/pace/pace.min.js"></script>

<script type="text/javascript">
    //设置bootstrap 下拉菜单，鼠标经过自动展开，鼠标移开自动关闭
    $('li.dropdown').mouseover(function(){
           $(this).addClass('open');
        })
        .mouseout(function(){
            $(this).removeClass('open');
        });
</script>
</body>
</html>
