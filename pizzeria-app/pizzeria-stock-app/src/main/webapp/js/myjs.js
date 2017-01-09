$(document).ready(function(){
	
	$.get("http://localhost:8080/arnaud-pizzeria-stock-app/mvc/rest/ingredients/",function(data){
		for(var i=0; i<data.length; i++){
			$("#tableCLi").append("<tr id="+data[i].id+">" +
									"<td>"+ data[i].id +"</td>" +
									"<td>"+ data[i].nom +"</td>" +
									"<td>"+ data[i].prix +"</td>" +
									"<td>"+ data[i].quantite +"</td>" +
								   "</tr>");
		}
	});
	
});

