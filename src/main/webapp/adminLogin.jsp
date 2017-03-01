<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/2/23
  Time: 0:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--需要添加basepath相对引用 不然easyui样式不生效--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <%--兼容IE--%>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/plugins/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/adminLogin.css">

    <script src="<%=basePath%>/plugins/jquery/jquery-3.1.1.js"></script>
    <script src="<%=basePath%>/plugins/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/plugins/jquery-validator/jquery-validate.js"></script>

</head>
<body >
<div id="login">
    <h1>后台登录系统</h1>
    <form id="form" method="post" class="form-horizontal" action="<%=basePath%>normal/login">
        <input id="username" name="username" type="text"  class="input-lg" placeholder="用户名" data-required="true">
        <input id="password" name="password" type="text"  class="input-lg" placeholder="密码" data-required="true">
        <button id="btn_login" class="btn btn-info btn-block" type="submit">登录</button>
    </form>
</div>
<script>

//$(function () {
//    $('#form').validate({
//        onKeyup:false,
//        onSubmit:true,
//
//        valid:function () {
//            window.console.log("valid");
//            var params = $('#form').serialize();
//            var username = $('#form').find('#username').val();
//            var password = $('#form').find('#password').val();
//            console.log(params);
//            jQuery.post(
//                "http://localhost:8080/TaskManageCore/normal/login",
//                params,
//                function (result) {
//                    window.console.log("result="+result);
//                    if (result=="success"){
//                        window.console.log("success")
//                        location.href='adminHome.jsp';
//                    }else {
//                        window.alert("用户不存在");
//                    }
//                }, 'text');
////            $.ajax({
////                async:false,
////                url:"http://localhost:8080/TaskManageCore/admin/login",
////                type:"post",
////                dataType:"json",
////                data:params,
////                success:function (result) {
////                    window.console.log("result="+result);
////                    if (result=="success"){
////                        window.console.log("success")
////                        location.href='adminHome.jsp';
////                    }else {
////                        window.alert("用户不存在");
////                    }
////                }
////            });
//        },
//
//        invalid:function () {
//            window.console.log("为空");
//            return false;
//        }
//    });
//});


//    $.validateExtend({
//        username:{
//            required:true
//        }
//    });
</script>
</body>
</html>
