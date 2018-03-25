<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<!-- Header for User -->
	<c:import url="users-header.jsp"></c:import>
	
	<!-- Inner Body -->
	<div class="container-fluid">
	<div class="row">
	<!-- Form Starting -->
	<form:form>
	<div class="col-xs-6">
		<!-- User Full Name -->
		<form:input path="" class="form-control"/>
		
		<!-- Age -->
		<form:input path="" class="form-control"/>
		
		<!-- Phone Number -->
		<form:input path="" class="form-control"/>
				
		<!-- Address -->
		<form:input path="" class="form-control"/>
		
		<!-- Occupation -->
		<form:input path="" class="form-control"/>
		
		<!-- Previous Loan -->
		<form:checkbox path="" class="form-control"/>
	</div>
	<div class="col-xs-6">
		<!-- Aadhar Card -->
		<input type="file" name="aadharCard" class="form-control"/>
		
		<!-- Pan Card -->
		<input type="file" name="panCard" class="form-control"/>	
		
		<!-- Photo -->
		<input type="file" name="photo" class="form-control"/>
	
	</div>
	</form:form>
	</div>
	</div>
</body>
</html>