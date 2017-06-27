<%@ include file="../../jspf/haut.frag" %>

		<div class="row">
		
			<div class="col-xl-2 col-lg-2 col-md-2">
					<ul class="nav nav-pills nav-stacked">
					  <li><a href="<%=request.getContextPath()%>/admin/liste_inscrits">Liste des inscrits</a></li>
					  <li class="active"><a>Gestion des Utilisateurs</a></li>
					  <li><a href="#">Gérer les forums</a></li>
					  <li><a href="#">Gérer les calendriers</a></li>
					  <li><a href="#">Gérer les projets</a></li>.
					  <li><a href="#">...</a></li>
					</ul>
		  	</div>
		
			<div class="col-xl-10 col-lg-10 col-md-10">
				<div id="erreurs">
					${requestScope['generationCompteEchouee']}
				</div>	
				
				<div id="succes">
					${requestScope['generationCompteReussie']}
				</div>	
				
				
				<h4>Nombre d'identidiants temporaires encore non-utilisés : <span class="badge badge-default badge-pill">${fn:length(listeUtilisateursTemporaires)}</span></h4>
					<table class="table">
    				<thead>
      					<tr>
					        <th>login</th>
					        <th>password</th>
					        <th>Email d'attribution</th>
					        <th>Opérations</th>
     					</tr>
    				</thead>
    				<tbody>
    				<c:set var="listeUtilisateursTemporaires" value="${requestScope['listeUtilisateursTemporaires']}" />
    					<c:forEach var="comptetemp" items="${requestScope['listeUtilisateursTemporaires']}">
								<tr>
									<form action="" method="POST" >
										<input type="hidden" name="idCompteTemp" value="${comptetemp.id}"/>
										<td>${comptetemp.champs1}</td>
		    							<td>${comptetemp.champs2}</td>
			    						<td><input type="email" name="email" size="50px" /></td>
			    						<td><input type="button" class="btn btn-primary" name="attribuer" value="Attribuer"/></td>
			    						</form>		    							
    							</tr>
    						
    					</c:forEach>
    				</tbody>
    				</table>
				<br />			
						
        		<h4>Générer des nouveaux identidiants temporaires (50 max.)</h4>
				
				<br />
								
				<form method="post" action="<%=request.getContextPath()%>/admin/generer_compte_temp" >
					<label>Combien en faut-il ?</label>
					<input type="number" name="nbrIdToGenerate"  min="1" max="50" />
					<input type="submit" class="btn btn-primary" value="Générer" name="generateId" />
				</form>
				

				
			</div>

		</div>
		
<%@ include file="../../jspf/bas.frag" %>
		