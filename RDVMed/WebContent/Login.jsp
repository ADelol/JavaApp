<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="assets/css/login.css" />
</head>
<body>
	<form action="/RDVMed/ServletLogin" method="post" class="login-wrap">
		<h1 style="color: white; transform: translateY(-150px);">Hospital registration system</h1>
		<label for="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Email：</label> 
		<input type="text" placeholder="Email" name="email" id="email"/><br>
		<label for="">Mot de passe ：</label>
		<input type="password" placeholder="Mot de passe" name="mdp" id="password"/><br>
		<div style="text-align: right;padding-right: 110px;"><a href="Patient/Inscription.jsp">Inscription Patient</a></div>
		<button class="button">Connexion</button>
		<p style="color:red;">${ erreurLogin }</p>
	</form>
	<script src="assets/js/jquery.slim.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
</body>
</html>
