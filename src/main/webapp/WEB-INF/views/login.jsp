<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel = "stylesheet" href = "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
    <style>
        i.mysize {font-size: 20em; color: #e3f2fd;}
    </style>
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
<div class="container pt-1">
    <div class="row pt-2 row-cols-auto">
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0px;">
                    ${errorMessage}
            </div>
        </c:if>
    </div>
    <div class="row pt-2">
        <form name='login' action="<c:url value='/login'/>" method='POST'>
            <div class="card col-8" style="width: 100%">
                <div class="card-header">
                    Авторизация
                </div>
                <div class="card-body">
                    <div class="form-group col-8">
                        <label>Логин</label>
                        <input type="text" class="form-control" name="username">
                    </div>
                    <div class="form-group col-8">
                        <label>Пароль</label>
                        <input type="password" class="form-control" name="password">
                    </div>
                        <button type="submit" class="btn btn-primary" >Войти</button>
                </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </div>
        </form>
    </div>
</div>
</body>
</html>