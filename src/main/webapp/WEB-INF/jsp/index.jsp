<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<c:forEach items="${roles}" var="role">
    <li>${role.id} ${role.name}</li>
</c:forEach>
</ul>
</body>
</html>
