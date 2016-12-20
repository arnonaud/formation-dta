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
<link href="<%=request.getContextPath()%>/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body>
	<div class="container">
		<div class="table-responsive">
			<table class="table table-condensed">
				<thead>
					<tr>
						<th>Code</th>
						<th>Nom</th>
						<th>Prix</th>
						<th>Categorie</th>
						<th>Image</th>
					</tr>
				</thead>
			<%
				List<Pizza> pizzas = (List<Pizza>)request.getAttribute("pizzas");
				for(Pizza p : pizzas){
			%>
					<tr>
						<td><%= p.getCode() %></td>
						<td><%= p.getNom() %></td>
						<td><%= p.getPrix() %></td>
						<td><%= p.getCategorie() %></td>
						<td><img width="50px" src="<%=request.getContextPath()%>/img/<%= p.getUrlImage() %>" /></td>
						<td><a href="<%=request.getContextPath()%>/pizzas/edit?code=<%= p.getCode() %>" class="btn btn-success">Editer</a></td>
						<td><a href="#" class="btn btn-danger">Supprimer</a></td>
					</tr>
			<%
				}
			%>
				
			</table>
		</div>


	</div>
	<!-- /.container -->

</body>
</html>
