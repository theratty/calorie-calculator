<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Calorie Calculator</title>
</head>

<body>
	<jsp:include page="parts/header.jsp" />
	<p>
	<a href="${pageContext.request.contextPath}/ingredient/list">Przegladaj produkty</a>
		<br>
		<br>
	<a href="${pageContext.request.contextPath}/day/list">Przegladaj twoje dni</a>
		<br>
		<br>
	<a href="${pageContext.request.contextPath}/ingredient/showAddForm">Dodaj nowy produkt</a>
	</p>

	<jsp:include page="parts/footer.jsp" />
</body>

</html>









