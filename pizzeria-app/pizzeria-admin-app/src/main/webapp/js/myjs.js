$(document).ready(function(){
	$.get("http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/",function(data){
		for(var i=0; i<data.length; i++){
			$("#tableCLi").append("<tr>" +
									"<td>"+ data[i].nom +"</td>" +
									"<td>"+ data[i].mail +"</td>" +
									"<td><a class='btn btn-success'>Editer</a></td>" +
									"<td><a class='btn btn-danger'>Supprimer</a></td>" + 
								   "</tr>");
		}
	});
});
	

function display(){
	$("#cliForm").css("display", "block");
}

function addCli(){
	$.post("http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/", {
		"nom":"TIT",
		"mail":"test",
		"mdp":12
	});
	

}