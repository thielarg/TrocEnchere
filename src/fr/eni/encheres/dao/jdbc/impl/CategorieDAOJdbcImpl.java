package fr.eni.encheres.dao.jdbc.impl;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.eni.encheres.beans.Categorie;
import fr.eni.encheres.dao.CategorieDAO;
import fr.eni.encheres.dao.ConnexionProvider;
import fr.eni.encheres.erreurs.DALException;

/**
 * <font color="red">Classe</font> implementant les methodes le l'interface CategorieDAO<br> pour gerer le cycle de vie 
 * du modele metier Categorie<br>
 * @author Thierry
 *
 */
public class CategorieDAOJdbcImpl implements CategorieDAO {

	//constantes
	private static final String LISTER = "SELECT no_categorie, libelle FROM categories;";

	/**
	 * <font color="green">Methode</font> permettant de lister toutes les categories
	 * @return La liste peut etre vide mais jamais <code>null</code>
	 * @throws DALException  propage une exception de type DALException
	 * @finally libere les connexions ouvertes
	 */

	@Override
	public ArrayList<Categorie> lister() throws DALException{
		ArrayList<Categorie> listeCategorie = new ArrayList<>();
		Connection cnx=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		cnx = ConnexionProvider.seConnecter();

		try{
			stmt=cnx.createStatement();
			rs=stmt.executeQuery(LISTER);
			while (rs.next()){
				Categorie categorie = new Categorie();
				rs.getString("libelle");
				if (rs.wasNull())
					categorie.setLibelle("inconnu");
				else
					categorie.setLibelle(rs.getString("libelle"));
				listeCategorie.add(categorie);
			}
		} catch (SQLException e) {
			throw new DALException("probleme methode lister dans l'execution de la requete"+e);
		}finally{
			ConnexionProvider.seDeconnecter(stmt, cnx);
		}
		return listeCategorie;

	}
	
}
