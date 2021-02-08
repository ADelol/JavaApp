<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="total">
		<div class="header">
			<ul>
				<li><a href="/RDVMed/Accueil.jsp">Accueil</a></li>
				<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<c:if test="${utilisateur.userRole eq 'Patient'}">
					<li><a href="/RDVMed/Patient/GestionCompte.jsp">Gestion de compte patient</a></li>
					<li><a href="/RDVMed/ServletDonneesCentreSpecialite">Créer un rendez-vous</a></li>
					<li><a href="/RDVMed/ServletDonneesCentreSpecialite">Visualiser ses rendez-vous</a></li>
				</c:if>
				Bonjour ${prenom} ${nom}
				<li><a href="/RDVMed/ServletLogout">Se déconnecter</a></li>
			</ul>
			<form action="/RDVMed/ServletGestionComptePatient" method="post">
				<label for="mail">Mail :</label><br> <input type="email" id="mail" name="mail" value="${patient.emailPatient}"><br> <label for="nom">Nom:</label><br> <input type="text"
					id="nom" name="nom" value="${patient.NOMPatient}"><br> <label for="nom">Prenom :</label><br> <input type="text" id="prenom" name="prenom" value="${patient.PRENOMPatient}"><br>
				<label for="nom">Téléphone :</label><br> <input type="text" id="tel" name="tel" value="${patient.numTelePatient}"><br> <label for="nom">Adresse :</label><br> <input
					type="text" id="adresse" name="adresse" value="${patient.addressHabitPatient}"><br> <label for="nom">Année de naissance :</label><br> <input type="text" id="annee" name="annee"
					value="${patient.ANNEENaissance}"><br> <label for="nom">Mot de passe :</label><br> <input type="text" id="mdp" name="mdp" value="${patient.MDPPatient}"><br> <input
					type="submit" value="Modifier les informations personnelles">
			</form>
			<form action="/RDVMed/ServletSuppressionPatient" method="post">
				<input type="submit" name="suppression" onclick="return confirm('Confirmer la suppression du compte ?')" value="Supprimer son compte" />
			</form>
		</div>
	</div>
</body>
</html>