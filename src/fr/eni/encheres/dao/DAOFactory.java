package fr.eni.encheres.dao;

import fr.eni.encheres.dao.jdbc.impl.UtilisateurDAOJdbcImpl;

public class DAOFactory {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
