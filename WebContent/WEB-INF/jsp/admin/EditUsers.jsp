<%@ include file="../../jspf/haut.frag"%>

<div class="row">

	<div class="col-xl-2 col-lg-2 col-md-2">
		<ul class="nav nav-pills nav-stacked">
			<li><a href="<%=request.getContextPath()%>/admin/liste_inscrits">Liste
					des inscrits</a></li>
			<li class="active"><a>Gestion des Utilisateurs</a></li>
			<li><a href="#">G�rer les forums</a></li>
			<li><a href="#">G�rer les calendriers</a></li>
			<li><a href="#">G�rer les projets</a></li>.
			<li><a href="#">...</a></li>
		</ul>
	</div>

	<div class="col-xl-10 col-lg-10 col-md-10">

		<c:set var="personne" value="${requestScope['residentSelected']}" />
		<h4>
			Edition de la fiche de <span id="profilResident">${personne.prenom}
				${personne.nom}</span>
		</h4>

		
	<form align="center" method="POST" action="<%=request.getContextPath()%>/admin/edit_users" id="editUser" >
		<label for="role">Changer de r�le ?</label> 
		<select name="role">
			<c:forEach var="role" items="${requestScope['listeRoles']}">
				<c:choose>
					<c:when test="${role.id == personne.role.id}">
						<option value="${role.id}" selected="selected">${role.libelle}</option>
					</c:when>
					<c:otherwise>
						<option value="${role.id}">${role.libelle}</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> 
		<br /> 
		<label for="actif">Activer le compte ? </label> 
		<select	name="actif">
			<c:if test="${personne.actif}">
				<option value="oui" selected>Oui</option>
				<option value="non">Non</option>
			</c:if>
			<c:if test="${not personne.actif}">
				<option value="oui">Oui</option>
				<option value="non" selected>Non</option>
			</c:if>
		</select> 
		<br /> 

			<input type="hidden" name="idRresident"	value="${personne.id}" />
		<div id="navButton">
			<a href="<%=request.getContextPath()%>/admin/liste_inscrits" class="btn btn-primary">Retour</a>
			<button type="submit" class="btn btn-primary" id="Enregistrer">Enregistrer</button>
		</div>
		</form>

	</div>

</div>


<%@ include file="../../jspf/bas.frag"%>


