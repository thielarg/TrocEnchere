package fr.eni.encheres.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import fr.eni.encheres.erreurs.DALException;

/**
 * <font color="red">Classe</font> definissant les methodes permettant d'obtenir une connexion 
 * du pool de connexion ou de liberer la connexion afin de la remettre 
 * dans le pool de connexion
 * @author Thierry
 *
 */
public abstract class ConnexionProvider {

	//attributs
	private static DataSource ds;
	
	/**
	 * au chargement de la classe, la dataSource est recherchée dans l'arbre JNDI
	 */
	static {
		InitialContext jndi;
		try {
			jndi = new InitialContext();
			ConnexionProvider.ds = (DataSource) jndi.lookup("java:comp/env/poolEncheres");
		} catch (NamingException e) {
			throw new RuntimeException("impossible d'acceder à la BDD");
		}
		
	}
	
	/**
	 * <font color="green">Methode</font> permettant d'obtenir une connexion à la BDD via un pool de connexion
	 * @return une instance de type Connection
	 * @throws DALException - exception de type DALException
	 */
	public static Connection seConnecter() throws DALException {
		Connection cnx = null;
		//--> obtention de la connexion à la BDD à partir de la datasource
			try {
				cnx= ConnexionProvider.ds.getConnection();
			} catch (SQLException e) {
				throw new DALException("Impossible d'obtenir une connexion", e);
			}
			
		return cnx;
	}
	
	/**
	 * <font color="green">Methode</font> surchargée permettant de liberer la connexion et de la remettre dans le pool de connexion
	 * @param cnx - une instance de type Connection
	 * @throws DALException - exception de type DALException
	 */
	public static void seDeconnecter(Connection cnx) throws DALException {
		try {
			if (cnx!= null) {
				cnx.close();
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de fermer la connexion", e);
		}
	}


	/**
	 * <font color="green">Methode</font> surchargée permettant de liberer la connexion et 
	 * de la remettre dans le pool de connexion
	 * @param cnx - une instance de type Connection
	 * @param stmt - une instance de type Statement
	 * @throws DALException - exception de type DALException
	 */
	public static void seDeconnecter(Statement stmt, Connection cnx) throws DALException {
		try {
			if (stmt!= null) {
				stmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de fermer le statement", e);
		}
		
		seDeconnecter(cnx);
	}


	/**
	 * <font color="green">Methode</font> surchargée permettant de liberer la connexion et 
	 * de la remettre dans le pool de connexion
	 * @param cnx - une instance de type Connection
	 * @param stmt - une instance de type Statement
	 * @throws DALException - exception de type DALException
	 */
	public static void seDeconnecter(PreparedStatement pstmt, Connection cnx) throws DALException {
		try {
			if (pstmt!= null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			throw new DALException("Impossible de fermer le preparedStatement", e);
		}
		
		seDeconnecter(cnx);
	}

}












