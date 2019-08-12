<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage title="Управление клиентами">
    <jsp:attribute name="header">
        <t:header>
            <jsp:body>
                <t:managerNavigation activeIndex="2"/>
            </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Название</th>
                <th style="text-align: center; width: 1%">
                    <a class="text-success" href="manager/clients/add">Создать</a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.firstName} ${user.lastName}</td>
                    <td>
                        <div class="d-flex">
                            <a class="text-success mr-2" href="manager/clients/edit?id=${user.id}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <a class="text-success" href="manager/clients/delete?id=${user.id}">
                                <i class="fas fa-trash-alt"></i>
                            </a>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </jsp:body>
</t:genericpage>
