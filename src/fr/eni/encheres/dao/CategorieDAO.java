package fr.eni.encheres.dao;

import java.util.ArrayList;

import fr.eni.encheres.beans.Categorie;
import fr.eni.encheres.erreurs.DALException;

/**
 * <font color="red">Interface</font> definissant les methodes pour gerer le cycle de vie 
 * du modele metier Categorie<br>
 * Elle comporte donc les signatures des methodes CRUD
 * @author Thierry
 *
 */
public interface CategorieDAO {

	/**
	 * <font color="green">Methode abstraite</font> pour lister toutes les categories
	 * @return une liste typée Categorie
	 * @throws DALException  propage une exception de type DALException
	 */
	ArrayList<Categorie> lister() throws DALException;

}
