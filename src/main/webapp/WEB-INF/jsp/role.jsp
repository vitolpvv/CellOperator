<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>User Roles</title>
</head>
<body>
    <table>
        <caption>User roles</caption>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${roles}" var="role">
            <tr>
                <td>
                    ${role.id}
                </td>
                <td>
                    ${role.name}
                </td>
                <td>
                    <form:form method="post" action="role/${role.id}">
                        <input type="submit" value="Delete"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form:form method="post" action="role" modelAttribute="role">
        <table>
            <tr>
                <td>
                    <form:label path="name">Name</form:label>
                </td>
                <td>
                    <form:input path="name"/>
                </td>
                <td>
                    <input type="submit" value="Add">
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
