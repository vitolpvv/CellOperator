<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:genericpage title="Управление опциями">
    <jsp:attribute name="header">
        <t:header>
            <jsp:body>
                <t:managerNavigation activeIndex="0"/>
            </jsp:body>
        </t:header>
    </jsp:attribute>
    <jsp:body>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Название</th>
                <th style="text-align: center; width: 1%">
                    <a class="text-success" href="manager/options/add">Создать</a>
                </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${options}" var="option">
                <tr>
                    <td>${option.name}</td>
                    <td>
                        <div class="d-flex">
                            <a class="text-success mr-3" href="manager/options/edit?id=${option.id}">
                                <i class="fas fa-edit"></i>
                            </a>
                            <a class="text-success" href="manager/options/delete?id=${option.id}">
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