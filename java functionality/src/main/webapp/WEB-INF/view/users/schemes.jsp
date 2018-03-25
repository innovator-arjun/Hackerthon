<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Schemes</title>
<link href="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<!-- Header for User -->
	<c:import url="users-header.jsp"></c:import>
	
	<!-- Inner Body -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
				<c:forEach var="scheme" items="${schemes}">
					<div class="panel panel-primary">
					<div class="panel-heading" role="tab" id="heading${scheme.loanSchemeId}">
					<h4 class="panel-title">
					<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${scheme.loanSchemeId}" aria-expanded="false" aria-controls="collapse${scheme.loanSchemeId}">
					${scheme.schemeName}
					</a>
					</h4>
					</div>
					
					<div class="panel-body">
				    <!-- Register Link -->
				    <a class="btn btn-success" href="${pageContext.request.contextPath}/users/registerForm?loanScheme=${scheme.loanSchemeId}">Register</a>
				    <br>
				    
				    <label>Guidelines</label>
				    <p>${scheme.guidelines}</p>
					<div id="collapse${scheme.loanSchemeId}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${scheme.loanSchemeId}">
					<br>
					<label>Eligibility Criteria</label>
				    <p>${scheme.eligibilityCriteria}</p>
					<br>
					<label>Collateral Requirement</label>
				    <c:if test="${scheme.collateral == 0 }">
				    	<p>No</p>
				    </c:if>
				    <c:if test="${scheme.collateral == 1 }">
				    	<p>Yes</p>
				    </c:if>
					<br>
					<label>Required Documents</label>
				    <p>${scheme.requiredDocuments}</p>
					<br>
					<label>Available Banks</label>
				    <ul class="list-group">
				    <c:forEach var="bank" items="${scheme.banks}">
						<li class="list-group-item">
						${bank.bankName}
						</li>
					</c:forEach>
					</ul>
					</div>
				  	</div>
					</div>
				</c:forEach>
				</div>
				<%--  --%>
			
			</div>
		</div>
	</div>
</body>
</html>