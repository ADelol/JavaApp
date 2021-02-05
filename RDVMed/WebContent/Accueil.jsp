<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>la page d'acceuil</title>
</head>
<style>
body {
	background-color: #CCDDFF;
	margin: 10px;
	width: 100%;
	height: 100%;
	font-family: sans-serif;
}

.header {
	height: 500px;
	width: 100%;
	background-color: #009FCC;
}

.info {
	border: 3px solid white;
	border-radius: 30px;
	position: absolute;
	left: 90px;
	top: 350px;
	width: 500px;
	height: 300px;
	z-index: 999;
}

.header>ul>li {
	list-style: none;
	display: inline-block;
	font-size: 90%;
	padding-left: 12%;
	padding-bottom: 1%;
}

ul {
	padding-top: 1%;
	padding-left: 15%;
	border-bottom: 1px solid #CCEEFF;
}

h1 {
	padding-top: 80px;
	font-family: STXinwei;
	font-size: 70px;
	color: #FFFFFF;
	z-index: 999;
}

.header img {
	position: absolute;
	margin-bottom: 50px;
	padding-bottom: 50px;
	padding-left: 400px;
	width: 70%;
}

a {
	text-decoration: none;
}

a:link {
	color: gainsboro;
}

a:visited {
	color: gainsboro;
}

a:hover {
	color: white;
}

a:active {
	color: white;
}
</style>
<body>
	<div class="total">
		<div class="header">
			<ul>
				<li><a href="/RDVMed/Patient/Patient_login.jsp">PATIENT</a></li>
				<li><a href="/RDVMed/Administrateur/Admin_login.jsp">ADMIN</a></li>
				<li><a href="/RDVMed/ServletDonneesCentreSpecialite">Créer médecin</a></li>
				<li><a href="/RDVMed/Patient/Patient_registre.jsp">S'INSCRIRE</a></li>
			</ul>
			<h1>Bienvenu! Vous etes chez DoctorHouse</h1>
			<img src="/RDVMed/images/doctor.png" alt="Paris">
		</div>
	</div>
	<form action="/RDVMed" method="post">
	<p>Connexion à l'application </p>
		Email:<input type="email" name="email" /><br /> <br /> Mot de
		passe:<input type="password" name="password" /><br /> <br /> <input
			type="submit" />"
	</form>
	<span class="info">${messages.info}</span>
</body>
</html>