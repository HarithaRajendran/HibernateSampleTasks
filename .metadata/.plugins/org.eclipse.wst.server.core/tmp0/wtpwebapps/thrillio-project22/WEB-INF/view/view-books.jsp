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
			<h1>My Books Page</h1>
			<br>
			
			<ul>
				<li><a href="backtohome">Home</a></li>
				<li><a href="myMovies">my movies</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
			
			<br>
		
			<div>
				<c:forEach var="tempBooks" items="${books}">
					
					<c:url var = "deleteBookLink" value = "/book/delete">
						<c:param name = "bookId" value = "${tempBooks.id}"/>
					</c:url> 
					<a class="list-group-item clearfix" style="cursor: pointer">
						<div class="pull-left">
							<h3 class="list-group-item-heading">${tempBooks.bookTitle}</h3>
							<a href="${deleteBookLink}" 
								onclick="if(!(confirm('Are you sure to delete this from your list?'))) return false"
							 >Delete from my list</a>
						</div>
					</a>


				</c:forEach>
			</div>
		</div>
	</div>
	</body>
</html>