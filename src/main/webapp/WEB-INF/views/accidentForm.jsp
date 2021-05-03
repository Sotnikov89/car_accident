<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"
            integrity="sha384-SR1sx49pcuLnqZUnnPwx6FCym0wLsk5JZuNx2bPPENzswTNFaQU1RDvt3wT4gWFG" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.min.js"
            integrity="sha384-j0CNLUeiqtyaRmlzUHCPZ+Gy5fQu0dQ6eZ/xAww941Ai1SxSY+0EQqNXNE6DZiVc" crossorigin="anonymous"></script>
    <title>Accident</title>
</head>
<body>
<div class="container pt-3">
    <div class="row">
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarText">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="/car_accident/index">Главная</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/car_accident/create">Добавить инцидент</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Вход/Регистрация</a>
                        </li>
                    </ul>
                    <span class="navbar-text">
                        Соблюдай законы дорог
                    </span>
                </div>
            </div>
        </nav>
    </div>
    <div class="row">
        <div class="row">
                <form:form action="/car_accident/saveOrUpdate" method="post" modelAttribute="accident">
                    <form:input path="id" type="hidden" value="${accident.id}"/>
                    <div class="mb-3">
                        <label for="name" class="form-label">Имя</label>
                        <form:input path="name" value="${accident.name}" type="text" class="form-control" id="name" aria-describedby="emailHelp"/>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Адрес</label>
                        <form:input path="address" value="${accident.address}" type="text" class="form-control" id="address" aria-describedby="emailHelp"/>
                    </div>
                    <div class="mb-3">
                        <label for="text" class="form-label">Описание</label>
                        <form:textarea path="text" value="${accident.text}" class="form-control" id="text" rows="3"/>
                    </div>
                    <div class="mb-3">
                        <label for="type" class="form-label">Тип</label>
                        <form:select path="accidentType.id" value="${accident.accidentType}" class="form-select" id="type">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.id}"
                                        <c:if test="${type.id == accident.accidentType.id}"> selected </c:if>
                                >${type.name}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <div class="mb-3">
                        <label for="rule" class="form-label">Статья</label>
                        <select name="rIds" class="form-select" id="rule" multiple>
                            <<c:forEach items="${rules}" var="rule">
                                <option value="${rule.id}">${rule.name}</option>
                            </c:forEach>>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-light" style="background-color: #e3f2fd;">Сохранить</button>
                </form:form>
        </div>
    </div>
</div>
</body>
</html>
