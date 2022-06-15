<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%@ include file="head.jspf" %>
    <title>Dodaj wydarzenie</title>
</head>
<body>
<%@include file="nav.jspf"%>
<div class="container sm col-6">
    <div class="container mt-3 mb-3">
        <h1 class="display-3">Dodaj wydarzenie</h1>
    </div>
    <div class="container">
        <form action="${pageContext.request.contextPath}/event/add" method="post">
            <div class="mb-3">
                <label class="form-label" for="title">Tytuł</label>
                <input class="form-control" type="text" name="title" id="title"/>
            </div>

            <div class="mb-3">
                <label class="form-label" for="description">Opis</label>
                <input class="form-control" type="text" name="description" id="description"/>
            </div>

            <div class="mb-3">
                <label class="form-label" for="start">Data i czas rozpoczęcia</label>
                <input class="form-control" type="datetime-local" name="start" id="start"/>
            </div>
            <div class="mb-3">
                <label class="form-label" for="end">Data i czas zakończenia</label>
                <input class="form-control" type="datetime-local" name="end" id="end"/>
            </div>

            <div class="mb-3">
                <label class="form-label" for="tags">Tagi</label>
                <input class="form-control" type="text" name="tags" id="tags"/>
            </div>
            <div class="mb-3">
            <button class="btn btn-primary" type="submit">Zapisz</button>
            </div>
        </form>
    </div>
</div>
<%@include file="footer.jspf"%>
</body>
</html>