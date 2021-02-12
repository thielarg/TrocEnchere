package fr.eni.encheres.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.beans.Utilisateur;
import fr.eni.encheres.dao.ConnexionProvider;
import fr.eni.encheres.dao.UtilisateurDAO;
import fr.eni.encheres.erreurs.DALException;

/**
 * 
 * @author Thierry
 *
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO
{
	//constantes
	public static final String SELECT_CONNEXION = "SELECT * FROM UTILISATEURS WHERE (pseudo=? or email=?) and mot_de_passe=?";

	
	/**
	 * <font color="green">methode public</font> permettant à l'utilisateur à se connecter à l'application<br>
	 * en utilisant un identifiant (<code>pseudo</code> ou <code>email</code>) et un mot de passe
	 * @param identifiant - pseudo ou email
	 * @param mot_de_passe
	 * @return un objet de type Utilisateur
	 * @throws DALException - une exception de type DALException
	 */
	@Override
	public Utilisateur connexionUtilisateur(String identifiant, String mot_de_passe) throws DALException
	{
		Utilisateur utilisateurConnecte = null;	
		Connection cnx = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		cnx = ConnexionProvider.seConnecter();
		
		try{
			//preparation de la requete
			pstmt = cnx.prepareStatement(SELECT_CONNEXION);
			pstmt.setString(1, identifiant);
			pstmt.setString(2, identifiant);
			pstmt.setString(3, mot_de_passe);
			//execution de la requete
			rs = pstmt.executeQuery();
			//recuperation du resultset et chargement d'un objet de type utilisateur avec seulement les informations
			//non sensibles
			utilisateurConnecte = recupUtilisateur(rs);
		}catch (SQLException e){
			new DALException("probleme methode connexionUtilisateur dans l'execution de la requete", e);
		}
		return utilisateurConnecte;
	}
	
	/**
	 * <font color="green">Methode privee</font> permettant de recuperer les données du resultset et d'hydrater un objet de type utilisateur 
	 * avec seulement les informations non sensibles
	 * @param rs - un objet de type ResultSet
	 * @return un objet de type Utilisateur
	 * @throws SQLException
	 */
	
	private Utilisateur recupUtilisateur(ResultSet rs) throws SQLException
	{	
		//J'instancie un utilisateur pour ne pas retourner du null
		Utilisateur utilisateurRecup = new Utilisateur();
		try
		{	
			//je considere que je ne dois recupérer qu'un enregistrement car l'email et le pseudo sont unique en BDD
			//attention à ne pas retourner le mot de passe dans l'objet
			if(rs.next())
			{
				utilisateurRecup.setPseudo(rs.getString("pseudo"));
				utilisateurRecup.setNom(rs.getString("nom"));
				utilisateurRecup.setPrenom(rs.getString("Prenom"));
				utilisateurRecup.setEmail(rs.getString("email"));
				utilisateurRecup.setTelephone(rs.getString("telephone"));
				utilisateurRecup.setRue(rs.getString("rue"));
				utilisateurRecup.setCodePostal(rs.getString("code_postal"));
				utilisateurRecup.setVille(rs.getString("ville"));
				utilisateurRecup.setCredit(rs.getInt("credit"));
				utilisateurRecup.setAdministrateur(rs.getBoolean("administrateur"));	
			}
		}
		catch (SQLException e)
		{
			new DALException("Problème dans la methode recupUtilisateur sur la recupération des données de l'utilisateur",e);
		}
	return utilisateurRecup;
	}
	
	
	/**
	 * M�thode permettant d'ajouter un Utilsateur dans la base de donn�e en prenant en param�tre un objet de type Utilisateur
	 * @param utilisateur
	 */
/*	
	public void add(Utilisateur utilisateur) {
		DbConnexion dbConnexion = new DbConnexion();
		
		String sql = "insert into UTILISATEURS "
				+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) \r\n"
				+ "VALUES ( ?,?,?,? , ?,?,?,? , ?,?,? )";
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
				
			pStat.setString(1, utilisateur.getPseudo() );
			pStat.setString(2, utilisateur.getNom() );
			pStat.setString(3, utilisateur.getPrenom() );
			pStat.setString(4, utilisateur.getEmail() );
			pStat.setString(5, utilisateur.getTelephone() );
			pStat.setString(6, utilisateur.getRue() );
			pStat.setString(7, utilisateur.getCodePostal() );
			pStat.setString(8, utilisateur.getVille() );
			pStat.setString(9, utilisateur.getMotDePasse() );
			pStat.setInt(10, utilisateur.getCredit() );
			pStat.setBoolean(11, utilisateur.isAdministrateur() );
			
			pStat.executeUpdate() ;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/	
	/**
	 * M�thode permettant de modifier un Utilsateur dans la base de donn�e en prenant en param�tre un objet de type Utilisateur
	 * @param utilisateur
	 */
