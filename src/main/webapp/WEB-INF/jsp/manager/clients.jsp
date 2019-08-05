<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>Управление клиентами</title>
    <script type="text/javascript" src="../js/jquery-3.4.1.min.js"></script>
    <link href="../css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <table>
        <tr>
            <td>
                <a href="../tariffs"><img alt="logo" src="../favicon.ico"></a>
                <span>Клиенты</span>
                <span><a href="tariffs">Тарифы</a></span>
                <span><a href="options">Опции</a></span>
            </td>
            <td style="width: 1%">
                <input type="text">
            </td>
            <td style="width: 1%">
                <div title="Добавить клиента" class="button" onclick="location.href='clients/add'">+</div>
            </td>
            <td style="width: 1%">
                <div class="button" onclick="">Выйти</div>
            </td>
        </tr>
    </table>
</div>
<div id="content" style="border: 1px solid black">
    <h1>Hello</h1>
</div>
</body>
</html>
