<%--
  Created by IntelliJ IDEA.
  User: Candy
  Date: 2021/7/15
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>首页</title>
  </head>
  <body>
  <a href="${pageContext.request.contextPath}/book/selectBook">搜索书籍</a>

  <a href="${pageContext.request.contextPath}/book/addBook">添加书籍</a>

  <a href="${pageContext.request.contextPath}/book/updatabook">修改书籍</a>

  <a href="#">文件上传</a>
  </body>
</html>
