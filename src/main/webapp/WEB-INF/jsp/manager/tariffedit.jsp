<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage title="Управление тарифом">
    <jsp:attribute name="header">
        <t:header>
            <jsp:body>
                <t:managerNavigation activeIndex="-1"/>
            </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
        <t:tariffForm tariff="${tariff}" payPeriods="${payPeriods}"/>
    </jsp:body>
</t:genericpage>