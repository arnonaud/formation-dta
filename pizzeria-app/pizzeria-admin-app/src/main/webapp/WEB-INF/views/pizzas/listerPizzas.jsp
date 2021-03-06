<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Liste Pizzas</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.min.css' />"
	rel="stylesheet">

</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<c:url value='/pizzas/list' />">Pizzeria</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/pizzas/list' />">Liste</a></li>
					<li><a href="<c:url value='/pizzas/ajout' />">Ajout</a></li>
					<li><a href="<c:url value='/pizzas/technique' />">Technique</a></li>
					<li><a href="<c:url value='/clients' />">Clients</a></li>
					<li><a href="<c:url value='/logout' />">Logout</a></li>
				</ul>

			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div class="table-responsive">
			<table class="table table-condensed" style="margin-top: 100px;">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Categorie</th>
						<th>Image</th>
					</tr>
				</thead>
				<c:forEach var="pizza" items="${pizzas}">
					<tr>
						<td>${pizza.code}</td>
						<td>${pizza.nom}</td>
						<td>${pizza.prix}</td>
						<td>${pizza.categorie}</td>
						<td><img width="50px"
							src="<c:url value='/img/${pizza.urlImage}' />" /></td>
						<td><a
							href="<c:url value='/pizzas/edit?code=${pizza.code}' />"
							class="btn btn-success">Editer</a></td>
						<td><a
							href="<c:url value='/pizzas/suppression?code=${pizza.code}' />"
							class="btn btn-danger">Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<!-- /.container -->
</body>
</html>