/*	
	public void modify(Utilisateur utilisateur) {
		DbConnexion dbConnexion = new DbConnexion();
		
		String sql = "UPDATE UTILISATEURS " + 
				"SET pseudo = ? ,"
				+ " nom = ? ,"
				+ " prenom = ? "
				+ ", email = ? "
				+ ", telephone = ? "
				+ ", rue = ? "
				+ ", code_postal = ? "
				+ ", ville = ? "
				+ ", mot_de_passe = ? "
				+ ", credit = ? "
				+ ", administrateur = ? " + 
				" WHERE no_utilisateur = ?";
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
				
			pStat.setString(1, utilisateur.getPseudo() );
			pStat.setString(2, utilisateur.getNom() );
			pStat.setString(3, utilisateur.getPrenom() );
			pStat.setString(4, utilisateur.getEmail() );
			pStat.setString(5, utilisateur.getTelephone() );
			pStat.setString(6, utilisateur.getRue() );
			pStat.setString(7, utilisateur.getCodePostal() );
			pStat.setString(8, utilisateur.getVille() );
			pStat.setString(9, utilisateur.getMotDePasse() );
			pStat.setInt(10, utilisateur.getCredit() );
			pStat.setBoolean(11, utilisateur.isAdministrateur() );
			pStat.setInt(12, utilisateur.getNoUtilisateur() );
			
			pStat.executeUpdate() ;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/	
	/**
	 * M�thode permettant d'ajouter des credit � un Utilsateur dans la base de donn�e en prenant en
	 * param�tre un objet de type Utilisateur et int credit
	 * @param utilisateur
	 * @param credits
	 */
/*	
	public void ajouterCredits(Utilisateur utilisateur, int credits) {
		DbConnexion dbConnexion = new DbConnexion();
		
		String sql = "UPDATE UTILISATEURS " + 
				"SET credit = credit + ? " +
				" WHERE no_utilisateur = ?";
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
				
			pStat.setInt(1, credits );
			pStat.setInt(2, utilisateur.getNoUtilisateur() );
			
			pStat.executeUpdate() ;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/	
	/**
	 * Surcharge de m�thode permettant de supprimer un Utilisateur dans la base de donn�e en prenant en param�tre
	 * un objet de type Utilisateur
	 * @param utilisateur
	 */
/*	
	public void delete(Utilisateur utilisateur) {
		delete(utilisateur.getNoUtilisateur());
	}
*/	
	/**
	 * M�thode permettant de supprimer un Utilisateur dans la base de donn�e en prenant en param�tre un int id
	 * pour retrouver l'utilisateur
	 * @param id
	 */
/*
	public void delete(int id) {
		DbConnexion dbConnexion = new DbConnexion();
		
		String sql = "DELETE FROM UTILISATEURS " + 
				"WHERE no_utilisateur = ?";
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
				
			pStat.setInt(1, id );
			
			pStat.executeUpdate() ;
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
*/	
	/**
	 * M�thode permettant de recupperer tout les utilisateurs dans la base de donn�e
	 * et les renvoyant dans une liste d'Utilisateur
	 * @return liste d'objet de type Utilisateur
	 * @throws SQLException
	 */
/*	
	public List<Utilisateur> getAll() throws SQLException {
		DbConnexion dbConnexion = new DbConnexion();
		ResultSet rs = null;
		
		List<Utilisateur> utilisateurs = new ArrayList<>();
		
		String sql = "select * from UTILISATEURS " ;
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
				rs = pStat.executeQuery();
				
				if (rs != null) {
					boolean bool = true;
					while (bool) {
						Utilisateur utilisateur = mappage(rs);
						
						if (utilisateur == null) { // = null si il n'y a plus de ligne dans le rs, on ne peut pas test rs.next() car il y en a un aussi dans le mappage et on sauterai donc une ligne sur 2
							bool = false;
						} else {
							utilisateurs.add(utilisateur);
						}
						
						
					}
				}
				
		}catch ( Exception exception )  {
			throw new RuntimeException( exception );
		}
		
		
		return utilisateurs;
	}
*/	
	/**
	 * M�thode permettant de recuperer un Utilisateur dans la base de donn�e en prenant en param�tre un int no_utilisateur
	 * @param no_utilisateur
	 * @return un objet de type Utilisateur
	 * @throws SQLException
	 */
/*	
	public Utilisateur get(int no_utilisateur) throws SQLException {
		DbConnexion dbConnexion = new DbConnexion();
		ResultSet rs = null;
		
		Utilisateur utilisateur = null;
		
		String sql = "select * from UTILISATEURS " 
				+ " where no_utilisateur = ?" ;
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
			pStat.setInt(1, no_utilisateur );
			rs = pStat.executeQuery();
			
			if (rs != null ) {
				utilisateur = mappage(rs);
			}
				
		}catch ( Exception exception )  {
			throw new RuntimeException( exception );
		}
		
		
		return utilisateur;
	}
*/	
	/**
	 * Surcharge de m�thode permettant de recuperer un Utilisateur dans la base de donn�e en prenant en param�tre
	 * un objet de String representant le pseudo de l'utilisateur
	 * @param pseudo
	 * @return un objet de type Utilisateur
	 * @throws SQLException
	 */
/*
	public Utilisateur get(String pseudo) throws SQLException {
		DbConnexion dbConnexion = new DbConnexion();
		ResultSet rs = null;
		
		Utilisateur utilisateur = null;
		
		String sql = "select * from UTILISATEURS " 
				+ " where pseudo = ?" ;
		
		try ( Connection connection = dbConnexion.seConnecter() ; PreparedStatement pStat = connection.prepareStatement(sql) ){
			pStat.setString(1, pseudo );
			rs = pStat.executeQuery();
			
			if (rs != null ) {
				utilisateur = mappage(rs);
			}
				
		}catch ( Exception exception )  {
			throw new RuntimeException( exception );
		}
		
		
		return utilisateur;
	}
*/	
}
