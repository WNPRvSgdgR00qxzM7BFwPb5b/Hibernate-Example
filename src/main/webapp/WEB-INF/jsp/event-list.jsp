<jsp:useBean id="events" scope="request" type="java.util.List<pl.sda.sapiens.ep.model.entity.EventEntity>"/>
<%@ page contentType="text/html" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="head.jspf"%>
    <title>Lista wydarzeń</title>
</head>
<body>
<%@include file="nav.jspf"%>
<div>
    <h1 class="display-3">Lista bieżących wydarzeń</h1>
    <div>
        <table class="table">
            <thead>
            <tr>
                <th>
                    Tytuł
                </th>
                <th>
                    Data rozpoczęcia
                </th>
                <th>
                    Data zakończenia
                </th>
                <th>
                    Skrót opisu
                </th>
                <th>
                    Operacje
                </th>
            </tr>
            </thead>
            <tbody class="table-group-divider">
            <c:forEach var="event" items="${events}">
                <tr>
                    <td>
                        ${event.title}
                    </td>
                    <td>
                        ${event.start}
                    </td>
                    <td>
                        ${event.end}
                    </td>
                    <td>
                        ${event.description}
                    </td>
                    <td>
                        <a class="btn" href="${pageContext.request.contextPath}/event/details?id=${event.id}">Szczegóły</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<%@include file="footer.jspf"%>
</body>
</html>