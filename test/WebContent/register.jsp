<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="layui/css/layui.css">
<link rel="stylesheet" href="mycss/style.css">
</head>
<body>
	<div class="login-main">
    <header class="layui-elip" style="width: 82%">注册页</header>
 
    <!-- 表单选项 -->
    <form class="layui-form" action="RegisterServlet" method="post">
        <div class="layui-input-inline">
            <!-- 用户名 -->
            <div class="layui-inline" style="width: 85%">
                <input type="text" id="user" name="user" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
               
        </div>
            <!-- 密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="pwd" name="password" required  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="pwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
            <!-- 确认密码 -->
        <div class="layui-input-inline">
            <div class="layui-inline" style="width: 85%">
                <input type="password" id="rpwd" name="repassword" required  lay-verify="required" placeholder="请确认密码" autocomplete="off" class="layui-input">
            </div>
            <!-- 对号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpri" style="color: green;font-weight: bolder;" hidden></i>
            </div>
            <!-- 错号 -->
            <div class="layui-inline">
                <i class="layui-icon" id="rpwr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
            </div>
        </div>
 
        <div class="layui-input-inline login-btn" style="width: 85%">
            <button type="submit" lay-submit lay-filter="sub" class="layui-btn" id="registerUser">注册</button>
        </div>
        <hr style="width: 85%" />
        <p style="width: 85%"><a href="login.jsp" class="fr">已有账号？立即登录</a></p>
    </form>
     <!-- 错误信息的回显 ：用户已存在！！ -->
      <b style="color: red; font-weight: bolder;"> ${requestScope.message}</b>
   
</div>
</body>
<script src="layui/layui.all.js"></script>
<script type="text/javascript" >
	var form   = layui.form;
	var $      = layui.jquery;
	var layer  = layui.layer;

	//验证密码是否相等
	//如果不相等 button type改为button【不会执行form表单的提交】
	//如果相等直接提交
	 $('#registerUser').click(function(){
		 if($('#pwd').val() != $('#rpwd').val()){
             $('#rpwr').removeAttr('hidden');
             $('#rpri').attr('hidden','hidden');
             layer.msg('两次输入密码不一致!');
             $('#registerUser').css("type","button");
             return false;
         }else {
             $('#rpri').removeAttr('hidden');
             $('#rpwr').attr('hidden','hidden');
         };
	 });
</script>
</html>