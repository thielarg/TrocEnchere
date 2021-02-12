package fr.eni.encheres.dao;

import fr.eni.encheres.beans.Utilisateur;
import fr.eni.encheres.erreurs.DALException;

/**
 * 
 * @author Thierry
 *
 */
public interface UtilisateurDAO {

	/**
	 * <font color="green">Methode public abstraite</font> permettant de se connecter à l'application
	 * @param identifiant
	 * @param mot_de_passe
	 * @return un objet de type Utilisateur
	 * @throws DALException
	 */
	Utilisateur connexionUtilisateur(String identifiant, String mot_de_passe) throws DALException;

}
