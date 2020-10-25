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
			<form:form action="search" method="get">
				<input type="text" name="name">
				<button type="submit" class="add-button">Szukaj</button>
			</form:form>
			<br>
			<table>
				<tr>
					<th>Nazwa dnia / Opis</th>
					<th>Akcje</th>
				</tr>

				<c:forEach items="${days}" var="day">
					
					<c:url value="/day/delete" var="deleteDayLink">
						<c:param name="dayId" value="${day.id}" />
					</c:url>

					<c:url value="/day/modify" var="modifyDayLink">
						<c:param name="dayId" value="${day.id}" />
					</c:url>

					<tr>
						<td>${day.description}</td>
						<td>
							<a href="${modifyDayLink}">Modyfikuj</a>
							|
							<a href="${deleteDayLink}">Usun</a>
						</td>
					</tr>
				</c:forEach>

			</table>

			<br>
			<form:form action="add" method="get">
				<button type="submit" class="add-button">Dodaj nowy dzien</button>
			</form:form>

		</div>
	</div>


	<jsp:include page="parts/footer.jsp" />
</body>

</html>

