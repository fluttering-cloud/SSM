<%--
  Created by IntelliJ IDEA.
  User: Candy
  Date: 2021/7/16
  Time: 18:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/book/addBookC" method="post" >
    书名：<input type="text" name="bookName">
    数量：<input type="text" name="bookCounts">
    描述：<input type="text" name="detail">
       提交<input type="submit">
</form>

</body>
</html>
