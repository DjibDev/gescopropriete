<%@ include file="../../jspf/haut.frag" %>

		<div class="row">
		
			<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3">
					<ul class="nav nav-pills nav-stacked">
					  <li class="active"><a>Liste des inscrits</a></li>
					  <li><a href="<%=request.getContextPath()%>/admin/gestion_user">Gestion des Utilisateurs</a></li>
					  <li><a href="#">G�rer les forums</a></li>
					  <li><a href="#">G�rer les calendriers</a></li>
					  <li><a href="#">G�rer les projets</a></li>.
					  <li><a href="#">...</a></li>
					</ul>
		  	</div>
		
			<div class="col-xl-9 col-lg-9 col-md-9 col-sm-9">
			
        		<h4>R�sultats trouv�(s) <span class="badge badge-default badge-pill">${fn:length(listeResidents)}</span></h4><br />
				  <table class="table table-striped">
    				<thead>
      					<tr>
					        <th>Nom</th>
					        <th>Pr�nom</th>
					        <th>Identifiant</th>
					        <th>Email</th>
					        <th>T�l�phone</th>
					        <th>Appartement</th>
					        <th>Statut</th>
					        <th>Date d'inscription</th>
							<th>Type D'acc�s</th>
							
      					</tr>
    				</thead>
    				<tbody>
    				<c:set var="listeResidents" value="${requestScope['listeResidents']}" />
    					<c:forEach var="personne" items="${requestScope['listeResidents']}">
    						<c:choose>
    							<c:when test="${not personne.actif}">
    								<tr class="inactif">
    							</c:when>		
    							<c:otherwise>
    								<tr class="actif">
    							</c:otherwise>	
    						</c:choose>
	    							<td>${personne.nom}</td>
	    							<td>${personne.prenom}</td>
	    							<td>${personne.login}</td>
	    							<td>${personne.email}</td>
	    							<td>${personne.tel}</td>
	    							<td>${personne.appartement.batiment.adresse}, �tage ${personne.appartement.etage}, porte ${personne.appartement.porte}</td>
	    							<td>${personne.type_res}</td>
	    							<td>${personne.date_inscription}</td>
	    							<td>${personne.role.libelle}</td>
	    							
    							</tr>
    						
    					</c:forEach>
    				</tbody>
    				</table>
			</div>

		</div>
		
<%@ include file="../../jspf/bas.frag" %>
		