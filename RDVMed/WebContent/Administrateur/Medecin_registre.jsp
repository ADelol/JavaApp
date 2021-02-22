<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Patient enregistrer</title>
<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script>
<script src="js/function.js"></script>
</head>
<style>
body {
	background-image: url('/PriseRDVMed/images/bg6.jpg');
	background-size: 100%;
	margin: 10px;
	width: 100%;
	height: 100%;
	font-family: sans-serif;
}

.header {
	height: 50px;
	width: 100%;
	z-index: 1;
	background-color: #009FCC;
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

<%--

	 

.reg {
	position: absolute;
	left: 55%;
	top: 60%;
	width: 700px;
	height: 1000px;
	margin: -300px 0 0 -215px;
	border: 8px solid #fff;
	border-radius: 30px;
	overflow: hidden;
}

.reg .p1 {
	display: inline-block;
	font-size: 35px;
	margin-top: 15px;
	width: 86%;
	margin-left: 35%;
	color: #fff;
	font-family: 'lucida grande';
}

.regD {
	position: relative;
	width: 360px;
	margin-left: 50px;
	padding-bottom: 5px;
}

.regD .p2 {
	display: inline-block;
	font-size: 20px;
	margin-top: 10px;
	width: 86%;
	margin-left: 0px;
	color: #fff;
	font-family: 'lucida grande';
}

.regD input {
	width: 288px;
	height: 35px;
	margin-left: 50%;
	padding-left: 30px;
	border: 2.8px solid #fff;
	border-radius: 25px;
	font-size: 15px;
	color: #fff;
	background-color: transparent;
	outline: none;
}

.regBar {
	width: 360px;
	margin: 2px auto 0;
	font-size: 20px;
	overflow: hidden;
}
--%>
</style>
<body >

<div class="header">
       <ul>
       <li><a href="/RDVMed/Patient/Accueil.jsp">Accueil</a></li>
         <li><a href="/RDVMed/Patient/Patient_login.jsp">PATIENT</a></li>
         <li><a href="/RDVMed/Administrateur/Admin_login.jsp">ADMIN</a></li>
         <li><a href="/RDVMed/Medecin/Medecin_login.jsp">DOCTOR</a></li>
         <li><a href="/RDVMed/Patient/Patient_registre.jsp">S'INSCRIRE</a></li>
		</ul>
		
    </div>

<form action="/RDVMed/ServletCreationMedecin"  method="post" onsubmit="return checkForm(this)" >
<div class="reg">
<br>

<div class="ins"><p class="p1">INSCRIPTION</p></div>

<div class="regD"><p class="p2">Email:<input type="text" name="email" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Adresse Mail" /></p>
</div>
<span class="error">${messages.mail}</span>


<div class="regD"><p class="p2">Nom:<input type="text" name="medecinnom" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="votre NOM" /></p>
</div>
<span class="error">${messages.nom}</span>
<div class="regD"><p class="p2">Prenom:<input type="text" name="medecinprenom" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="votre Prenom" /></p>
</div>
<span class="error">${messages.prenom}</span>



<div class="regD"><p class="p2">Telephone:<input type="text" name="phone" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Numero de Tel" /></p>

</div>
<span class="error">${messages.tel}</span>
<div class="regD"><p class="p2">Adresse:<input type="text" name="adresse" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Adresse Habitation" /></p>

</div>



<div class="regD"><p class="p2">Mot de passe :<input type="password" name="mdp" autocomplete="off" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="Mot de passe" /></p>

</div>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="listes">
<div id="doubleListe">
Sélectionner le nom d'un centre :
<select name="centreList1">
    <c:forEach var="c" items="${centres}">
        <option value="${c.ID_CentreMedecin}" > ${c.nomCentreMedecin}</option>
    </c:forEach>
</select>

Sélectionner une spécialité :
<select name="specialiteList1">
    <c:forEach var="s" items="${specialites}">
        <option value="${s.ID_Specialite}" > ${s.NOM_Specialite}</option>
    </c:forEach>
</select>
</div>
</div>
<button type="button" class="clonebtn">Cliquer pour ajouter une spécialité/centre médical</button><br><br>
<input id="cpt" type="hidden"  name="cpt" value="1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script>
var cpt = 1;
$(document).ready(function(){ 
    $('.clonebtn').click(function(){
    	$('#cpt').get(0).value++;
    	cpt++;
        var nextDoubleList = $("#doubleListe").clone();
        nextDoubleList.find(('select[name="specialiteList1"]')).attr('name','specialiteList'+cpt);
    	nextDoubleList.find(('select[name="centreList1"]')).attr('name','centreList'+cpt);
    	nextDoubleList.attr('id','doubleList'+cpt);
        nextDoubleList.appendTo($("#listes"));

    });
});


</script>




<div class="regBar">
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input id="regC" type="submit" value="Confirmer" style="font-size:18px;"/>
<br>
</div>

</form>

</body>
</html>