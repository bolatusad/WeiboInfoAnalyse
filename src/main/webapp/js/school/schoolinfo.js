// //以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
// $.validator.setDefaults({
//     highlight: function (element) {
//         $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
//     },
//     success: function (element) {
//         element.closest('.form-group').removeClass('has-error').addClass('has-success');
//     },
//     errorElement: "span",
//     errorPlacement: function (error, element) {
//         if (element.is(":radio") || element.is(":checkbox")) {
//             error.appendTo(element.parent().parent().parent());
//         } else {
//             error.appendTo(element.parent());
//         }
//     },
//     errorClass: "help-block m-b-none",
//     validClass: "help-block m-b-none"
//
//
// });
//
//
// $().ready(function () {
//     // validate the comment form when it is submitted
//     // $("#commentForm").validate();
//
//     // validate signup form on keyup and submit
//     var icon = "<i class='fa fa-times-circle'></i> ";
//     $("#signupForm").validate({
//         rules: {
//
//             password: {
//                 required: true,
//                 minlength: 5
//             },
//             confirm_password: {
//                 required: true,
//                 minlength: 5,
//                 equalTo: "#password"
//             },
//             email: {
//                 required: true,
//                 email: true,
//                 remote:{
//                     url:"/account/isEmailExist",
//                     type:"post",
//                     dataType:"json"
//                     // data:{
//                     //     userPre:function(){
//                     //         var user = {};
//                     //         user.email = $("#email").val();
//                     //         return user;
//                     //     }
//                     // }
//                 }
//             }
//         },
//         messages: {
//             password: {
//                 required: icon + "请输入您的密码",
//                 minlength: icon + "密码必须5个字符以上"
//             },
//             confirm_password: {
//                 required: icon + "请再次输入密码",
//                 minlength: icon + "密码必须5个字符以上",
//                 equalTo: icon + "两次输入的密码不一致"
//             },
//             email:{
//                 required: icon + "请输入邮箱",
//                 email:icon + "请输入正确的E-mail",
//                 remote:icon +"邮箱已被注册"
//             }
//         }
//     });
// });

$(function () {

    getSchoolInfoPre();

    bindEvent();



});



/**
 * 绑定事件
 */
function bindEvent() {
    //绑定修改事件
    $("#edit").on("click",function () {
        editSchoolInfo();
    })
    /**
     * 绑定提交事件
     */
    $("#submitSchoolInfo").on("click",function () {
        submitSchoolInfo();
    })

    /**
     * 绑定取消事件
     */
    $("#cancelEdit").on("click",function () {
        $("#display_school_info").show();
        $("#edit_school_info").hide();
    })
}

/**
 * 提交事件
 */
function submitSchoolInfo() {
    var school = getSchoolInfoFromPage();
    $.ajax({
        url:"/school/updateSchoolInfo",
        type:"post",
        contentType:"application/json; charset=UTF-8",
        dataType:"json",
        data:JSON.stringify(school),
        success:function (data) {
            if(data.code == "001"){
                $("#cancelEdit").click();
                getSchoolInfoPre();
            }
        }
    });
}



/**
 * 出现修改界面
 */
function editSchoolInfo() {
    $("#display_school_info").hide();
    $("#edit_school_info").show();
    getSchoolInfo();
}

/***
 * 获取用户信息
 */
function getSchoolInfo() {
    $.ajax({
        url:"/school/getSchoolInfo",
        type:"get",
        dataType:"json",
        success:function (data) {
            if(data.code = "001"){
                setSchoolInfo(data.data);
            }
        }
    });
}

/**
 * 用于信息的展示
 */
function getSchoolInfoPre() {
    $.ajax({
        url:"/school/getSchoolInfo",
        type:"get",
        dataType:"json",
        success:function (data) {
            if(data.code = "001"){
                var school = data.data;
                $("#diplay_schoolNumber").html(school.schoolNumber);
                $("#diplay_schoolName").html(school.schoolName);
                $("#diplay_schoolProvince").html(school.schoolProvince);
                $("#diplay_schoolCity").html(school.schoolCity);
                $("#diplay_totalStudent").html(school.totalStudent);
            }
        }
    });
}



/**
 * 给表单设置值
 * @param school
 */
function setSchoolInfo(school) {
    $("#schoolNumber").val(school.schoolNumber);
    $("#schoolName").val(school.schoolName);
    $("#schoolProvince").val(school.schoolProvince);
    $("#schoolCity").val(school.schoolCity);
    $("#totalStudent").val(school.totalStudent);
}

/**
 * 从页面中获取表单信息，并返回
 */
function getSchoolInfoFromPage() {
    var school = {};
    school.schoolNumber = $("#schoolNumber").val();
    school.schoolName = $("#schoolName").val();
    school.schoolProvince = $("#schoolProvince").val();
    school.schoolCity = $("#schoolCity").val();
    school.totalStudent = $("#totalStudent").val();
    return school;
}

