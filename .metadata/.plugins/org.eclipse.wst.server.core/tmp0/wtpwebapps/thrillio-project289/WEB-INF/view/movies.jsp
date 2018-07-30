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
			<h1>Movies Page</h1>
			
			<br>
					<ul>
						<li><a href="backtohome">Home</a></li>
						<li><a href="myBooks">my books</a></li>
						<li><a href="myMovies">my movies</a></li>
						<li><a href="logout">Logout</a></li>
					</ul>
					<br>
			<div>
				<c:forEach var="tempMovies" items="${movies}">

					<c:url var="moviesLink" value="/movie">
						<c:param name="moviesId" value="${tempMovies.id}" />
					</c:url>
					<c:url var="movieLink" value="/movie/bookmark">
						<c:param name="movieId" value="${tempMovies.id}" />
					</c:url>
					<a class="list-group-item clearfix" style="cursor: pointer"
						href="${moviesLink}">
						<div class="pull-left">
							<h3>${tempMovies.movieTitle}</h3>
							<h6>released_year : ${tempMovies.releaseYear}</h6>
							<h6>written by : ${tempMovies.director}</h6>
							<h6>acted by : ${tempMovies.actor}</h6>
							<h6>Genre : ${tempMovies.movieGenre}</h6>
							<h6>Rating : ${tempMovies.rating}</h6>
							<br>
							<a href="${movieLink}">Bookmark this movie</a>
						</div> 
					</a>


				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>