



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="../assets/css/main.css" />
</head>

<body>
	<ul>
		<li><a href="/RDVMed/Accueil.jsp">Accueil</a></li>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


		<li><a href="/RDVMed/ServletLogout">Se déconnecter</a></li>
	</ul>

	<div class="main">
		<div class="main-left">Bonjour ${prenom} ${nom}</div>
		<div class="main-right">
			<form action="/RDVMed/ServletCreationMedecin" method="post"
				onsubmit="return checkForm(this)">
				<div class="reg">
					<br>

					<div class="ins">
						<p class="p1">INSCRIPTION</p>
					</div>

					<div class="regD">
						<p class="p2">
							Email:<input type="text" name="email" autocomplete="off"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"
								placeholder="Adresse Mail" />
						</p>
					</div>
					<span class="error">${messages.mail}</span>


					<div class="regD">
						<p class="p2">
							Nom:<input type="text" name="medecinnom" autocomplete="off"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"
								placeholder="votre NOM" />
						</p>
					</div>
					<span class="error">${messages.nom}</span>
					<div class="regD">
						<p class="p2">
							Prenom:<input type="text" name="medecinprenom" autocomplete="off"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"
								placeholder="votre Prenom" />
						</p>
					</div>
					<span class="error">${messages.prenom}</span>



					<div class="regD">
						<p class="p2">
							Telephone:<input type="text" name="phone" autocomplete="off"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"
								placeholder="Numero de Tel" />
						</p>

					</div>
					<span class="error">${messages.tel}</span>
					<div class="regD">
						<p class="p2">
							Adresse:<input type="text" name="adresse" autocomplete="off"
								onfocus="FocusItem(this)" onblur="CheckItem(this)"
								placeholder="Adresse Habitation" />
						</p>

					</div>



					<div class="regD">
						<p class="p2">
							Mot de passe :<input type="password" name="mdp"
								autocomplete="off" onfocus="FocusItem(this)"
								onblur="CheckItem(this)" placeholder="Mot de passe" />
						</p>

					</div>

					<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
					<div id="listes">
						<div id="doubleListe">
							Sélectionner le nom d'un centre : <select name="centreList1">
								<c:forEach var="c" items="${centres}">
									<option value="${c.ID_CentreMedecin}">
										${c.nomCentreMedecin}</option>
								</c:forEach>
							</select> Sélectionner une spécialité : <select name="specialiteList1">
								<c:forEach var="s" items="${specialites}">
									<option value="${s.ID_Specialite}">
										${s.NOM_Specialite}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<button type="button" class="clonebtn">Cliquer pour
						ajouter une spécialité/centre médical</button>
					<br>
					<br> <input id="cpt" type="hidden" name="cpt" value="1">
					<script
						src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
					<script>
						var cpt = 1;
						$(document)
								.ready(
										function() {
											$('.clonebtn')
													.click(
															function() {
																$('#cpt')
																		.get(0).value++;
																cpt++;
																var nextDoubleList = $(
																		"#doubleListe")
																		.clone();
																nextDoubleList
																		.find(
																				('select[name="specialiteList1"]'))
																		.attr(
																				'name',
																				'specialiteList'
																						+ cpt);
																nextDoubleList
																		.find(
																				('select[name="centreList1"]'))
																		.attr(
																				'name',
																				'centreList'
																						+ cpt);
																nextDoubleList
																		.attr(
																				'id',
																				'doubleList'
																						+ cpt);
																nextDoubleList
																		.appendTo($("#listes"));

															});
										});
					</script>




					<div class="regBar">
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input id="regC" type="submit" value="Confirmer"
							style="font-size: 18px;" /> <br>
					</div>
			</form>

		</div>
	</div>

	<script src="../assets/js/jquery.slim.min.js"></script>
	<script src="../assets/js/bootstrap.min.js"></script>
	<script src="../assets/js/main.js"></script>
</body>
</html>