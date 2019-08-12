<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage title="Управление опцией">
    <jsp:attribute name="header">
        <t:header>
            <jsp:body>
                <t:managerNavigation activeIndex="-1"/>
            </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
        <t:optionForm option="${option}" options="${options}" payPeriods="${payPeriods}"/>
    </jsp:body>
</t:genericpage>
