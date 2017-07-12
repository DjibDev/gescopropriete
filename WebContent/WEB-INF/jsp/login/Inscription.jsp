<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>R�sidence des Tilleuls</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/theme/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/theme/css/style.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/js/jquery/jquery-2.2.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/js/checkForm.js"></script>
	<script type="text/javascript"
	src="<%=request.getContextPath()%>/scripts/js/globales.js"></script>
</head>
<body>
	<div class="jumbotron text-center ">
		<img src="<%=request.getContextPath()%>/images/banniere_redim.png"
			width="50%">
	</div>

	<div class="container">
		
		<c:set  var = "listeLogin" scope = "request" value = "${listeLogin}"/>
		<input type="hidden" id="longueurListeLogin" value="${fn:length(listeLogin)}" />
		<c:forEach var="login" items="${requestScope['listeLogin']}" varStatus="loop" >
			<input type="hidden" id="login_${loop.index}" value="${login}" />
		</c:forEach>

		<form class="well form-horizontal"
			action="<%=request.getContextPath()%>/login/valider_inscription"
			method="post" name="formInscription" >
			<fieldset>
				
				<!-- Form Name -->
				<legend>
					<b>Inscription</b> - Veuillez rentrer vos informations
				</legend>
				<input type="hidden" value="${requestScope['idTemp']}"  name="idTemp" />	
				<input type="hidden" value="${requestScope['mdpTemp']}" name="mdpTemp" />	
				
				<!-- Text input-->

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Pr�nom</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="prenom"
								id="prenom" placeholder="Pr�nom" class="form-control"
								type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Nom</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="nom" id="nom"
								placeholder="Nom" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">E-Mail</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="email"
								id="email" placeholder="Adresse E-mail" class="form-control"
								type="text">
						</div>
					</div>
				</div>


				<!-- Text input-->

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">T�l�phone
						(fixe ou portable)</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input
								name="telephone" id="telephone" placeholder="0102030405" class="form-control"
								type="text">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Appartement</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <select name="porte" id="porte"
								class="form-control selectpicker">
								<option value=" ">Porte (en partant de la gauche)</option>
								<option value="1">1�re porte</option>
								<option value="2">2�me porte</option>
								<option value="3">3�me porte</option>
								<option value="4">4�me porte</option>
							</select> <select name="etage" class="form-control selectpicker" id="etage">
								<option value=" ">Etage</option>
								<option value="0">RdC (ou �tage 0)</option>
								<option value="1">1er �tage</option>
								<option value="2">2�me �tage</option>
								<option value="3">3�me �tage</option>
								<option value="4">4�me �tage</option>
							</select> <select name="batiment" class="form-control selectpicker" id="batiment">
								<option value=" ">B�timent</option>
								<option value="B1">4 All�e des Tilleuls</option>
								<option value="B2">2 All�e des Tilleuls</option>
								<option value="B3A">55 Avenue de la Choli�re</option>
								<option value="B3B">57 Avenue de la Choli�re</option>
								<option value="B3D">59 Avenue de la Choli�re</option>
								<option value="B3D">61 Avenue de la Choli�re</option>
								<option value="B3E">63 Avenue de la Choli�re</option>
							</select>

						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Vous
						�tes</label>
					<div class="col-xl-4 col-lg-4 col-md-4 col-sm-4 selectContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-list"></i></span> <select name="type_res" id="type_res"
								class="form-control selectpicker">
								<option value="1">Locataire</option>
								<option value="2">Propri�taire r�sident</option>
								<option value="3">Propri�taire non-r�sident</option>
							</select>
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Identifiant*</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-log-in"></i></span> <input
								name="identifiant" placeholder="Identifiant" id="identifiant"
								class="form-control" type="text" />
						</div>
					</div>
				</div>

				<!-- Text input-->

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Mot
						de passe*</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input name="password" id="password"
								placeholder="Mot de Passe" class="form-control" type="password">
						</div>
					</div>
				</div>

				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label">Confirmation
						Mot de passe*</label>
					<div
						class="col-xl-4 col-lg-4 col-md-4 col-sm-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i></span> <input name="Vpassword" id="Vpassword"
								placeholder="Confirmation Mot de Passe" class="form-control"
								type="password">
						</div>
					</div>
				</div>

				<div align="center" id="erreurs"></div>
				<br />
				<!-- Button -->
				<div class="form-group">
					<label class="col-xl-4 col-lg-4 col-md-4 col-sm-4 control-label"></label>
					<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 ">
						<button type="button" class="btn btn-success" id="retour" onclick="location.href='<%=request.getContextPath()%>/'" >Retour</button>
					</div>
					<div class="col-xl-2 col-lg-2 col-md-2 col-sm-2 ">
						<button type="submit" class="btn btn-success" onclick="return validFormInscription()">Valider</button>
					</div>
				</div>
				<br />
					<span>* minimum 4 caract�res, maximum 10 caract�res, lettres, chiffres, "@", "_" et "&" accept�s.</span>
			</fieldset>
		</form>
	</div>

	
	<%@ include file="../../jspf/bas.frag"%>
	
	<script>
	
	$( document ).ready(function() {
		var NbIdentifdiant = $('#longueurListeLogin').val();
		for (var i = 0; i < NbIdentifdiant; i++) {
			listeIdentifiantsReserves[i] = $('#login_'+i).val();
		}
		
	});
		

		
	</script>