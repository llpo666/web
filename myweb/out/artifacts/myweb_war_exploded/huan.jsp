<%--
  Created by IntelliJ IDEA.
  User: ${李嘉良}
  Date: 2022/10/30
  Time: 18:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

        <meta charset="UTF-8"/>
    </head>
<body>
<p>
    当前在线用户：
</p>
<table border="1" align="center" width="50%">
<c:forEach items="${applicationScope.list}" var="i">
    <tr>
        <td>
                ${i}
        </td>
    </tr>
</c:forEach>

</body>
</html>

