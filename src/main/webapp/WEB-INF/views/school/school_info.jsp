<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <%@include file="/public/header.jspf" %>

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
                    <h5>学校基本信息</h5>
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
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校编号</label>

                            <div class="col-sm-8">
                                <p class="form-control-static" id="diplay_schoolNumber"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校名称</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="diplay_schoolName"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">省份</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="diplay_schoolProvince"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">城市</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="diplay_schoolCity"></p>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学生总人数</label>
                            <div class="col-sm-8">
                                <p class="form-control-static" id="diplay_totalStudent"></p>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="ibox-content" id="edit_school_info" style="display: none">
                    <form class="form-horizontal">
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校编号</label>

                            <div class="col-sm-8">
                                <input type="text" id="schoolNumber" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学校名称</label>
                            <div class="col-sm-8">
                                <input type="text" id="schoolName" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">省份</label>
                            <div class="col-sm-8">
                                <input type="text" id="schoolProvince" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">城市</label>
                            <div class="col-sm-8">
                                <input type="text" id="schoolCity" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-3 control-label">学生总人数</label>
                            <div class="col-sm-8">
                                <input type="text" id="totalStudent" class="form-control">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-8">
                                <button class="btn btn-sm btn-info" id="submitSchoolInfo" type="button">提交</button>
                                <button class="btn btn-sm btn-info" id="cancelEdit" type="reset">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>js/school/schoolinfo.js"></script>
</body>
</html>