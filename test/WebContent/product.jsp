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
      <col width="200">
      <col>
    </colgroup>
    <thead>
      <tr>
        <th>图书编号</th>
        <th>书名</th>
        <th>作者</th>
        <th>价格</th>
        <th>描述</th>
      </tr> 
    </thead>
    <c:forEach items="${booklist}" var="book">
   	<tbody>
      <tr>
        <td>${book.id}</td>
        <td>${book.bookname}</td>
        <td>${book.author}</td>
        <td>${book.price} </td>
        <td>${book.desca} </td>
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
  $("#flush").on('click',function(){
	  window.location.href="QueryAllBookServlet"; 
  });
</script>
</html>