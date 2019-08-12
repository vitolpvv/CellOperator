<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@tag description="Contract form" pageEncoding="UTF-8"%>
<%@attribute name="contract" required="true" type="p.vitaly.celloperator.dto.ContractDto" %>
<%@attribute name="tariffs" required="true" type="java.util.List<p.vitaly.celloperator.dto.TariffDto>" %>
<%--@elvariable id="contract" type="p.vitaly.celloperator.dto.ContractDto"--%>
<form:form cssClass="m-3" modelAttribute="contract" action="manager/contracts" method="post">
    <label hidden>
        <input hidden name="id" value="${contract.id}">
    </label>
    <label hidden>
        <input hidden name="userId" value="${contract.userId}">
    </label>
    <div class="form-group row">
        <form:label path="number" cssClass="col-4 col-form-label">Номер</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="number"/></div>
    </div>
    <div class="form-group row">
        <form:label path="tariffId" cssClass="col-4 col-form-label">Тариф</form:label>
        <div class="col-8">
            <form:select cssClass="custom-select" path="tariffId">
                <form:option value="" label="Выберите тариф"/>
                <form:options items="${tariffs}" itemLabel="name"  itemValue="id"/>
            </form:select>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12 align-content-end">
            <input class="btn btn-outline-success" type="submit" value="Сохранить">
        </div>
    </div>
</form:form>