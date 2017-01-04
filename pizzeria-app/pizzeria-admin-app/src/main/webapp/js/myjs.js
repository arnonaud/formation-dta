$(document).ready(function(){
	
	$.get("http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/",function(data){
		for(var i=0; i<data.length; i++){
			$("#tableCLi").append("<tr id="+data[i].id+">" +
									"<td>"+ data[i].id +"</td>" +
									"<td>"+ data[i].nom +"</td>" +
									"<td>"+ data[i].mail +"</td>" +
									"<td><a onClick='displayFormEdit("+ data[i].id +")' class='btn btn-success'>Editer</a></td>" +
									"<td><a onClick='deleteCli("+ data[i].id +")' class='btn btn-danger'>Supprimer</a></td>" + 
								   "</tr>");
		}
	});
	
	$("#addClient").click(function(){
		displayFormAdd();
	});

	$("#submitCliAdd").click(function(){
		addCli();
	});
	$("#submitCliEdit").click(function(){
		editCli();
	});
	

});


function displayFormAdd(){
	$("#cliFormAdd").css("display", "block");
}


function addCli(){
	$.ajax({
	        url: 'http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/',
	        type: 'POST',
	        contentType: 'application/json',
	        
	        data: JSON.stringify({
	            nom: document.getElementById('nomCli').value,
	            mail:document.getElementById('mailCli').value,
	            mdp: document.getElementById('mdpCli').value
	        }),
	        dataType: 'json',
	        cache: true
	    });
	$("#cliForm").css("display", "none");
	location.reload();
	
}

function deleteCli(id){
	$.ajax({
	    url: 'http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/?id='+id,
	    type: 'DELETE'     
	});
	location.reload();
	
}

function displayFormEdit(id,nom){
	$("#cliFormEdit").css("display", "block");
	$("#idCliEdit").val(id);
}

function editCli(){
	var id = $("#idCliEdit").val();
	$.ajax({
	    url: 'http://localhost:8080/arnaud-pizzeria-admin-app/api/rest/clients/?id='+id,
	    type: 'PUT'
	});
	location.reload();
}