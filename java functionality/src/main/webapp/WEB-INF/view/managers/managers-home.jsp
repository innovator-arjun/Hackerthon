<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
</head>
<body>

	<h1>Startup Loans</h1>
	
	<hr>
	
	Welcome!!!!!!
	<hr>
	<p>User Name:: <security:authentication property="principal.username"/> </p>
	<br>
	<p>Roles: <security:authentication property="principal.authorities"/> </p>
	<hr>
	<a href="${pageContext.request.contextPath}/managers/meeting">Leaders Meeting</a>(FOR MANAGER)
	
	<br>
	<br>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="Logout"/>
	</form:form>
</body>
</html>