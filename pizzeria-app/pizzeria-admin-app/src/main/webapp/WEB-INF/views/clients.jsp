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

<title>Liste Clients</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.min.css' />"
	rel="stylesheet">
<link href="<c:url value='/css/style.css' />" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.3.js"></script>
<script src="<c:url value='/js/myjs.js' />"></script>
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
			<table id="tableCLi" class="table table-condensed"
				style="margin-top: 100px;">
				<thead>
					<tr>
						<th>Id</th>
						<th>Nom</th>
						<th>Mail</th>
					</tr>
				</thead>
				<tbody>
				
				
				
				</tbody>
			</table>
			<a id="addClient" class="btn btn-primary">Ajout</a>
		</div>
		<br /> <br />
		<div id="cliFormAdd">

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nomCli">Nom</label>
				<div class="col-md-4">
					<input id="nomCli" name="nomCli" type="text" placeholder="nom"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="mailCli">Mail</label>
				<div class="col-md-4">
					<input id="mailCli" name="mailCli" type="text" placeholder="mail"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="mdpCli">Mot de
					passe</label>
				<div class="col-md-4">
					<input id="mdpCli" name="mdpCli" type="text"
						placeholder="mot de passe" class="form-control input-md">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submitCli"></label>
				<div class="col-md-4">
					<button id="submitCliAdd" name="submitCliAdd"
						class="btn btn-primary">Envoyer</button>
				</div>
			</div>


		</div>
		<div id="cliFormEdit">
			<input type="hidden" id="idCliEdit" />
			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="nomCli">Nom</label>
				<div class="col-md-4">
					<input id="nomCliEdit" name="nomCli" type="text" placeholder="nom"
						class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="mailCli">Mail</label>
				<div class="col-md-4">
					<input id="mailCliEdit" name="mailCli" type="text"
						placeholder="mail" class="form-control input-md" required="">

				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label" for="mdpCli">Mot de
					passe</label>
				<div class="col-md-4">
					<input id="mdpCliEdit" name="mdpCli" type="text"
						placeholder="mot de passe" class="form-control input-md">

				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label" for="submitCli"></label>
				<div class="col-md-4">
					<button id="submitCliEdit" name="submitCliEdit"
						class="btn btn-primary">Envoyer</button>
				</div>
			</div>


		</div>
	</div>
	<!-- /.container -->
</body>
</html>
