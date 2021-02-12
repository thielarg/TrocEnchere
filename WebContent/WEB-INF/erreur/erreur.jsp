<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../fragments/entete.jsp"></jsp:include>
<body>
		<div class="row">
			<div class="col-sm-11 bg-primary">ENI-Encheres</div>
			<div class="col-sm-1 bg-primary"><a href="./AuthentificationServlet">Retour</a></div>
		</div>
		<br>
		<div class="row">
			<div class="col-sm-3"></div>
			<div class="col-sm-6">
				<div class="alert alert-danger">
					<strong><span class="text-info">Erreur</span></strong>
					<br> <underline>Message :</underline> ${erreur.message }
					<br><strong><span class="text-info">Détail</span></strong>
					<br> Nom de la classe : ${erreur.stackTrace[0].className }
					<br> Nom de la méthode : ${erreur.stackTrace[0].methodName }
					<br> Nom du fichier : ${erreur.stackTrace[0].fileName }
					<br> Numéro de la ligne : ${erreur.stackTrace[0].lineNumber }
				</div>
			</div>
			<div class="col-sm-3"></div>
		</div>
		<br>
	</div>

<jsp:include page="../fragments/bas.jsp"></jsp:include>
