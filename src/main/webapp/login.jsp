<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form:form method="post" action="/j_spring_security_check">
    <table>
        <tr>
            <td>
                <label for="user_name">Login</label>
            </td>
            <td>
                <input id="user_name" name="j_username" type="text"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="user_password">Password</label>
            </td>
            <td>
                <input id="user_password" name="j_password" type="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <label for="remember_me"></label>
                <input id="remember_me" name="_spring_security_remember_me" type="checkbox">
            </td>
            <td>
                <input type="submit" value="Login">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
