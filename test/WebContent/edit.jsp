<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<form class="layui-form" action="UpdateBook" method="post" lay-filter="example">
 <div class="layui-form-item">
    <div class="layui-input-block">
    <b style="color:red">${requestScope.message}</b>
    </div>
  </div>
  <input name="id" type="hidden" value="${book.id}"/>
  <div class="layui-form-item">
    <label class="layui-form-label">书名</label>
    <div class="layui-input-block">
      <input type="text" name="bookname" lay-verify="title"  required lay-verify="required" autocomplete="off" placeholder="请输入书名" class="layui-input" value="${book.bookname}">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">作者</label>
    <div class="layui-input-block">
      <input type="text" name="author" lay-verify="title" required lay-verify="required" autocomplete="off" placeholder="请输入作者" class="layui-input" value="${book.author}">
    </div>
  </div>
  
   <div class="layui-form-item">
    <label class="layui-form-label">价格</label>
    <div class="layui-input-block">
      <input type="text" name="price" lay-verify="title" required lay-verify="required" autocomplete="off" placeholder="请输入价格" class="layui-input" value="${book.price}">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">类型</label>
    <div class="layui-input-block">
      <select id="select" name="type" lay-filter="aihao">
      
      <c:if test="${book.type==wenxue}">
      	<option value="wenxue" selected="selected">文学</option>
      </c:if>
      <c:if test="${book.type!=wenxue}">
      	<option value="wenxue" >文学</option>
      </c:if>
      
      <c:if test="${book.type==kehuan}">
      	<option value="kehuan" selected="selected">科幻</option>
      </c:if>
      <c:if test="${book.type!=kehuan}">
      	<option value="kehuan" >科幻</option>
      </c:if>
      
       <c:if test="${book.type==jingji}">
      	<option value="jingji" selected="selected">经济</option>
      </c:if>
      <c:if test="${book.type!=jingji}">
      	<option value="jingji" >经济</option>
      </c:if>
      
      <c:if test="${book.type==lishi}">
  	 	<option value="lishi" selected="selected">历史</option>
      </c:if>
      <c:if test="${book.type!=lishi}">
      	<option value="lishi" >历史</option>
      </c:if>
      
       <c:if test="${book.type==zhuanji}">
  	 	<option value="zhuanji" selected="selected">传记</option>
      </c:if>
      <c:if test="${book.type!=zhuanji}">
      	<option value="zhuanji" >传记</option>
      </c:if>
      </select>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">书的简介</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容简介" class="layui-textarea" name="desca" >${book.desca}</textarea>
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