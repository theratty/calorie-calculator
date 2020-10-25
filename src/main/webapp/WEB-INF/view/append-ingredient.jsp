<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Calorie Calculator</title>
</head>
<body>
	<jsp:include page="parts/header.jsp" />

	<div id="container">
		<form:form action="saveDayIngredient" method="post">
			<h1>Ile gram produktu dodac:</h1>
			<input type="hidden" name="dayId" value="${dayId}" />
			<input type="hidden" name="ingredientId" value="${ingredientId}" />
			<input type="text" name="amount" />
			<input type="submit" value="Dodaj!">
		</form:form>
	</div>

	<jsp:include page="parts/footer.jsp" />
</body>

</html>









