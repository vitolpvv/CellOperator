<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Управление тарифами</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <link href="../css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <table>
        <tr>
            <td>
                <a href="../tariffs"><img alt="logo" src="../favicon.ico"></a>
                <span><a href="clients">Клиенты</a></span>
                <span>Тарифы</span>
                <span><a href="options">Опции</a></span>
            </td>
            <td style="width: 1%">
                <input type="text">
            </td>
            <td style="width: 1%">
                <div title="Добавить тариф" class="button" onclick="location.href='tariffs/add'">+</div>
            </td>
            <td style="width: 1%">
                <div class="button" onclick="">Выйти</div>
            </td>
        </tr>
    </table>
</div>
<div id="content">
    <table>
        <c:forEach items="${tariffs}" var="tariff">
            <tr>
                <td class="padding20px borderBottom">
                    <a href="tariffs/edit?id=${tariff.id}">${tariff.name}</a>
                </td>
                <td class="padding20px borderBottom" style="width: 1%">
                    <div class="button" onclick="location.href='tariffs/delete?id=${tariff.id}'">Удалить</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
