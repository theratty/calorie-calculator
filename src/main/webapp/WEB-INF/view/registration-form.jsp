<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<!doctype html>
<html lang="en">

<head>
	
	<title>Rejestracja</title>

	<style>
		.error {
			color: red;
		}
	</style>

</head>

<body>


	<form:form action="${pageContext.request.contextPath}/register/processRegistrationForm"
			   modelAttribute="crmUser">

		<c:if test="${registrationError != null}">

			<div class="error">
				${registrationError}
			</div>

		</c:if>

		<form:errors path="userName" cssClass="error" />
		<br>
		<form:input path="userName" placeholder="Login (*)" />

		<br>

		<form:errors path="password" cssClass="error" />
		<br>
		<form:password path="password" placeholder="Haslo (*)" />

		<br>

		<form:errors path="matchingPassword" cssClass="error" />
		<br>
		<form:password path="matchingPassword" placeholder="Powtorz haslo (*)" />

		<br>
		<br>

		<form:select path="formRole">
			<form:option value="ROLE_STANDARD">STANDARD</form:option>
		</form:select>

		<br>
		<br>

		<button type="submit">Rejestracja!</button>

	</form:form>

</body>
</html>