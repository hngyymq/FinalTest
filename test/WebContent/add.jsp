<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="AddBook" method="post" lay-filter="example">
 <div class="layui-form-item">
    <div class="layui-input-block">
    <b style="color:red">${requestScope.message}</b>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">书名</label>
    <div class="layui-input-block">
      <input type="text" name="bookname" lay-verify="title"  required lay-verify="required" autocomplete="off" placeholder="请输入书名" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">作者</label>
    <div class="layui-input-block">
      <input type="text" name="author" lay-verify="title" required lay-verify="required" autocomplete="off" placeholder="请输入作者" class="layui-input">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">价格</label>
    <div class="layui-input-block">
      <input type="text" name="price" lay-verify="title" required lay-verify="required" autocomplete="off" placeholder="请输入价格" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select name="type" lay-filter="aihao">
        <option value="wenxue">文学</option>
        <option value="kehuan">科幻</option>
        <option value="jingji">经济</option>
        <option value="lishi">历史</option>
        <option value="zhuanji">传记</option>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">书的简介</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容简介" class="layui-textarea" name="desca"></textarea>
    </div>
  </div>
 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button type="submit" class="layui-btn">立即提交</button>
    </div>
  </div>
</form>
</body>
<script src="layui/layui.all.js"></script>
<script src="myjs/tab.js"></script>
<script>
	
</script>
</html>