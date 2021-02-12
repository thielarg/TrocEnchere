<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="../fragments/entete.jsp"/>


<br>
<div class="row">
	<div class="col-sm-12 bg-success centrer">Liste des ench&egrave;res</div>
</div>
<br>
<div class="row">
	<p>Filtres :</p>
</div>
<div class="row">
	<form action="accueil.html" method="post">
		<div class="col-sm-6">
			<div class="input-group">
				<span class="input-group-addon glyphicon glyphicon-search"></span>
				<input name ="likeArticle" class="form-control input-sm" type="text" placeholder="Le nom de l'article contient">
			</div>
			Catégorie : 
			<select name="idCategorie" class="form-control input-sm" size="1">
<c:forEach var="categorie" items ="${sessionScope.categories }">
		<c:if test="${categorie.noCategorie == idCategorie }">				
				<option value="${categorie.noCategorie }" selected="selected" >${categorie.libelle }</option>
		</c:if>
		<c:if test="${categorie.noCategorie != idCategorie }">				
				<option value="${categorie.noCategorie }" >${categorie.libelle }</option>
		</c:if>
</c:forEach>
			</select>

<c:if test="${sessionScope.utilisateurConnecte != null }">
			<br>
			<table>
				<tr>
					<td><input type="radio" name="type" checked/>&nbsp;Achats</td>
					<td><input type="radio" name="type"/>&nbsp;Mes ventes</td>
				</tr>
				<tr>
					<td class="retrait"><input type="checkbox" name="encheres" value="eo" checked/>&nbsp;ench&egrave;res ouvertes</td>
					<td class="retrait gris"><input type="checkbox" name="ventes" value="mvec" disabled/>&nbsp;mes ventes en cours</td>
				</tr>
				<tr>
					<td class="retrait"><input type="checkbox" name="encheres" value="meec"/>&nbsp;mes ench&egrave;res en cours</td>
					<td class="retrait gris"><input type="checkbox" name="ventes" value="mvnd" disabled/>&nbsp;ventes non d&eacute;but&eacute;es</td>
				</tr>
				<tr>
					<td class="retrait"><input type="checkbox" name="encheres" value="mer"/>&nbsp;mes ench&egrave;res remport&eacute;es</td>
					<td class="retrait gris"><input type="checkbox" name="ventes" value="vt" disabled/>&nbsp;ventes termin&eacute;es</td>
				</tr>
			</table>
</c:if>
		</div>
		<div class="col-sm-6">
			<input class="btn btn-primary btn-lg margeExt" type="submit" value="Rechercher">
		</div>
	</form>
	</div>
<c:if test="${!empty message }">
	<div class="row">
		<p class="alert alert-warning margeExt">${message }</p>
	</div>
</c:if>

<!-- pagination des articles -->
<c:if test="${!first }">
	<hr>
	<c:forEach var="article" items="${articles }" varStatus="status">
	
		<c:if test="${status.count mod 2 != 0 }">
	<div class="row">
		<div class="col-sm-5 cadre">
			<div class="col-sm-4 ">
				<img alt="image" src="images/logoENI.png" class="img-rounded"><br>
			</div>
			<div class="col-sm-8">
				<p>${article.nomArticle }</p>
				<p>Prix : ${article.miseAPrix } points <br>Fin de l'ench&egrave;re : 
				<fmt:formatDate value="${article.dateFinEncheres}" pattern="dd/MM/yyyy" /></p>
				<p>Vendeur : ${article.utilisateur.pseudo }</p>
			</div>
		</div>
		<div class="col-sm-2"></div>
			<c:if test="${status.count==nbre }">
	</div>
			</c:if>
		</c:if>
		
		<c:if test="${status.count mod 2 == 0 }">
	<div class="col-sm-5 cadre">
		<div class="col-sm-4 ">
			<img alt="image" src="images/logoENI.png" class="img-rounded"><br>
		</div>
		<div class="col-sm-8">
			<p>${article.nomArticle }</p>
			<p>Prix : ${article.miseAPrix } points <br>Fin de l'ench&egrave;re : 
			<fmt:formatDate value="${article.dateFinEncheres}" pattern="dd/MM/yyyy" /></p>
			<p>Vendeur : ${article.utilisateur.pseudo }</p>
		</div>
	</div>
</div>
<br>
		</c:if>
	</c:forEach>
</c:if>
		<div class="row">
			<div class="col-sm-12 petit centrer">
				<hr>
				Copyright &copy; ENI Ecole Informatique - <span class="glyphicon glyphicon-hand-right"></span>&nbsp;infos l&eacute;gales
			</div>
		</div>
	</div>



</div> <!-- fin container -->
</div> <!-- fin du bloc page -->

</body>
</html>