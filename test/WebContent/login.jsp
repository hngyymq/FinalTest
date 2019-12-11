<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录页面</title>
 <!-- 引入layui css 为了开发方便
 	  layui 封装了很多css 
 	     有时候一个class属性就可以呈现出效果 省了很多代码
 	     比如下列的标签中layui-btn layui-input等;
 	     要是感兴趣的话可以去www.layui.com上学习一下
 -->
 <link rel="stylesheet" href="layui/css/layui.css">
 <link rel="stylesheet" href="mycss/style.css">
</head>
<body>

	<div class="login-main">
	    <header class="layui-elip">登录</header>
	    <!-- action指向的是servlet的路径
	    	 method是post 安全
	    	  如果method是get 登录时候的账号和密码会在URI连接上显示出来
	    	  例如：http://localhost:8080/test/?user=asdasd&password=asd
	    	  
	    	  
	      -->
	    <form class="layui-form" action="LoginServlet" method="post">
	    	<!-- 
	    		 其中 class中的 required 是必须填写的意思，就不用自己写js去判断是不是空？判断
	    	     placeholder是没填写时所出现的内容
	    	           其中type是指定类型  下面text是你输入后你能看到刚才输入的内容
	    	           			  password是你输入的内容全部变成* 保护用户隐私 用于密码的输入
	    	 -->
	        <div class="layui-input-inline">
	            <input type="text" name="user" required lay-verify="required" placeholder="用户名" autocomplete="off"
	                   class="layui-input">
	        </div>
	        <div class="layui-input-inline">
	            <input type="password" name="password" required lay-verify="required" placeholder="密码" autocomplete="off"
	                   class="layui-input">
	        </div>
	        <div class="layui-input-inline login-btn">
	            <button lay-submit lay-filter="login" class="layui-btn">登录</button>
	        </div>
			<b style="color: red; font-weight: bolder;"> ${requestScope.message}</b>
	        <hr/>
	        <p><a href="register.jsp" class="fr">立即注册</a></p>
	    </form>
	</div>
</body>

<script src="layui/layui.all.js"></script>
<script type="text/javascript">
	// 操作对象
	//引入form组件  渲染表格
	var form = layui.form;
</script>
</html>