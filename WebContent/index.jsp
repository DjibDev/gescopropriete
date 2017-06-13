
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>   
<%@ page session="false" %>


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
		<img src="<%=request.getContextPath()%>/images/banniere_redim.png" id="imageBanniereAll">
	</div>
		<div class="row" >		
		
                <!--  echec du de l'authentification -->
				<br />
				<div id="erreurs" class="text-center">
					${requestScope['identificationEchouee']}
				</div>	
				<div id="succes" class="text-center">
					${requestScope['inscriptionReussie']}
				</div>	
				<br />
				
			<div class="panel panel-primary" id="loginForm">
				<div class="panel-heading text-center">Résidence des Tilleuls</div>
				<div class="panel-body">
					<br />
					<form class="form-signin" action="<%=request.getContextPath()%>/login/valider_acces" method="POST">
	        			<input type="login" class="form-control" name="login" placeholder="Identifiant" required autofocus>  
	        			<br />    		
	        			<input type="password" class="form-control"  id="password" name="password" placeholder="Mot de Passe" required>
	        			<br />
	        			<button class="btn btn-lg btn-primary btn-block" type="submit">Se Connecter</button>
 					</form>		
					<br />
				</div>
				
			</div>
		</div>
		
		<br /><br /><br /><br />
		
		<div class="row">
				<div class="footer col-sm-12 text-center">
		  			Développé par <a href="http://djibdev.net">djibdev.net</a>
				</div>
		</div>
		
</body>
</html>

