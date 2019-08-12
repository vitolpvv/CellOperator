<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage title="Тарифы">
    <jsp:attribute name="header">
        <t:header>
        <jsp:body>
            <t:titleLogin title="Тарифы"/>
        </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
<div class="card-deck">
    <c:forEach items="${tariffs}" var="tariff">
        <t:tariffCard tariff="${tariff}"/>
    </c:forEach>
</div>
    </jsp:body>
</t:genericpage>