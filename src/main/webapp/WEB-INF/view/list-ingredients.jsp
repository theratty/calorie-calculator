<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Calorie Calculator</title>
	<style>
		table {
			border-collapse:collapse;
			border-bottom:1px solid gray;
			font-family: Tahoma,Verdana,Segoe,sans-serif;
			width:72%;
		}

		th {
			border-bottom:1px solid gray;
			background:none repeat scroll 0 0 #09c332;
			padding:10px;
			color: #FFFFFF;
		}

		tr {
			border-top:1px solid gray;
			text-align:center;
		}

		tr:nth-child(even) {background: #FFFFFF}
		tr:nth-child(odd) {background: #BBBBBB}
	</style>
</head>
<body>
	<jsp:include page="parts/header.jsp" />

	<div id="container">
		<div id="content">

			<br>
			<h3>
				Wartosci odzywcze w tabelce przedstawione sa na 100 gram produktu
			</h3>
			<br>
			<form:form action="search" method="get">
				<input type="text" name="name">

				<c:if test="${not empty dayId}">
					<input type="hidden" name="dayId" value="${dayId}">
				</c:if>

				<button type="submit" class="add-button">Szukaj</button>
			</form:form>
			<br>
			<table>
				<tr>
					<th>Nazwa</th>
					<th>Weglowodany</th>
					<th>Tluszcze</th>
					<th>Bialko</th>
					<th>Energia</th>
					<c:if test="${not empty dayId}">
						<th></th>
					</c:if>

				</tr>
				<c:forEach items="${ingredients}" var="ingredient">

					<tr>
						<td>${ingredient.name}</td>
						<td>${ingredient.carbs}g</td>
						<td>${ingredient.fats}g</td>
						<td>${ingredient.proteins}g</td>
						<td>${ingredient.carbs * 4 + ingredient.fats * 9 + ingredient.proteins * 4}kcal</td>
						<c:if test="${not empty dayId}">
							<c:url var="addLink" value="/day/appendIngredient">
								<c:param name="dayId" value="${dayId}" />
								<c:param name="ingredientId" value="${ingredient.id}" />
							</c:url>
							<td><a href="${addLink}">Dodaj</a></td>
						</c:if>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<jsp:include page="parts/footer.jsp" />
</body>

</html>









