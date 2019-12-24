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
	<button style="float:right;margin-right:20px;margin-bottom:10px;" class="layui-btn" id="flush">刷新</button>
	 <table class="layui-table">
    <colgroup>
      <col width="20">
      <col width="100">
      <col width="50">
      <col width="50">
      <col width="50">
      <col width="300">
      <col width="30">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>图书编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>类型</th>
        <th>价格</th>
        <th>描述</th>
        <th>操作</th>
      </tr> 
    </thead>
    <c:forEach items="${booklist}" var="book">
   	<tbody>
      <tr>
        <td>${book.id}</td>
        <td>${book.bookname}</td>
        <td>${book.author}</td>
        <td>
        <c:if test="${book.type=='wenxue'}">
        		文学
        	</c:if> 
        	<c:if test="${book.type=='kehuan'}">
        		科幻
        	</c:if>
        	<c:if test="${book.type=='jingji'}">
        		经济
        	</c:if>
        	<c:if test="${book.type=='lishi'}">
        		历史
        	</c:if>
        	<c:if test="${book.type=='zhuanji'}">
        		传记
        	</c:if>
        </td>
        <td>${book.price} </td>
        <td>${book.desca} </td>
        <td>
			<div class="layui-btn-group">
			  <button type="button" onclick="editBook(${book.id})" class="layui-btn layui-btn-primary layui-btn-sm">
			    <i class="layui-icon">&#xe642;</i>
			  </button>
			  <button type="button" onclick="deleteBook(${book.id})"  class="layui-btn layui-btn-primary layui-btn-sm">
			    <i class="layui-icon">&#xe640;</i>
			  </button>
			</div>
		</td>
      </tr>
    </tbody>
    </c:forEach>
  </table>
  <b style="color:red">${requestScope.message} </b>
</body>
<script src="layui/layui.all.js"></script>
<script src="myjs/tab.js"></script>
<script>
  var $ =layui.$;
  var layer =layui.layer;
  $("#flush").on('click',function(){
	  window.location.href="BookManager"; 
  });
  
  function deleteBook(id){
	  window.location.href="DeleteBook?id="+id;
  }
  
  function editBook(id){
	  window.location.href="EditBook?id="+id;
  }
//页面层

  
</script>
</html>