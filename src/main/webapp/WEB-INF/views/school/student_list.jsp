<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>
    <link href="<%=basePath%>css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <title>基本信息</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-sm-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>学生列表</h5>
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
                <div class="ibox-content" id="display_school_info">
                        <!-- Example Pagination -->
                        <div class="example-wrap">
                            <div class="example">
                                <table id="table"
                                       <%--data-toggle="table"--%>
                                       <%--data-url="<%=basePath%>school/getStudentList"--%>
                                       <%--data-query-params="queryParams"--%>
                                       <%--data-mobile-responsive="true"--%>
                                       <%--data-pagination="true"--%>
                                       <%--data-icon-size="outline"--%>
                                       <%--data-page-list="[5,10, 25, 50, 100, ALL]"--%>
                                       <%--data-search="true"--%>
                                >
                                    <%--<thead>--%>
                                    <%--<tr>--%>
                                        <%--&lt;%&ndash;<th data-field="state" data-checkbox="true"></th>&ndash;%&gt;--%>
                                        <%--<th data-field="email">邮箱</th>--%>
                                        <%--<th data-field="nickname">昵称</th>--%>
                                        <%--<th data-field="createTime">创建时间</th>--%>
                                    <%--</tr>--%>
                                    <%--</thead>--%>
                                </table>
                            </div>
                        </div>
                        <!-- End Example Pagination -->
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap table -->
<script src="<%=basePath%>js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="<%=basePath%>js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="<%=basePath%>js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- Peity -->
<script src="<%=basePath%>js/demo/bootstrap-table-demo.js"></script>

<script type="text/javascript" src="<%=basePath%>js/school/schoolinfo.js"></script>

<script type="text/javascript">

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


$(function () {

    var $table = $("table");

    $table.bootstrapTable({
        url:"<%=basePath%>school/getStudentList",
        dataType:"json",
        search:"true",
        pagination:"true",
        pageList:"[5,10, 25, 50, 100, All]",
        showRefresh:"true",
        height:550,
        columns: [
            [
                {
                    field: 'id',
                    title: 'ID',//标题
                    width : '5%',
                },
                {
                    field: 'email',//域值
                    title: '邮箱',//标题
                    width : '30%',
                    formatter : emailFormatter
                },
                {
                    field: 'nickname',//域值
                    title: '昵称',//内容
                    width : '30%',
                },
                {
                    field: 'createTime',//域值
                    title: '创建时间',//内容
                    width : '25%',
                    formatter : timeFormatter
                }
            ]

        ]

    });

    function timeFormatter(value, row, index) {
        value = new Date(row['createTime']).Format("yyyy-MM-dd HH:mm:ss");
        return value;
    }

    function emailFormatter(value, row, index) {
        value = "<a href='/school/toStudentEmotionPage?id="+row['id']+"'>"+row['email']+"</a>";
        console.log(value);
        return value;
    }

});


</script>
</body>
</html>