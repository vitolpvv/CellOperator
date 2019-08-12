<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Contracts table" pageEncoding="UTF-8"%>
<%@attribute name="title"%>
<%@attribute name="userId" required="true" %>
<%@attribute name="contracts" required="true" type="java.util.List<p.vitaly.celloperator.dto.ContractDto>" %>
<table class="table table-hover">
    <thead>
    <tr>
        <th>${empty title ? 'Контракты' : title}</th>
        <th style="text-align: center; width: 1%">
            <c:if test="${not empty userId}">
                <a class="text-success" href="manager/contracts/add?userId=${userId}">Создать</a>
            </c:if>
        </th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${contracts}" var="contract">
        <tr>
            <td>${contract.number}</td>
            <td>
                <div class="d-flex">
                    <a class="text-success mr-3" href="manager/contracts/edit?id=${contract.id}">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a class="text-success" href="manager/contracts/delete?id=${contract.id}">
                        <i class="fas fa-trash-alt"></i>
                    </a>
                </div>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>