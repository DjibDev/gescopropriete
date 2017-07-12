<%@ include file="../../jspf/haut.frag"%>

<div class="row">

	<div class="col-xl-2 col-lg-2 col-md-2">
		<ul class="nav nav-pills nav-stacked">
			<li><a href="<%=request.getContextPath()%>/admin/liste_inscrits">Liste
					des inscrits</a></li>
			<li><a href="<%=request.getContextPath()%>/admin/gestion_user">Gestion
					des Utilisateurs</a></li>
			<li><a href="#">Gérer les forums</a></li>
			<li class="active"><a href="#">Gérer les calendriers</a></li>
			<li><a href="#">Gérer les projets</a></li>.
			<li><a href="#">...</a></li>
		</ul>
	</div>

	<div class="col-xl-10 col-lg-10 col-md-10">
			<h4>
			Nombre d'activité(s) <span class="badge badge-default badge-pill">${fn:length(listeActivites)}</span>
		</h4>
		<br />
		<table class="table table-striped table-condensed table-bordered sortable"	id="listeActivites" >
			<thead>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Actif ?</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="listeActivites"
					value="${requestScope['listeActivites']}" />
				<c:forEach var="activite" items="${requestScope['listeActivites']}">
					<c:choose>
						<c:when test="${not activite.actif}">
							<tr class="inactif">
						</c:when>
						<c:otherwise>
							<tr class="actif">
						</c:otherwise>
					</c:choose>
					<td>${activite.id}</td>
					<td>${activite.libelle}</td>
					<c:if test="${activite.actif}">
						<td>oui</td>
					</c:if>
					<c:if test="${not activite.actif}">
						<td>non</td>
					</c:if>
					<form method="GET" action="" />
						<input type="hidden" name="idResident" value="${activite.id}" />
						<td><input type="submit" class="btn btn-primary" id="Editer" Value="Editer" /></td>
					</form>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</div>


<%@ include file="../../jspf/bas.frag"%>


