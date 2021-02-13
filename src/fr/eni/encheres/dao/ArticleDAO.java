package fr.eni.encheres.dao;

import java.util.ArrayList;

import fr.eni.encheres.beans.Article;
import fr.eni.encheres.erreurs.DALException;

/**
 * <font color="red">Interface</font> definissant les methodes pour gerer le cycle de vie 
 * du modele metier Article<br>
 * Elle comporte donc les signatures des methodes CRUD
 * @author Thierry
 *
 */
public interface ArticleDAO {

	/**
	 * <font color="green">Methode abstraite</font> pour lister tous les articles en mode deconnecté
	 * @param likeArticle
	 * @param idCategorie
	 * @return une liste typée Article
	 * @throws DALException  propage une exception de type DALException
	 */
	ArrayList<Article> rechercher(String likeArticle, int idCategorie) throws DALException;
	
	/**
	 * <font color="green">Methode abstraite</font> pour lister tous les articles en mode connecté
	 * @param likeArticle
	 * @param idCategorie
	 * @param type
	 * @param encheres
	 * @param ventes
	 * @return une liste typée Categorie
	 * @throws DALException  propage une exception de type DALException
	 */
	ArrayList<Article> rechercher(String likeArticle, int idCategorie, String type, String[] encheres, String[] ventes) throws DALException;
}
