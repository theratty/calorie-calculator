<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<html>

<head>
	<title>Custom Login Page</title>
	
	<style>
		.failed {
			color: red;
		}
	</style>
	
</head>

<body>

<h3>Strona logowania</h3>

	<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">

	
		<c:if test="${param.error != null}">
		
			<i class="failed">Niepoprawne haslo lub login.</i>
			
		</c:if>
			
		<p>
			Login: <input type="text" name="username" />
		</p>

		<p>
			Haslo: <input type="password" name="password" />
		</p>
		
		<input type="submit" value="Zaloguj!" />
		
	</form:form>

</body>

</html>












