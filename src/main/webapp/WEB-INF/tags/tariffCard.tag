<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Tariff card" pageEncoding="UTF-8"%>
<%@attribute name="tariff" required="true" type="p.vitaly.celloperator.dto.TariffDto" %>
<div class="card" style="max-width: 18rem">
    <div class="card-body">
        <h5 class="card-title">${tariff.name}</h5>
        <p class="card-text small text-muted">${tariff.description}</p>
        <a href="#" class="btn btn-success">Заказать</a>
        <c:forEach var="option" items="${tariff.options}">
            <p class="card-text small text-muted">- ${option.description}</p>
        </c:forEach>
    </div>
</div>