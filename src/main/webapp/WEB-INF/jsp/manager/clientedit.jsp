<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage title="Управление клиентом">
    <jsp:attribute name="header">
        <t:header>
            <jsp:body>
                <t:managerNavigation activeIndex="-1"/>
            </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
        <t:userForm user="${user}"/>
        <c:if test="${user.id != null}">
            <t:contractsTable userId="${user.id}" contracts="${contracts}"/>
        </c:if>
    </jsp:body>
</t:genericpage>