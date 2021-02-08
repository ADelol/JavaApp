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
				<c:if test="${utilisateur.userRole eq 'Medecin'}">
					<li><a href="/RDVMed/Medecin/GestionCompte.jsp">Gestion de compte medecin</a></li>
					<li><a href="/RDVMed/Medecin/Agenda">Créer ses agendas</a></li>
				</c:if>
				Bonjour ${prenom} ${nom}
				<li><a href="/RDVMed/ServletLogout">Se déconnecter</a></li>
			</ul>
			<form action="/RDVMed/ServletGestionCompteMedecin" method="post">
				<label for="mail">Mail :</label><br> <input type="email" id="mail" name="mail" value="${medecin.EMAIL_Medecin}"><br> <label for="nom">Nom:</label><br> <input type="text"
					id="nom" name="nom" value="${medecin.NOM_Medecin}"><br> <label for="nom">Prenom :</label><br> <input type="text" id="prenom" name="prenom" value="${medecun.PRENOM_Medecin}"><br>
				<label for="nom">Téléphone :</label><br> <input type="text" id="tel" name="tel" value="${medecin.numTele_Medecin}"><br> <label for="nom">Adresse :</label><br> <input
					type="text" id="adresse" name="adresse" value="${medecin.addressHabit_Medecin}"><br> <label for="nom">
<label for="nom">Mot de passe :</label><br> <input type="text" id="mdp" name="mdp" value="${medecin.MDP_Medecin}"><br> <input
					type="submit" value="Modifier les informations personnelles">
			</form>
			<form action="/RDVMed/ServletSuppressionMedecin" method="post">
				<input type="submit" name="suppression" onclick="return confirm('Confirmer la suppression du compte ?')" value="Supprimer son compte" />
			</form>
		</div>
	</div>
</body>
</html>