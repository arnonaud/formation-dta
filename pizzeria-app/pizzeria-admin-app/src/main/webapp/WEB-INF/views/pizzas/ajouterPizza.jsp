<%@page import="fr.pizzeria.model.CategoriePizza"%>
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

<title>Ajout Pizza</title>

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
				<a class="navbar-brand" href="<c:url value='/pizzas/list' />" >Pizzeria</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<c:url value='/pizzas/list' />" >Liste</a></li>
					<li><a href="<c:url value='/pizzas/ajout' />" >Ajout</a></li>
					<li><a href="<c:url value='/pizzas/technique' />" >Technique</a></li>
					<li><a href="<c:url value='/clients' />" >Clients</a></li>
					<li><a href="<c:url value='/logout' />" >Logout</a></li>
				</ul>
				
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
	<div class="container">
		<form method="post" class="form-horizontal" style="margin-top: 100px;">
			<fieldset>

				<!-- Form Name -->
				<legend>Ajouter Pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code Pizza</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code"
							class="form-control input-md" >

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom"
							class="form-control input-md" >
					</div>
				</div>

				<!-- Appended Input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<div class="input-group">
							<input id="prix" name="prix" class="form-control"
								placeholder="prix" type="text" > <span
								class="input-group-addon">euros</span>
						</div>

					</div>
				</div>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="cat">Categorie</label>
					<div class="col-md-4">
						<select id="cat" name="cat" class="form-control">
							<option value="VIANDE" selected>Viande</option>
							<option value="POISSON">Poisson</option>
							<option value="SANS_VIANDE">Sans Viande</option>
						</select>
					</div>
				</div>

				<!-- File Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="img">Image Pizza</label>
					<div class="col-md-4">
						<input id="img" name="img" class="input-file" type="file">
					</div>
				</div>
				<label class="col-md-4 control-label" for="submit"></label>
				<div class="col-md-4">
					<input type="hidden" id="prevCode" name="prevCode"
						value="<c:out value="${prevCode}"/>" />
					<button id="submit" name="submit" class="btn btn-primary">Valider</button>
				</div>
			</fieldset>
		</form>

	</div>



</body>
</html>
