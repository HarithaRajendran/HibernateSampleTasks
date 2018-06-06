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
			<br>

			<ul>
				<li><a href="backtohome">Home</a></li>
				<li><a href="myBooks">my books</a></li>
				<li><a href="myMovies">my movies</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
			
			<div>
				<c:forEach var="tempBook" items="${book}">

					<div class="pull-left">
					<br>
						<h4>${tempBook.bookTitle}</h4><br>
						<h6>publication year : ${tempBook.publicationYear}</h6>
						<h6>published by : ${tempBook.publisher}</h6>
						<h6>written by : ${tempBook.author}</h6>
						<h6>Genre : ${tempBook.bookGenre}</h6>
						<h6>Rating : ${tempBook.rating}</h6>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>