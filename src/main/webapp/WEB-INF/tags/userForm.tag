<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="User form" pageEncoding="UTF-8"%>
<%@attribute name="user" required="true" type="p.vitaly.celloperator.dto.user.UserDto"%>
<%--@elvariable id="user" type="p.vitaly.celloperator.dto.user.UserDto"--%>
<form:form cssClass="m-3" modelAttribute="user" action="manager/clients" method="post">
    <label hidden>
        <input hidden name="id" value="${user.id}">
    </label>
    <label hidden>
        <select hidden multiple name="roleIds">
            <c:forEach items="${user.roleIds}" var="roleId">
                <option value="${roleId}" selected></option>
            </c:forEach>
        </select>
    </label>
    <label hidden>
        <input hidden name="userInfo.userId" value="${user.userInfo.userId}">
    </label>
    <label hidden>
        <input hidden name="userInfo.id" value="${user.userInfo.id}">
    </label>
    <div class="form-group row">
        <form:label path="firstName" cssClass="col-4 col-form-label">Имя</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="firstName"/></div>
    </div>
    <div class="form-group row">
        <form:label path="lastName" cssClass="col-4 col-form-label">Фамилия</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="lastName"/></div>
    </div>
    <div class="form-group row">
        <form:label path="userInfo.passport" cssClass="col-4 col-form-label">Паспорт</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="userInfo.passport"/></div>
    </div>
    <div class="form-group row">
        <form:label path="userInfo.address" cssClass="col-4 col-form-label">Адрес</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="userInfo.address"/></div>
    </div>
    <div class="form-group row">
        <form:label path="userInfo.email" cssClass="col-4 col-form-label">E-mail</form:label>
        <div class="col-8"><form:input cssClass="form-control" required="" path="userInfo.email"/></div>
    </div>
    <div class="form-group row">
        <form:label path="userInfo.birthday" cssClass="col-4 col-form-label">Дата рождения</form:label>
        <div class="col-8"><form:input id="birthday" cssClass="form-control" required="" path="userInfo.birthday"/></div>
    </div>
    <script>
        $("#birthday").datepicker({
            changeMonth: true,
            changeYear: true,
            dateFormat: "dd/mm/yy",
            yearRange: "c-50:c+00"
        })
    </script>
    <div class="form-group row">
        <form:label path="blocked" cssClass="col-4 col-form-label">Заблокировать</form:label>
        <div class="col-8">
            <div class="custom-control custom-checkbox">
                <form:checkbox id="blockedCB" cssClass="custom-control-input" path="blocked"/>
                <label class="custom-control-label" for="blockedCB"></label>
            </div>
        </div>
    </div>
    <div class="form-group row">
        <div class="col-12 align-content-end">
            <input class="btn btn-outline-success" type="submit" value="Сохранить">
        </div>
    </div>
</form:form>