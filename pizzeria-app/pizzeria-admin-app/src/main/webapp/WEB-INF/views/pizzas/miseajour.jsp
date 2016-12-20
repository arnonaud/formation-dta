<%@page import="fr.pizzeria.model.CategoriePizza"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
<%@page import="fr.pizzeria.model.Pizza"%>
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
	href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet">

</head>

<body>
	<div class="container">
		<%
			Pizza pizza = (Pizza)request.getAttribute("pizza");
			
		%>
		<form action="updatePizza" class="form-horizontal">
			<fieldset>

				<!-- Form Name -->
				<legend>Editer Pizza</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="code">Code Pizza</label>
					<div class="col-md-4">
						<input id="code" name="code" type="text" placeholder="code"
							class="form-control input-md" value="<%=pizza.getCode()%>">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="nom">Nom</label>
					<div class="col-md-4">
						<input id="nom" name="nom" type="text" placeholder="nom"
							class="form-control input-md" value="<%=pizza.getNom()%>">
					</div>
				</div>

				<!-- Appended Input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="prix">Prix</label>
					<div class="col-md-4">
						<div class="input-group">
							<input id="prix" name="prix" class="form-control"
								placeholder="prix" type="text" value="<%=pizza.getPrix()%>">
							<span class="input-group-addon">euros</span>
						</div>

					</div>
				</div>
				<!-- Select Basic -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="cat">Categorie</label>
					<div class="col-md-4">
						<select id="cat" name="cat" class="form-control">
							<%
								if (pizza.getCategorie().equals("Viande")) {
							%><option value="VIANDE" selected>Viande</option>
							<%
								} else {
							%><option value="VIANDE">Viande</option>
							<%
								}
								if (pizza.getCategorie().equals("Poisson")) {
							%><option value="poisson" selected>Poisson</option>
							<%
								} else {
							%><option value="poisson">Poisson</option>
							<%
								}
								if (pizza.getCategorie().equals("Sans Viande")) {
							%><option value="sans_viande" selected>Sans Viande</option>
							<%
								} else {
							%><option value="sans_viande">Sans Viande</option>
							<%
								}
							%>
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
					<button id="submit" name="submit" class="btn btn-primary">Valider</button>
				</div>
			</fieldset>
		</form>

	</div>



</body>
</html>
