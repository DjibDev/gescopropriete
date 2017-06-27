<%@ include file="../../jspf/haut.frag"%>

<div class="row">

	<div class="col-xl-2 col-lg-2 col-md-2">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><a>Liste des inscrits</a></li>
			<li><a href="<%=request.getContextPath()%>/admin/gestion_user">Gestion
					des Utilisateurs</a></li>
			<li><a href="#">Gérer les forums</a></li>
			<li><a href="#">Gérer les calendriers</a></li>
			<li><a href="#">Gérer les projets</a></li>.
			<li><a href="#">...</a></li>
		</ul>
	</div>

	<div class="col-xl-10 col-lg-10 col-md-10">

		<h4>
			Résultats trouvé(s) <span class="badge badge-default badge-pill">${fn:length(listeResidents)}</span>
		</h4>
		<br />
		<table
			class="table table-striped table-condensed table-bordered sortable"
			id="lstInscrits">
			<thead>
				<tr>
					<th>Nom</th>
					<th>Prénom</th>
					<th>Identifiant</th>
					<th>Email</th>
					<th>Téléphone</th>
					<th>Appartement</th>
					<th>Statut</th>
					<th>Inscrit le</th>
					<th>Type D'accès</th>
					<th>Actif</th>
					<th>Sélection</th>

				</tr>
			</thead>
			<tbody>
				<c:set var="listeResidents"
					value="${requestScope['listeResidents']}" />
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
					<td>${personne.appartement.batiment.adresse},étage
						${personne.appartement.etage}, porte ${personne.appartement.porte}</td>
					<td>${personne.type_res}</td>
					<td>${personne.date_inscription}</td>
					<td>${personne.role.libelle}</td>
					<c:if test="${personne.actif}">
						<td>oui</td>
					</c:if>
					<c:if test="${not personne.actif}">
						<td>non</td>
					</c:if>
					<form method="GET" action="<%=request.getContextPath()%>/admin/edit_users" />
						<input type="hidden" name="idResident" value="${personne.id}" />
						<td><input type="submit" class="btn btn-primary" id="Editer" Value="Editer" /></td>
					</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>


<%@ include file="../../jspf/bas.frag"%>


