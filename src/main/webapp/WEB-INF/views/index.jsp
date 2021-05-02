<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Accident</title>
</head>
<body>
Hello : Accident
<c:forEach items="${example}" var="ex">
    <br>
    <c:out value="${ex}"/>
</c:forEach>
</body>
</html>