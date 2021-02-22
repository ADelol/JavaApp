<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/login.css" />
<div class="header">
       <ul>
       <li><a href="/RDVMed/Accueil.jsp">Accueil</a></li>
         <li><a href="/RDVMed/Login.jsp">Se connecter</a></li>
		</ul>
		
    </div>
</head>
<%String lastname = (String) request.getAttribute("lastname");%>
<%String name = (String) request.getAttribute("name");%>
<%String email = (String) request.getAttribute("email");%>
<%String phone = (String) request.getAttribute("phone");%>
<%String address = (String) request.getAttribute("address");%>
<%String birthday = (String) request.getAttribute("birthday");%>
<body>
	<form action="/RDVMed/ServletCreationPatient" method="post" class="login-wrap">
		<h1 style="color: white; transform: translateY(-150px);">Inscription patient</h1>
		<label for="">Nom ：</label>
		<input type="text" placeholder="Nom" name="patientnom" /><br>
		<p style="color:red;">${ messages.nom }</p>
		<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Name：</label>
		<input type="text" placeholder="Prénom" name="patientprenom" /><br>
		<p style="color:red;">${ messages.prenom }</p>
		<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email：</label>
		<input type="text" placeholder="Email" name="emailP" /><br>
		<p style="color:red;">${ messages.mail }</p>
		<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Phone：</label>
		<input type="text" placeholder="Phone" name="phoneP"/><br>
		<p style="color:red;">${ messages.tel }</p>
		<label for="">Mot de passe :：</label>
		<input type="password" placeholder="Mot de passe" name="mdpP"/><br>
		<label for="">&nbsp;&nbsp;&nbsp;Addresse：</label>
		<input type="text" placeholder="Addresse" name="adresseP" /><br>
		<label for="">&nbsp;&nbsp;Année de naissance :：</label>
		<input type="text" placeholder="Année de naissance" name="annee" /><br>
		<p style="color:red;">${ messages.annee }</p>
		<button class="button">Confirmer</button>
		<p style="color:red;">${ messages.existant }</p>
	</form>
	
	<script src="../assets/js/jquery.slim.min.js"></script>
	<script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>



