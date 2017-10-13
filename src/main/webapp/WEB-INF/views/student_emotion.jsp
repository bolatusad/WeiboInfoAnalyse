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
                    <h5>情感分析</h5>
                    <div class="ibox-tools">
                            <div class="form-group">
                                <div class="col-sm-3">
                                   <input type="text" id="email" name="email" style="border-left: none;border-top: none;border-right: none;border-bottom: #31b0d5 2px solid;" placeholder="请输入邮箱"/>
                                </div>
                                <div class="col-sm-4 pull-right">
                                   <input type="button" class="btn btn-xs btn-info" id="submit" name="submit" value="查询"/>
                                </div>
                            </div>
                    </div>
                </div>
                <div class="ibox-content">
                    <div class="echarts" id="echarts-my"></div>
                </div>
            </div>
        </div>
    </div>
    <!--自己的图表结束-->
</div>


<!-- ECharts -->
<script src="<%=basePath%>js/plugins/echarts/echarts.js"></script>
<!--<script src="js/plugins/echarts/echarts.js"></script>-->

<!-- 自定义js -->
<script src="<%=basePath%>js/content.js?v=1.0.0"></script>

<script src="<%=basePath%>js/plugins/echarts/vintage.js"></script>

<!-- Toastr script -->
<script src="<%=basePath%>js/plugins/toastr/toastr.min.js"></script>


<!-- ECharts demo data -->
<!--<script src="js/demo/echarts-demo.js"></script>-->


<script type="text/javascript">


   // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('echarts-my'));

    var option = {
        title: {
            text: '微博情感分析',
            subtext:'',
            left:'center'
        },
        tooltip: {
            trigger: 'axis',
            formatter: function (params) {
                params = params[0];
                console.log(params.data);
                return "邮箱:"+params.data.email+ ' <br> 积极指数:' + params.value[1];
            },
            axisPointer: {
                animation: true
            }
        },
        xAxis: {
            type: 'time',
            name:'日期',
            splitLine: {
                show: false
            }
        },
        yAxis: {
            max:1,
            min:0,
            type: 'value',
            name:'积极指数',
            boundaryGap: [0, '100%'],
            splitLine: {
                show: true
            }
        },
        series: [{
            name: '模拟数据',
            type: 'line',
            showSymbol: true,
            hoverAnimation: false,
            data: []

        }]
    };


    $(function () {

        getEmotionInfo();

        //绑定搜索事件
        $("#submit").on("click",function () {
            getEmotionInfoByEmail();
        });
    });

   /**
    * 搜索获取情感分析
    */
   function getEmotionInfoByEmail() {
       var email = $("#email").val();
       if(email == null || email == ''){
           toastr.warning('邮箱不能为空', '提示');
           return;
       }
           $.ajax({
               //暂定为1
               url:"/school/getStudentEmotionByEmail",
               type:"get",
               data:{
                   email:email
               },
               dataType:"json",
               success : function (data) {
                   if(data.code == "001"){
                       if(data.data.length >0 && data.data != null && data.data != ''){
                           console.log(data.data);
                           option.series[0].data = data.data;
                           option.title.subtext = data.data[0].email;
                           myChart.setOption(option);
                       }else{
                           toastr.warning('未查询到相应的情感分析！', '提示');
                       }
                   }

               }
           });
   }


    function getEmotionInfo() {

        var id = getUrlParam("id");
        if(id != null && id != ''){
            $.ajax({
                //暂定为1
                url:"/school/getStudentEmotion/"+id,
                type:"get",
                dataType:"json",
                success : function (data) {
                    if(data.code == "001"){
                        if(data.data != null && data.data != '' && data.data.length >0 ){
                            console.log(data.data);
                            option.series[0].data = data.data;
                            option.title.subtext = data.data[0].email;
                            myChart.setOption(option);
                        }else{
                            toastr.warning('该学生没有绑定微博或未发布微博！', '提示');
                        }
                    }else{
                        toastr.warning('该学生没有绑定微博或未发布微博！', '提示');
                    }

                }
            });
        }
    }


    //获取url中的参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg); //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }


</script>

</body>

</html>