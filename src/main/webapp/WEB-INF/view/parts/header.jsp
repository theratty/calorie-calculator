<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Header File</title>
</head>
<body>
    <h1>Calorie Calculator</h1>

    <sec:authorize access="not isAuthenticated()">
        <form:form action="${pageContext.request.contextPath}/register/showRegistrationForm" method="get">
            <input type="submit" value="Rejestracja">
        </form:form>
        <br>
        <form:form action="${pageContext.request.contextPath}/login/showMyLoginPage" method="post">
            <input type="submit" value="Zaloguj">
        </form:form>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <form:form action="${pageContext.request.contextPath}/logout" method="post">
            <input type="submit" value="Wyloguj">
        </form:form>
        <hr>
        Zalogowany jako: <sec:authentication property="principal.username" />
    </sec:authorize>

    <hr>
</body>
</html>
