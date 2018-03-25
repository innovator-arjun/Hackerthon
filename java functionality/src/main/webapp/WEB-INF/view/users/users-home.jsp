<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Header for User -->
	<c:import url="users-header.jsp"></c:import>
	
	<!-- Inner Body -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="text-center">Startup Loans</h1>
				<p><strong>Welcome..<security:authentication property="principal.username"/></strong></p>	
			</div>
		</div>
	</div>
	
	
</body>
</html>