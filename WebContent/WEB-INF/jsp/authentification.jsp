<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../fragments/entete.jsp"></jsp:include>

		<br>
		<div class="row">
			<div class="col-sm-12 bg-success centrer">Authentification</div>
		</div>
		<br>
		<form action="./authentification.html" method="post">
			<div class="row">
				<div class="col-sm-3"></div>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-6">
							<label>Identifiant : </label>
						</div>
						<div class="col-sm-6">	
							<input name ="identifiant" class="form-control input-sm" type="text" >
						</div>
					</div>
					<br>
					<div class="row">
						<div class="col-sm-6">
							<label>Mot de passe : </label>
						</div>
						<div class="col-sm-6">	
							<input name ="motDePasse" class="form-control input-sm" type="password" >
						</div>
					</div>
					<br>	
					<div class="row">
						<div class="col-sm-6">
							<input class="btn btn-primary" type="submit" value="Connexion">
						</div>
						<div class="col-sm-6">
							<input name="seSouvenir" type="checkbox">&nbsp;Se souvenir de moi <br>	
							<a href="#" class="text-succes" >Mot de passe oublié</a>
						</div>
					</div>
				</div>
				<div class="col-sm-3"></div>
			</div>		
		</form>
		<br>
<c:if test="${!empty erreur }">
		<div class="row">
			<div class="col-sm-12 alert alert-warning rouge">${erreur }</div>
		</div>
</c:if>
		<div class="row">
			<div class="col-sm-5"></div>
			<div class="col-sm-2">
				<form action="./CreerCompte" method="post">
					<input class="btn btn-primary btn-lg margeExt " type="submit" value="Cr&eacute;er un compte">
				</form>
			</div>
			<div class="col-sm-5"></div>
		</div>

<jsp:include page="../fragments/bas.jsp"></jsp:include>
