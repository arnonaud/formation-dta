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

<title>Login</title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value='/bootstrap-3.3.7-dist/css/bootstrap.min.css' />"
	rel="stylesheet">

</head>

<body>
	<div class="container">
		<form method="post" class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>Authentification</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="userid">Identifiant</label>
					<div class="col-md-4">
						<input id="userid" name="userid" type="text"
							placeholder="Identifiant" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Mot de
						passe</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="Mot de passe" class="form-control input-md"
							required="">

					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for=""></label>
					<div class="col-md-4">
						<button id="" name="" class="btn btn-primary">Login</button>
					</div>
				</div>

			</fieldset>
		</form>


	</div>
	<!-- /.container -->
</body>
</html>
