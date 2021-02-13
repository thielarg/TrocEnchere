<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>Troc Encheres</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap-3.3.7/dist/css/bootstrap.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css">
	</head>
	<body>
		<div class="container">
			<div class="bloc_page">
				<header>
				<div class="row">
<c:if test="${sessionScope.utilisateurConnecte == null }">
					<div class="col-sm-9">
						<a href="accueil.html"><div class="logo"></div></a>
					</div>
					<div class="col-sm-3 align_haut">
						<a href="./CreerCompte">S&acute;inscrire</a> - <a href="authentification.html">Se connecter</a>
					</div>

</c:if>
<c:if test="${sessionScope.utilisateurConnecte != null }">
					<div class="col-sm-7">
						<a href="accueil.html"><div class="logo"></div></a>
					</div>
					<div class="col-sm-5 align_haut">
						<a href="#">Ench&egrave;res</a> - <a href="#">Vendre un article</a> - <a href="#">Mon profil</a> - <a href="./DeconnexionServlet">D&eacute;connexion</a>
					</div>
</c:if>		</div>

				</div>
				</header>