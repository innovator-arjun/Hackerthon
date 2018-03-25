<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<c:import url="header.jsp"></c:import>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-offset-4 col-xs-offset-1 col-sm-offset-3 col-md-4 col-xs-10 col-sm-5">

				<h3 class="text-center">Login Page</h3>
				<form:form action="${pageContext.request.contextPath}/authenticate"
					method="POST">
					<label>UserName</label>
					<input class="form-control" type="text" name="username" />
					<br>
					<label>Password</label>
					<input class="form-control" type="password" name="password" />
					<br>
					<input class="btn btn-primary" type="submit" value="Login" />
				</form:form>
				<br>
				<c:if test="${param.error != null}">
					<p class="alert alert-danger"><span>Sorry Invalid Username/Password</span></p>
				</c:if>
				<c:if test="${param.logout != null}">
					<p class="alert alert-success"><span>You Have been Logged out!!!</span></p>
				</c:if>

			</div>
		</div>
	</div>

</body>
</html>