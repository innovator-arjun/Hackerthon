<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span>
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${pageContext.request.contextPath}/users/home"><strong>MyGov</strong></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">
				<li>
					<a href="${pageContext.request.contextPath}/users/schemes">Schemes</a>
				</li>
				<li>
					<a href="#">Status</a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li>
				<form:form class="navbar-form" action="${pageContext.request.contextPath}/logout" method="POST">
					<button class="btn btn-danger" type="submit"><span class="glyphicon glyphicon-log-out"></span> LogOut</button>
				</form:form>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>
<script src="${pageContext.request.contextPath}/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
