<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../fragments/fragmentHaut.jsp"></jsp:include>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12 bg-primary">ENI-Encheres</div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-12 bg-success texteCentrer">Mon profil</div>
		</div>
		<br>
		<form action="./CompteServlet" method="post">
			<div class="row">
				<div class="col-sm-2 texteGauche">Pseudo: *</div>
<c:if test="${!empty erreurPseudo }">
				<div class="col-sm-2"><input name="pseudo" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurPseudo }</div>
</c:if>
<c:if test="${empty erreurPseudo }">
				<c:if test="${!empty utilisateur.pseudo }">
					<div class="col-sm-2"><input name="pseudo" type="text" value="${utilisateur.pseudo }"></div>
				</c:if>
				<c:if test="${empty utilisateur.pseudo }">
					<div class="col-sm-2"><input name="pseudo" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>
				<div class="col-sm-2 texteGauche">Nom: *</div>
<c:if test="${!empty erreurNom }">
				<div class="col-sm-2"><input name="nom" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurNom }</div>
</c:if>
<c:if test="${empty erreurNom }">
				<c:if test="${!empty utilisateur.nom }">
					<div class="col-sm-2"><input name="nom" type="text" value="${utilisateur.nom }"></div>
				</c:if>
				<c:if test="${empty utilisateur.nom }">
					<div class="col-sm-2"><input name="nom" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>
			</div>
			<br>	
			<div class="row">
				<div class="col-sm-2 texteGauche">Pr&eacute;nom: *</div>
<c:if test="${!empty erreurPrenom }">
				<div class="col-sm-2"><input name="prenom" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurPrenom }</div>
</c:if>
<c:if test="${empty erreurPrenom }">
				<c:if test="${!empty utilisateur.prenom }">
					<div class="col-sm-2"><input name="prenom" type="text" value="${utilisateur.prenom }"></div>
				</c:if>
				<c:if test="${empty utilisateur.prenom }">
					<div class="col-sm-2"><input name="prenom" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>
				<div class="col-sm-2 texteGauche">Email: *</div>
<c:if test="${!empty erreurEmail }">
				<div class="col-sm-2"><input name="email" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurEmail }</div>
</c:if>
<c:if test="${empty erreurEmail }">
				<c:if test="${!empty utilisateur.email }">
					<div class="col-sm-2"><input name="email" type="text" value="${utilisateur.email }"></div>
				</c:if>
				<c:if test="${empty utilisateur.email }">
					<div class="col-sm-2"><input name="email" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>			
			</div>
			<br>	
			<div class="row">
				<div class="col-sm-2 texteGauche">T&eacute;l&eacute;phone: </div>
				<c:if test="${!empty utilisateur.telephone }">
					<div class="col-sm-2"><input name="telephone" type="text" value="${utilisateur.telephone }"></div>
				</c:if>
				<c:if test="${empty utilisateur.telephone }">
					<div class="col-sm-2"><input name="telephone" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
				<div class="col-sm-2 texteGauche">Rue: *</div>
<c:if test="${!empty erreurRue }">
				<div class="col-sm-2"><input name="rue" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurRue }</div>
</c:if>
<c:if test="${empty erreurRue }">
				<c:if test="${!empty utilisateur.rue }">
					<div class="col-sm-2"><input name="rue" type="text" value="${utilisateur.rue }"></div>
				</c:if>
				<c:if test="${empty utilisateur.rue }">
					<div class="col-sm-2"><input name="rue" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>			
			</div>
			<br>	
			<div class="row">
				<div class="col-sm-2 texteGauche">Code postal: *</div>
<c:if test="${!empty erreurCP }">
				<div class="col-sm-2"><input name="codePostal" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurCP }</div>
</c:if>
<c:if test="${empty erreurCP }">
				<c:if test="${!empty utilisateur.codePostal }">
					<div class="col-sm-2"><input name="codePostal" type="text" value="${utilisateur.codePostal }"></div>
				</c:if>
				<c:if test="${empty utilisateur.codePostal }">
					<div class="col-sm-2"><input name="codePostal" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>			
				<div class="col-sm-2 texteGauche">Ville: *</div>
<c:if test="${!empty erreurVille }">
				<div class="col-sm-2"><input name="ville" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurVille }</div>
</c:if>
<c:if test="${empty erreurVille }">
				<c:if test="${!empty utilisateur.ville }">
					<div class="col-sm-2"><input name="ville" type="text" value="${utilisateur.ville }"></div>
				</c:if>
				<c:if test="${empty utilisateur.ville }">
					<div class="col-sm-2"><input name="ville" type="text"></div>
				</c:if>
				<div class="col-sm-2"></div>
</c:if>			
			</div>
			<br>	
			<div class="row">
				<div class="col-sm-2 texteGauche">Mot de passe: *</div>
<c:if test="${!empty erreurPwd }">
				<div class="col-sm-2"><input name="motDePasse" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurPwd }</div>
</c:if>
<c:if test="${empty erreurPwd }">
				<div class="col-sm-2"><input name="motDePasse" type="text"></div>
				<div class="col-sm-2"></div>
</c:if>			
				<div class="col-sm-2 texteGauche">Confirmation: *</div>
<c:if test="${!empty erreurConf }">
				<div class="col-sm-2"><input name="motDePasseConf" type="text" autofocus="autofocus"></div>
				<div class="col-sm-2 text-danger taille">${erreurConf }</div>
</c:if>
<c:if test="${empty erreurConf }">
				<div class="col-sm-2"><input name="motDePasseConf" type="text"></div>
				<div class="col-sm-2"></div>
</c:if>			
			</div>
			<br>
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-1">
					<input class="btn btn-primary btn-lg margeExt" name="choix" type="submit" value="Creer">&nbsp;
				</div>
				<div class="col-sm-1"></div>
				<div class="col-sm-1">
					<input class="btn btn-primary btn-lg margeExt" name="choix" type="submit" value="Annuler">
				</div>
				<div class="col-sm-4"></div>
			</div>	
		</form>
<c:if test="${!empty erreur }">
		<div class="row">
			<div class="col-sm-12 text-danger taille">${erreur }</div>
		</div>
</c:if>
	</div>
<jsp:include page="../fragments/fragmentBas.jsp"></jsp:include>
