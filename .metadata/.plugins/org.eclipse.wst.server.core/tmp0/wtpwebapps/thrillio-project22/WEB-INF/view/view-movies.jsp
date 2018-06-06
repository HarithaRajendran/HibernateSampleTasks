<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Thrillio</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css" />
</head>
<body>
	<br>
	<div class="container">
		<div class="jumbotron">
			<h1>My Movies Page</h1>
			<br>
			<ul>
				<li><a href="backtohome">Home</a></li>
				<li><a href="myBooks">My Books</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
			<br>
			<div>
				<c:forEach var="tempMovies" items="${movies}">

					<c:url var = "deleteMovieLink" value = "/movie/delete">
						<c:param name = "movieId" value = "${tempMovies.id}"/>
					</c:url>  

					<a class="list-group-item clearfix" style="cursor: pointer">
						<div class="pull-left">
							<h3 class="list-group-item-heading">${tempMovies.movieTitle}</h3>
							<a href = "${deleteMovieLink}"
								onclick="if(!(confirm('Are you sure to delete this from your list?'))) return false">delete from my list</a>
						</div> 
					</a>


				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>