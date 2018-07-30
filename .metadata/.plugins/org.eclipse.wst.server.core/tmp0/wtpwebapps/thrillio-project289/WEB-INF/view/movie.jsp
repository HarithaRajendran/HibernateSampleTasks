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
			<br> <ul>
						<li><a href="backtohome">Home></a></li>
						<li><a href="myBooks">my books</a></li>
						<li><a href="myMovies">my movies</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
			<br>

			<div>
				<c:forEach var="tempMovie" items="${movie}">

					<div class="pull-left">
						<h4>${tempMovie.movieTitle}</h4>
						<h6>released_year : ${tempMovie.releaseYear}</h6>
						<h6>written by : ${tempMovie.director}</h6>
						<h6>acted by : ${tempMovie.actor}</h6>
						<h6>Genre : ${tempMovie.movieGenre}</h6>
						<h6>Rating : ${tempMovie.rating}</h6>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>