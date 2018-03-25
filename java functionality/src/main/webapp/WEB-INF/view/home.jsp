<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<!-- Header Tab -->
	<c:import url="header.jsp"></c:import>
	<!-- Check for signupError error -->
	<c:if test="${signupSuccess != null}">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="alert alert-success col-xs-offset-1 col-xs-10">
				${signupSuccess}</div>
					
			</div>
		</div>
	</div>
	</c:if>
	<div class="jumbotron">
		<h1 class="text-center">Startup India</h1>
		<p>
			The Start-up India initiative of the Government of India envisages to build a robust Start-up
			ecosystem in the country for nurturing
			<br>
			Copy other info here
		</p>
	</div>
	
</body>
</html>