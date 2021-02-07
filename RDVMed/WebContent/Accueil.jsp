<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<body>
	<div class="total">
		<div class="header">
			<ul>
				<c:if test="${utilisateur.userRole eq 'Administrateur'}">
					<li><a href="/RDVMed/ServletDonneesCentreSpecialite">Créer médecin</a></li>
				</c:if>
				<c:if test="${utilisateur==null}">
					<li><a href="/RDVMed/Patient/Patient_registre.jsp">Inscription patient</a></li>
				</c:if>
				<c:choose>
					<c:when test="${utilisateur==null}">
						<li><a href="/RDVMed/Login.jsp">Se connecter</a></li>
					</c:when>
					<c:otherwise>Bonjour ${prenom} ${nom}
				<li><a href="/RDVMed/ServletLogout">Se déconnecter</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<h1>Bienvenu! Vous etes chez DoctorHouse</h1>
			<img src="/RDVMed/images/doctor.png" alt="Paris">
		</div>
	</div>

	<span class="info">${messages.info}</span>
</body>
</html>