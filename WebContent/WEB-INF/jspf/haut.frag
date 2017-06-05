
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Résidence des Tilleuls</title>

  	<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/bootstrap/css/bootstrap.min.css">
  	<link rel="stylesheet" href="<%=request.getContextPath()%>/theme/css/style.css">
  
</head>
<body>

  	<div class="jumbotron text-center ">
		<div class="row">
			<div class="col-xl-10 col-lg-10 col-md-10">
				<img src="<%=request.getContextPath()%>/images/banniere_redim.png" id="imageBanniereAll">
			</div>
			
			<div class="col-xl-2 col-lg-2 col-md-2">
				<div id="infosUserConnecte">
					 <span class="glyphicon glyphicon-user"></span>
					 	<b>${sessionScope['residentConnecte'].prenom} ${sessionScope['residentConnecte'].nom}</b>
					 	<br />
					 <span class="glyphicon glyphicon-hand-right"></span>
						<b>${sessionScope['residentConnecte'].role.libelle}</b>
				</div>
	
				<div id="blocBoutons">
					<form method="POST" action="">
	            	<button type="submit" class="btn btn-primary center-block" id="moncompte" >Mon Compte</button>
	            	</form>
	            	
					<form method="POST" action="<%=request.getContextPath()%>/deconnexion">
	            	<button type="submit" class="btn btn-danger center-block" id="deconnexion" >Déconnexion</button>
	            	</form>
	            </div>	
			</div>
		</div>
	</div>