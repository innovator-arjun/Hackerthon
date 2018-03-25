<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-4 col-xs-offset-1 col-sm-offset-3 col-md-4 col-xs-10 col-sm-5">
				<h3 class="text-center">Signup Page</h3>
				<!-- Registration Form -->
				<form:form action="${pageContext.request.contextPath}/signupProcess"
					modelAttribute="user">
					
					<!-- User name -->
					<label>UserName</label>
					<form:input path="username" class="form-control" />
					<!-- Password -->
					<label>Password</label>
					<form:password path="password" class="form-control" />
					<!-- Repeat Password -->
					<label>Repeat Password</label>
					<form:password path="repeatPassword" class="form-control" />
					
					<br>
					<button type="submit" class="btn btn-primary">SignUp</button>
					<br><br>
					<!-- Check for signupError error -->
					<c:if test="${signupError != null}">
						<div class="alert alert-danger col-xs-12">
							${signupError}</div>
					</c:if>
					<!-- Check for userExists error -->
					<c:if test="${userExists != null}">
						<div class="alert alert-danger col-xs-12">
							${userExists}</div>
					</c:if>
					<!-- Check for passwordMismatch error -->
					<c:if test="${passwordMismatch != null}">
						<div class="alert alert-danger col-xs-12">
							${passwordMismatch}</div>
					</c:if>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>