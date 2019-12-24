<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>图书管理系统(后端界面)</title>
  <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">图书管理系统(后端界面)</div>	
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="mycss/user.jpg" class="layui-nav-img">
           ${sessionScope.user.user}
        </a>
      </li>
      <li class="layui-nav-item"><a href="LoginOutServlet">退出登录</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
    	  <li class="layui-nav-item">
       	 <a href="javascript:;" data-id="1" data-title="图书列表" data-url="QueryAllBookServlet"
       	  class="site-demo-active" data-type="tabAdd">商品列表</a>
        </li>
        <li class="layui-nav-item">
       	 <a href="javascript:;" data-id="2" data-title="添加图书" data-url="add.jsp"
       	  class="site-demo-active" data-type="tabAdd">添加图书</a>
        </li>
        <li class="layui-nav-item">
      	 <a href="javascript:;" data-id="3" data-title="管理图书" data-url="BookManager"
           class="site-demo-active" data-type="tabAdd">管理图书</a>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
	    <!--tab标签-->
    <div class="layui-tab" lay-filter="demo" lay-allowclose="true">
        <ul class="layui-tab-title"></ul>
        <div class="layui-tab-content"></div>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->
  </div>
</div>
<script src="layui/layui.all.js"></script>
<script src="myjs/tab.js"></script>
<script>
	
</script>
</body>
</html>