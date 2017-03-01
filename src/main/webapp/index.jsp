<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE>
<html>
<head>
<%@include file="/public/header.jspf"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>


<body class="easyui-layout">
	<div data-options="region:'north',border:false"
		style="height: 60px; background: #B3DFDA; padding: 10px">north
		region</div>
		
	<div data-options="region:'west',split:true,title:'West'"style="width: 150px; padding: 10px;">
		<h1>
			<a href="<%=basePath %>test/testConfig">测试</a>
		</h1>
	</div>
	<div
		data-options="region:'east',split:true,collapsed:true,title:'East'"
		style="width: 100px; padding: 10px;">east region</div>
	<div data-options="region:'south',border:false"
		style="height: 50px; background: #A9FACD; padding: 10px;">south
		region</div>
	<div data-options="region:'center',title:'Center'"></div>
</body>

</html>