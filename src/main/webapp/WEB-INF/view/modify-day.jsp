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

			<p>
				Suma calego dnia:<br>
				Weglowodany(1g = 4kcal): ${day.totalCarbs}g<br>
				Tluszcze(1g = 9kcal): ${day.totalFats}g<br>
				Bialko(1g = 4kcal): ${day.totalProteins}g<br>
				Lacznie energii: ${day.totalKcal}kcal<br>
			</p>

			<hr>

			<table>
				<tr>
					<th>Nazwa</th>
					<th>Waga</th>
					<th>Weglowodany</th>
					<th>Tluszcze</th>
					<th>Bialko</th>
					<th>Energia</th>
					<th></th>
				</tr>
				<c:forEach items="${day.day.dayIngredients}" var="dayIngredient">

					<c:url var="deleteLink" value="/day/deleteIngredient" >
						<c:param name="dayIngredientId" value="${dayIngredient.id}" />
						<c:param name="dayId" value="${day.day.id}" />
					</c:url>

					<c:set var="carbs" value="${dayIngredient.ingredient.carbs * dayIngredient.amount / 100.0}"/>
					<c:set var="fats" value="${dayIngredient.ingredient.fats * dayIngredient.amount / 100.0}"/>
					<c:set var="proteins" value="${dayIngredient.ingredient.proteins * dayIngredient.amount / 100.0}"/>

					<tr>
						<td>${dayIngredient.ingredient.name}</td>
						<td>${dayIngredient.amount}g</td>
						<td>${carbs}g</td>
						<td>${fats}g</td>
						<td>${proteins}g</td>
						<td>${carbs * 4 + fats * 9 + proteins * 4}kcal</td>
						<td><a href="${deleteLink}">Usun</a></td>
					</tr>
				</c:forEach>
			</table>

			<form:form action="addProductToDay" method="get">
				<button name="dayId" value="${day.day.id}">Dodaj produkt do dnia</button>
			</form:form>

		</div>
	</div>

	<jsp:include page="parts/footer.jsp" />
</body>

</html>









