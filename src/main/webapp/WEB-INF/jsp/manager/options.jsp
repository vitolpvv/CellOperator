<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Управление опциями</title>
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
                <span><a href="tariffs">Тарифы</a></span>
                <span>Опции</span>
            </td>
            <td style="width: 1%">
                <input type="text">
            </td>
            <td style="width: 1%">
                <div title="Добавить опцию" class="button" onclick="location.href='options/add'">+</div>
            </td>
            <td style="width: 1%">
                <div class="button" onclick="">Выйти</div>
            </td>
        </tr>
    </table>
</div>
<div id="content">
    <table>
        <c:forEach items="${options}" var="option">
            <tr>
                <td class="padding20px borderBottom">
                    <a href="options/edit?id=${option.id}">${option.name}</a>
                </td>
                <td class="padding20px borderBottom" style="width: 1%">
                    <div class="button" onclick="location.href='options/delete?id=${option.id}'">Удалить</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
