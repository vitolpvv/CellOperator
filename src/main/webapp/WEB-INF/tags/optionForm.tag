<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@tag description="Option form" pageEncoding="UTF-8"%>
<%@attribute name="option" required="true" type="p.vitaly.celloperator.dto.OptionDto"%>
<%@attribute name="options" required="true" type="java.util.List<p.vitaly.celloperator.dto.OptionDto>" %>
<%@attribute name="payPeriods" required="true" type="java.util.List<p.vitaly.celloperator.dto.PaymentPeriodDto>" %>
<%--@elvariable id="option" type="p.vitaly.celloperator.dto.OptionDto"--%>
<form:form cssClass="m-3" modelAttribute="option" action="manager/options" method="post">
    <label hidden>
        <input hidden name="id" value="${option.id}">
    </label>
    <div class="form-group row">
        <form:label path="name" cssClass="col-4 col-form-label">Название</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="name"/></div>
    </div>
    <div class="form-group row">
        <form:label path="description" cssClass="col-4 col-form-label">Описание</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="description"/></div>
    </div>
    <div class="form-group row">
        <form:label path="priceUse" cssClass="col-4 col-form-label">Стоимость пользования</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="priceUse"/></div>
    </div>
    <div class="form-group row">
        <form:label path="payPeriodId" cssClass="col-4 col-form-label">Период оплаты</form:label>
        <div class="col-8">
            <form:select cssClass="custom-select" path="payPeriodId">
                <form:options items="${payPeriods}" itemLabel="name"  itemValue="id"/>
            </form:select>
        </div>
    </div>
    <div class="form-group row">
        <form:label path="priceSet" cssClass="col-4 col-form-label">Стоимость подключения</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="priceSet"/></div>
    </div>
    <div class="form-group row">
        <form:label path="parentId" cssClass="col-4 col-form-label">Родительская опция</form:label>
        <div class="col-8">
            <form:select cssClass="custom-select" path="parentId">
                <form:option value="" label="Выберите опцию"/>
                <form:options items="${options}" itemLabel="name"  itemValue="id"/>
            </form:select>
        </div>
    </div>
    <div class="form-group row">
        <form:label path="permanent" cssClass="col-4 col-form-label">Постоянная</form:label>
        <div class="col-8">
            <div class="custom-control custom-checkbox">
                <form:checkbox id="permanentCB" cssClass="custom-control-input" path="permanent"/>
                <label class="custom-control-label" for="permanentCB"></label>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <form:label path="archived" cssClass="col-4 col-form-label">В архив</form:label>
        <div class="col-8">
            <div class="custom-control custom-checkbox">
                <form:checkbox id="archivedCB" cssClass="custom-control-input" path="archived"/>
                <label class="custom-control-label" for="archivedCB"></label>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12 align-content-end">
            <input class="btn btn-outline-success" type="submit" value="Сохранить">
        </div>
    </div>
</form:form>