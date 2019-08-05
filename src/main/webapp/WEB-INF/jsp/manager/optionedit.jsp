<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: vitalyp
  Date: 03.08.2019
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование опции</title>
    <script type="text/javascript" src="../../js/jquery-3.4.1.min.js"></script>
    <link href="../../css/default.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="header">
    <table>
        <tr>
            <td>
                <a href="../../tariffs"><img alt="logo" src="../../favicon.ico"></a>
                <span><a href="../clients">Клиенты</a></span>
                <span><a href="../tariffs">Тарифы</a></span>
                <span><a href="../options">Опции</a></span>
            </td>
            <td style="width: 1%">
                <div class="button" onclick="">Выйти</div>
            </td>
        </tr>
    </table>
</div>
<div id="content">
    <form:form modelAttribute="option" action="../options" method="post">
        <input type="hidden" name="id" value="${option.id}" >
        <table>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="name">Название</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:input cssClass="fullWidth" path="name"/>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="description">Описание</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:input cssClass="fullWidth" path="description"/>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="priceUse">Стоимость пользования</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:input cssClass="fullWidth" path="priceUse"/>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="payPeriodId">Период оплаты</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:select cssClass="fullWidth" path="payPeriodId">
                        <form:options items="${payPeriods}" itemLabel="name"  itemValue="id"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="priceSet">Стоимость подключения</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:input cssClass="fullWidth" path="priceSet"/>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="parentId">Родительская опция</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:select cssClass="fullWidth" path="parentId">
                        <form:option value="" selected="selected"/>
                        <form:options items="${options}" itemValue="id" itemLabel="name"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="permanent">Постоянная</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:checkbox path="permanent"/>
                </td>
            </tr>
            <tr>
                <td class="padding20px borderBottom">
                    <form:label path="archived">В архив</form:label>
                </td>
                <td class="padding20px borderBottom contentRightAlign">
                    <form:checkbox path="archived"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" class="padding20px  contentRightAlign">
                    <input class="button" type="submit" value="Сохранить">
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
