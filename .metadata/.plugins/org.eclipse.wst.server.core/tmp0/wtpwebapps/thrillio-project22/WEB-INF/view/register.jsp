<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Thrillio</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css" />
</head>
<body class="back-color">
	<div class=container>
		<div>
			<br> <br> <br>

			<div class="container">
				<div class="jumbotron">
					<h1 align=center>Register Page</h1>
					<br>
					<ul>
						<li><a href="login">Login</a></li>
						<li><a href="/thrillio-project/register">Register</a></li>
					</ul>
					<br>


					<form:form action="success" modelAttribute="theUser" method="post">
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="firstName">First Name:</label>
									<form:input path="firstName" class="form-control"
										id="firstName" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="lastName">Last name:</label>
									<form:input path="lastName" class="form-control" id="lastName" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Email address:</label>
									<form:input path="email" class="form-control" id="email" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="email">Password</label>
									<form:input type="password" path="password"
										class="form-control" id="password" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-3"></div>
							<div class="col-md-6">
								<input class="btn btn-success" type="submit" value="Register">
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>