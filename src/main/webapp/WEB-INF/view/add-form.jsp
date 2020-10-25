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
		<h3>Dodaj nowy produkt do bazy danych</h3>
		<form:form action="saveIngredient" modelAttribute="ingredient" method="post">
			<form:hidden path="id" />
			<table>
				<tbody>
				<tr>
					<td><label>Nazwa:</label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><label>Weglowodany:</label></td>
					<td><form:input path="carbs" /></td>
				</tr>
				<tr>
					<td><label>Tluszcze:</label></td>
					<td><form:input path="fats" /></td>
				</tr>
				<tr>
					<td><label>Bialko:</label></td>
					<td><form:input path="proteins" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><button type="submit" class="save">Dodaj</button></td>
				</tr>
				</tbody>
			</table>
		</form:form>
	</div>

	<jsp:include page="parts/footer.jsp" />
</body>

</html>









