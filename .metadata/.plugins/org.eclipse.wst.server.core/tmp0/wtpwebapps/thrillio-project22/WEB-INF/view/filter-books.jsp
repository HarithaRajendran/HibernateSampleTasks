<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<body>
	<br>
	<div class="container">
		<div class="jumbotron">
			<h1>Books Page</h1>
			<br>

			<ul>
				<li><a href="/thrillio-project/backtohome">Home</a></li>

			</ul>
			<br> <br>
		
			<div>
			<br><br>
				<c:forEach var="tempBooks" items="${filteredBooksBy}">

					<c:url var="booksLink" value="/book">
						<c:param name="booksId" value="${tempBooks.id}" />
					</c:url>
					<c:url var="bookLink" value="/book/bookmark">
						<c:param name="bookId" value="${tempBooks.id}" />
					</c:url>
					<a class="list-group-item clearfix" style="cursor: pointer;"
						href="${booksLink}">
						<div class="pull-left">
							<h3 class="list-group-item-heading">${tempBooks.bookTitle}</h3>
							<h6>publication year : ${tempBooks.publicationYear}</h6>
							<h6>published by : ${tempBooks.publisher.publisherName}</h6>
							<h6>Genre : ${tempBooks.bookGenre}</h6>
							<h6 align="center" style="background-color: white">
								<a style="color: green;" href="${bookLink}">Bookmark this
									book</a>
							</h6>
						</div>
					</a>


				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>