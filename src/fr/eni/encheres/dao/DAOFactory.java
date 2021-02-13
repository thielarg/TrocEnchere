package fr.eni.encheres.dao;

import fr.eni.encheres.dao.jdbc.impl.ArticleDAOJdbcImpl;
import fr.eni.encheres.dao.jdbc.impl.CategorieDAOJdbcImpl;
import fr.eni.encheres.dao.jdbc.impl.UtilisateurDAOJdbcImpl;

/**
 * <font color="red">Classe</font> permettant d'obtenir des instances de :
 * <ul><li>UtilisateurDAOJdbcImpl</li><li>CategorieDAOJdbcImpl</li></ul>
 * afin de permettre d'oter la dependance forte entre la couche BLL et la couche DAL.<br>
 * C'est ici que l'on instancie pour ne pas avoir à le faire dans la couche BLL.<br>
 * Ainsi en cas de changement de technologie, nous n'avons plus à recetter la couche BLL<br>
 * Cette classe comporte des methodes static qui renvoient le type de l'interface et non le type réel de l'instance.
 * Le fait que la methode soit static facilite l'appel à la méthode, puisqu'aucune instance de DAOFactory
 * n'est alors necessaire pour l'utiliser
 * @author Thierry
 *
 */
public class DAOFactory {

	/**
	 * <font color=green">Methode static</font> permettant d'obtenir une instance d'UtilisateurDAOJdbcImpl typée UtilisateurDAO
	 * @return une instance de type UtilisateurDAO
	 */
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	
	/**
	 * <font color=green">Methode static</font> permettant d'obtenir une instance de CategorieDAOJdbcImpl typée CategorieDAO
	 * @return une instance de type CategorieDAO
	 */
	public static CategorieDAO getCategorieDAO(){
		return new CategorieDAOJdbcImpl();
	}

	/**
	 * <font color=green">Methode static</font> permettant d'obtenir une instance de ArticleDAOJdbcImpl typée ArticleDAO
	 * @return une instance de type ArticleDAO
	 */
	public static ArticleDAO getArticleDAO(){
		return new ArticleDAOJdbcImpl();
	}
}
